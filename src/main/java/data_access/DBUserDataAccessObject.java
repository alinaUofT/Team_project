package data_access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import entity.*;
import use_case.add_to_watchlist.AddToWatchlistDataAccessInterface;

import static com.mongodb.client.model.Filters.eq;

import use_case.create_watchlist.CreateWatchlistDataAccessInterface;
import use_case.home.HomeUserDataAccessInterface;
import use_case.leave_a_review.LeaveReviewDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.my_reviews.MyReviewsDataAccessInterface;
import use_case.recommendations.RecommendationsUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
import use_case.survey1.Survey1UserDataAccessInterface;
import use_case.survey_second_page.SurveySecondPageDataAccessInterface;
import use_case.watchlist.WatchlistUserDataAccessInterface;
import use_case.watchlists.WatchlistsUserDataAccessInterface;
import use_case.watchlists.rename.RenameUserDataAccessInterface;

/**
 * The DAO for user data.
 */
public class DBUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, HomeUserDataAccessInterface, MyReviewsDataAccessInterface,
        LogoutUserDataAccessInterface, WatchlistsUserDataAccessInterface, WatchlistUserDataAccessInterface,
        RecommendationsUserDataAccessInterface, LeaveReviewDataAccessInterface,
        Survey1UserDataAccessInterface, SurveySecondPageDataAccessInterface,
        CreateWatchlistDataAccessInterface, RenameUserDataAccessInterface, AddToWatchlistDataAccessInterface {

    private final CommonUserFactory userFactory;
    DataBaseConstructor database = new DataBaseConstructor();
    MongoCollection<Document> collection = database.GetCollection("Users");

    public DBUserDataAccessObject(CommonUserFactory userFactory) {
        this.userFactory = userFactory;
        // No need to do anything to reinitialize a user list! The data is the cloud that may be miles away.
    }

    @Override
    public User get(String username) {
        final Document userDocument = collection.find(eq("userId", username)).first();

        if (userDocument != null) {
            // Extract fields from the document
            final String name = userDocument.getString("username");
            final String password = userDocument.getString("password");

            // Create and return the User object
            return userFactory.create(name, password);
        } else {
            // Handle case where user is not found
            throw new RuntimeException("User with username '" + username + "' not found.");
        }
    }

    @Override
    public void setCurrentUsername(String name) {
        // this isn't implemented for the lab
    }

    @Override
    public boolean existsByName(String username) {
        final MongoCollection<Document> collection = DataBaseConstructor.GetCollection("Users");
        final FindIterable<Document> findIterable = collection.find(eq("userId", username));

        return findIterable.first() != null;
    }

    @Override
    public boolean movieExists(String movie) {
        return false;
    }

    @Override
    public void save(User user) {
        final Document newAccount = new Document("userId", user.getName())
                .append("username", user.getName())
                .append("password", user.getPassword());
        collection.insertOne(newAccount);

    }

    @Override
    public boolean saveWatchlist(User user, UserWatchlist watchlist) {
        boolean success = false;
        try {
            // Create a document representing the review
            Document watchlistDoc = new Document()
                    .append("watchlistName", watchlist.getListName())
                    .append("movies", watchlist.getMovies());


            collection.updateOne(
                    new Document("userId", user.getName()),
                    new Document("$push", new Document("watchlist", watchlistDoc))
            );

            success = true;
        } catch (Exception e) {
            System.err.println("Error adding watchlist to user: " + e.getMessage());
        }
        return success;
    }

    @Override
    public void saveToWatchlist(User user, Watchlist watchlist, Movie movie) {

        try {
            // Find the user's document in the collection
            final Document userDoc = collection.find(new Document("userId", user.getName())).first();

            if (userDoc != null) {
                // Retrieve the user's watchlists
                final List<Document> userWatchlists = (List<Document>) userDoc.get("watchlists");

                // Find the specific watchlist by name
                Document targetWatchlist = null;
                for (Document doc : userWatchlists) {
                    if (doc.getString("watchlistName").equals(watchlist.getListName())) {
                        targetWatchlist = doc;
                        break;
                    }
                }

                if (targetWatchlist != null) {
                    // Update the watchlist by adding the new movie
                    collection.updateOne(
                            new Document("userId", user.getName())
                                    .append("watchlists.watchlistName", watchlist.getListName()),
                            new Document("$push", new Document("watchlists.$.movies", movie.getTitle()))
                    );
                    System.out.println("Movie added to watchlist successfully!");
                } else {
                    System.err.println("Watchlist not found.");
                }
            } else {
                System.err.println("User not found.");
            }
        } catch (Exception e) {
            System.err.println("Error adding movie to watchlist: " + e.getMessage());
        }
    }

    /**
     * Leave a review for this user in the online DB.
     * @param review the review object to add to this user.
     * @return
     */
    public boolean leaveReview(MovieReview review) {
        final Document reviewDoc = new Document()
                    .append("movieTitle", review.getMovieTitle())
                    .append("date", review.getDate())
                    .append("starRating", review.getStarRating());

        if (review.getContent() != null) {
            reviewDoc.append("writtenReview", review.getContent());
        }

        collection.updateOne(
                    new Document("userId", review.getUserID()),
                    new Document("$push", new Document("reviews", reviewDoc))
        );

        return true;
    }


    /**
     * Retrieve the reviews for this user.
     * @param user a user of this program.
     * @return
     */

    public List<MovieReview> getReviews(User user) {

        final CommonMovieReviewFactory reviewFactory = new CommonMovieReviewFactory();

        final List<MovieReview> reviews = new ArrayList<>();

        final Document userDoc = collection.find(new Document("userId", user.getName())).first();

        if (userDoc != null) {
            final List<Document> rawReviews = (List<Document>) userDoc.get("reviews");

            if (rawReviews != null) {
                for (Document reviewDoc : rawReviews) {
                    final String username = userDoc.getString("userId");
                    final Date date = reviewDoc.getDate("date");
                    final Double starRating = reviewDoc.getDouble("starRating");
                    final String writtenReview = reviewDoc.getString("writtenReview");
                    final String movieTitle = reviewDoc.getString("movieTitle");

                    final MovieReview review;
                    if (writtenReview != null) {
                        review = reviewFactory.create(username, date, starRating, writtenReview, movieTitle);
                    } else {
                        review = reviewFactory.create(username, date, starRating, movieTitle);
                    }
                    reviews.add(review);
                }
            }
        }

        return reviews;
    }

    @Override
    public String getCurrentUsername() {
        return null;
    }
}
