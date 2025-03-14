import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "data/users.txt";

    public static void saveUser(User user) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(user.getUsername() + "," + user.getPassword());
        bw.newLine();
        bw.close();
    }

    public static List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            users.add(new User(parts[0], parts[1]));
        }
        br.close();
        return users;
    }
}