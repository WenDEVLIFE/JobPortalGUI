package functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class SaveCredentials {

    private static volatile SaveCredentials instance;
    private String savePath = "src/database/savepw.txt";

    public static SaveCredentials getInstance() {
        if (instance == null) {
            synchronized (SaveCredentials.class) {
                if (instance == null) {
                    instance = new SaveCredentials();
                }
            }
        }
        return instance;
    }

    public void saveCredentials(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(savePath, false))) {
            writer.write(username + ":" + password);
            writer.newLine();
            System.out.println("Credentials saved for user: " + username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 
    
    public void ClearCredentials() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter (savePath))) {
			writer.write(""); // Clear the file by writing an empty string
			System.out.println("Credentials cleared.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> loadAllCredentials() {
		  List<String> credentials = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(savePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                credentials.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return credentials;
	}
}