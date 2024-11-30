package data_access;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import entity.*;
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

/**
 * The DAO for user data.
 */
public class DBUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, HomeUserDataAccessInterface, MyReviewsDataAccessInterface,
        LogoutUserDataAccessInterface, WatchlistsUserDataAccessInterface, WatchlistUserDataAccessInterface,
        RecommendationsUserDataAccessInterface, LeaveReviewDataAccessInterface,
        Survey1UserDataAccessInterface, SurveySecondPageDataAccessInterface,
        CreateWatchlistDataAccessInterface {

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
    public boolean saveWatchlist(User user, Watchlist watchlist) {
        try {
            // Create a document representing the review
            final Document watchlistDoc = new Document()
                    .append("watchlistName", watchlist.getListName());

            collection.updateOne(
                    new Document("userId", user),
                    new Document("$push", new Document("watchlist", watchlistDoc))
            );

            return true;
        } catch (Exception e) {
            System.err.println("Error adding watchlist to user: " + e.getMessage());
            return false;
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
