package data_access;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIMovieAccess {
    private static final String API_KEY = "b1f9d6a6a9884c948fd5e17a9a87171c";
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    // Method to search for a movie
    public static String searchMovie(String query) throws Exception {
        // Construct the full URL
        String urlString = BASE_URL + "/search/movie?api_key=" + API_KEY + "&query=" + query.replace(" ", "%20");
        URL url = new URL(urlString);

        // Open the connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Return the response as a string
        return response.toString();
    }

    // Main method to test the TMDbClient
    public static void main(String[] args) throws Exception {
        String response = APIMovieAccess.getMovieGenresAsJson();
        System.out.println(response);
    }

    /**
     * Retrieves a string of movie genres from the API.
     *
     * @return a string where the key is the genre ID and the value is the genre name
     * @throws AssertionError if the response body is null
     */
    public static String getMovieGenresAsJson() {
        final OkHttpClient client = new OkHttpClient();

        // Create the request
        final Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/genre/movie/list?language=en&api_key=" + API_KEY)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code());
            }
            if (response.body() == null) {
                throw new AssertionError();
            }
            return response.body().string();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// This is how we access specific fields for a movie, it is returned as a"json string" from the db we need
    // to then parse it into a json object using the jsonobject method, then we can access the fields
    // like usual key value pairs. (dont forget the import for jsonobject).
    //
//        public static void main(String[] args) {
//            // Example JSON response (as a raw string)
//            String jsonResponse = "{\"title\":\"Cars\",\"release_date\":\"2006-06-09\",\"overview\":\"A hotshot race car discovers the true meaning of friendship.\"}";
//
//            // Parse the raw JSON string into a JSONObject
//            JSONObject jsonObject = new JSONObject(jsonResponse);
//
//            // Access specific fields
//            String title = jsonObject.getString("title");
//            String releaseDate = jsonObject.getString("release_date");
//            String overview = jsonObject.getString("overview");
//
//            // Print the values
//            System.out.println("Title: " + title);
//            System.out.println("Release Date: " + releaseDate);
//            System.out.println("Overview: " + overview);
//        }
//    }


