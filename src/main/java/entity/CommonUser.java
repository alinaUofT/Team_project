package entity;
import app.DataBaseConstructor;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
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
import use_case.change_password.ChangePasswordUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

/**
 * A simple implementation of the User interface.
 */
public class CommonUser implements User {

    private final String name;
    private final String password;

    // TODO - updated the lists once the classes are created.

    private boolean loginStatus;
    private List<String> ratingsAndReviews = new ArrayList<>();
    private List<String> watchlists = new ArrayList<>();
    private List<String> preferredGenres;

    public CommonUser(String name, String password) {
        this.name = name;
        this.password = password;
        this.loginStatus = false;
        this.preferredGenres = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean getLoginStatus() {
        return loginStatus;
    }

    /**
     * Returns the user created watchlists of the user.
     *
     * @return list of watchlists of the user.
     */
    @Override
    public List<String> getWatchlists() {
        return this.watchlists;
    }


}
