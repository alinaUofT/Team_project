package data_access;

import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;
import app.DataBaseConstructor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import entity.CommonUserFactory;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import entity.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import use_case.home.HomeUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

/**
 * The DAO for user data.
 */
public class DBUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        HomeUserDataAccessInterface,
        LogoutUserDataAccessInterface {
    private static final int SUCCESS_CODE = 200;
    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String STATUS_CODE_LABEL = "status_code";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";
    private final CommonUserFactory userFactory;

    public DBUserDataAccessObject(CommonUserFactory userFactory) {
        this.userFactory = userFactory;
        // No need to do anything to reinitialize a user list! The data is the cloud that may be miles away.
    }

    @Override
    public User get(String username) {
        // Get the collection
        final MongoCollection<Document> collection = DataBaseConstructor.CreateCollection("Users");
        // Find the document with the given username
        final Document userDocument = collection.find(eq("id", username)).first();

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
        MongoCollection<Document> collection = DataBaseConstructor.CreateCollection("Users");
        FindIterable<Document> findIterable = collection.find(eq("id", username));

        return findIterable.first() != null;
    }
    @Override
    public void save(User user) {
        MongoCollection<Document> collection = DataBaseConstructor.CreateCollection("Users");
        Document newAccount = new Document("id", user.getName())
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
    public void changePassword(User user) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        // POST METHOD
        final MediaType mediaType = MediaType.parse(CONTENT_TYPE_JSON);
        final JSONObject requestBody = new JSONObject();
        requestBody.put(USERNAME, user.getName());
        requestBody.put(PASSWORD, user.getPassword());
        final RequestBody body = RequestBody.create(requestBody.toString(), mediaType);
        final Request request = new Request.Builder()
                .url("http://vm003.teach.cs.toronto.edu:20112/user")
                .method("PUT", body)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_JSON)
                .build();
        try {
            final Response response = client.newCall(request).execute();

            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getInt(STATUS_CODE_LABEL) == SUCCESS_CODE) {
                // success!
            }
            else {
                throw new RuntimeException(responseBody.getString(MESSAGE));
            }
        }
        catch (IOException | JSONException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String getCurrentUsername() {
        return null;
    }
}
