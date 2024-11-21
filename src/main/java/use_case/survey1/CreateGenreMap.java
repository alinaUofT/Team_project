package use_case.survey1;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Creates a map of genre IDs to genre names by fetching the genre list from the TMDb API.
 */
public class CreateGenreMap {
    private Map<Integer, String> genreMap;

    public CreateGenreMap() {
        try {
            genreMap = new HashMap<>();

            // Call the TMDb API
            final String apiUrl = "https://api.themoviedb.org/3/genre/movie/list?api_key=YAPI_KEY&language=en";
            final OkHttpClient client = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(apiUrl)
                    .get()
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected response code: " + response.code());
                }

                // Parse the JSON response
                final String jsonString = response.body().string();
                final JSONObject jsonObject = new JSONObject(jsonString);
                final JSONArray genresArray = jsonObject.getJSONArray("genres");

                // Populate the genre map
                for (int i = 0; i < genresArray.length(); i++) {
                    final JSONObject genreObject = genresArray.getJSONObject(i);
                    final int genreId = genreObject.getInt("id");
                    final String genreName = genreObject.getString("name");

                    genreMap.put(genreId, genreName);
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to fetch movie genres", e);
        }
    }

    /**
     * @return Map of genre IDs to genre names.
     */
    public Map<Integer, String> getGenreMap() {
        return genreMap;
    }

    /**
     * @return Array of genre names.
     */
    public String[] keySet() {
        return genreMap.values().toArray(new String[0]);
    }
}
