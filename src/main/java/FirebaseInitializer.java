import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.InputStream;
import java.io.IOException;

public class FirebaseInitializer {
    public static void initializeFirebase() {
        try {
            InputStream serviceAccount = FirebaseInitializer.class.getClassLoader().getResourceAsStream("online-project-database-firebase-adminsdk-wf0kp-2c434125dc.json");

            if (serviceAccount == null) {
                throw new IOException("Service account file not found in resources.");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://online-project-database-default-rtdb.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase initialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}