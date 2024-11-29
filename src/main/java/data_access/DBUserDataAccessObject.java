package data_access;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.*;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import use_case.create_watchlist.CreateWatchlistDataAccessInterface;
import use_case.home.HomeUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.my_reviews.MyReviewsDataAccessInterface;
import use_case.recommendations.RecommendationsUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
import use_case.survey_second_page.SurveySecondPageDataAccessInterface;
import use_case.watchlist.WatchlistUserDataAccessInterface;
import use_case.survey1.Survey1UserDataAccessInterface;
import use_case.watchlists.WatchlistsUserDataAccessInterface;
import use_case.watchlists.rename.RenameUserDataAccessInterface;

/**
 * The DAO for user data.
 */
public class DBUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, HomeUserDataAccessInterface, MyReviewsDataAccessInterface,
        LogoutUserDataAccessInterface, WatchlistsUserDataAccessInterface, WatchlistUserDataAccessInterface,
        RecommendationsUserDataAccessInterface,
        Survey1UserDataAccessInterface, SurveySecondPageDataAccessInterface,
        CreateWatchlistDataAccessInterface, RenameUserDataAccessInterface {

    private static final int SUCCESS_CODE = 200;
    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String STATUS_CODE_LABEL = "status_code";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";
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
        MongoCollection<Document> collection = DataBaseConstructor.GetCollection("Users");
        FindIterable<Document> findIterable = collection.find(eq("userId", username));

        return findIterable.first() != null;
    }

    @Override
    public boolean movieExists(String movie) {
        return false;
    }

    @Override
    public void save(User user) {
        Document newAccount = new Document("userId", user.getName())
                .append("username", user.getName())
                .append("password", user.getPassword());
        try {
            collection.insertOne(newAccount);
            System.out.println("User saved successfully");
        } catch (Exception e) {
            System.out.println("User not saved: " + e.getMessage());
        }
    }

    @Override
    public boolean saveWatchlist(User user, Watchlist watchlist) {
        try {
            // Create a document representing the review
            Document watchlistDoc = new Document()
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

    public boolean leaveReview(MovieReview review) {
        try {
            // Create a document representing the review
            Document reviewDoc = new Document()
                    .append("movieTitle", review.getMovie_Title())
                    .append("date", review.getDate())
                    .append("starRating", review.getStarRating());

            // Add optional written review if provided
            if (review.getContent() != null) {
                reviewDoc.append("writtenReview", review.getContent());
            }

            // Add the review to the "reviews" array in the user's document
            collection.updateOne(
                    new Document("userId", review.getUserID()), // Find user by ID
                    new Document("$push", new Document("reviews", reviewDoc)) // Push the new review
            );

            return true; // Indicate success
        } catch (Exception e) {
            System.err.println("Error adding review to user: " + e.getMessage());
            return false; // Indicate failure
        }
    }


    public List<MovieReview> getReviews(User user) {
        // Initialize the factory to create MovieReview objects
        final CommonMovieReviewFactory reviewFactory = new CommonMovieReviewFactory();

        // Prepare the list to hold the user's reviews
        final List<MovieReview> reviews = new ArrayList<>();

        // Query the "Users" collection to find the user and their reviews
        Document userDoc = collection.find(new Document("userId", user.getName())).first();

        if (userDoc != null) {
            // Extract the user's reviews (assuming reviews are stored in a sub-document or array)
            final List<Document> rawReviews = (List<Document>) userDoc.get("reviews");

            if (rawReviews != null) {
                // Iterate over each review and transform it into a MovieReview object
                for (Document reviewDoc : rawReviews) {
                    final String username = userDoc.getString("userId");
                    final Date date = reviewDoc.getDate("date");
                    final Double starRating = reviewDoc.getDouble("starRating");
                    final String writtenReview = reviewDoc.getString("writtenReview");
                    final String movieTitle = reviewDoc.getString("movieTitle");

                    // Use the factory to create the MovieReview
                    MovieReview review;
                    if (writtenReview != null) {
                        review = reviewFactory.create(username, date, starRating, writtenReview, movieTitle);
                    } else {
                        review = reviewFactory.create(username, date, starRating, movieTitle);
                    }

                    // Add the review to the list
                    reviews.add(review);
                }
            }
        }

        // Return the list of reviews
        return reviews;
    }

//    @Override
//    public void changePassword(User user) {
//        final OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//
//        // POST METHOD
//        final MediaType mediaType = MediaType.parse(CONTENT_TYPE_JSON);
//        final JSONObject requestBody = new JSONObject();
//        requestBody.put(USERNAME, user.getName());
//        requestBody.put(PASSWORD, user.getPassword());
//        final RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
//        final Request request = new Request.Builder()
//                .url("http://vm003.teach.cs.toronto.edu:20112/user")
//                .method("PUT", body)
//                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_JSON)
//                .build();
//        try {
//            final Response response = client.newCall(request).execute();
//
//            final JSONObject responseBody = new JSONObject(response.body().string());
//
//            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
//                // success!
//            }
//            else {
//                throw new RuntimeException(responseBody.getString(MESSAGE));
//            }
//        }
//        catch (IOException | JSONException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

    @Override
    public String getCurrentUsername() {
        return null;
    }
}
