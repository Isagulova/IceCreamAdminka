package org.example.newProject.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class FirebaseConfig {
    public FirebaseConfig() {
        try {
            ClassPathResource resource = new ClassPathResource("config/icecream-86195-firebase-adminsdk-fbsvc-347540c18b.json");
            InputStream inputStream = resource.getInputStream();

            GoogleCredentials credentials = GoogleCredentials.fromStream(inputStream);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .setDatabaseUrl("https://icecream-86195-default-rtdb.asia-southeast1.firebasedatabase.app/")
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
