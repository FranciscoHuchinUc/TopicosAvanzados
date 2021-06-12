package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.util.UUID;

public class ApiService {

    public static void initFirebase() {
        
        FileInputStream serviceAccount = null;
        try {

            if(serviceAccount == null) {
                serviceAccount = new FileInputStream("key.json");
                FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://xmazedb-default-rtdb.firebaseio.com/")
                    .build();

                FirebaseApp.initializeApp(options);
            } else {
                serviceAccount = serviceAccount;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                serviceAccount.close();
            } catch (IOException ex) {
                Logger.getLogger(ApiService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
    
}
