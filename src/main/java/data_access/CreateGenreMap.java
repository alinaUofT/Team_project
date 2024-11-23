package data_access;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Creates a map of genre IDs to genre names by fetching the genre list from the TMDb API.
 */
public class CreateGenreMap {
    private Map<Integer, String> genreMap;

    /**
     * Creates a map of genre IDs to genre names.
     * @return the genre map
     */
    public Map<Integer, String> createGenreMap() {
        genreMap = new HashMap<>();

        final String genresString = APIMovieAccess.getMovieGenresAsJson();
        if (genresString != null) {
            final JSONObject jsonObject = new JSONObject(genresString);
            final JSONArray genresArray = jsonObject.getJSONArray("genres");

            // Populate the genre map
            for (int i = 0; i < genresArray.length(); i++) {
                final JSONObject genreObject = genresArray.getJSONObject(i);
                final int genreId = genreObject.getInt("id");
                final String genreName = genreObject.getString("name");

                genreMap.put(genreId, genreName);
            }
        }
        return genreMap;
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
