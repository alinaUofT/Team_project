import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.api.core.ApiFuture;
import java.util.concurrent.ExecutionException;

public class FirebaseTest {
    public static void storeSampleData() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("sampleData");

        ApiFuture<Void> future = ref.push().setValueAsync("Hello, Firebase!");
        try {
            future.get();
            System.out.println("Data stored successfully.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Failed to store data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}