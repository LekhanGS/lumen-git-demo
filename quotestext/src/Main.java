import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("quotes.txt");
//        System.out.println(filePath);

        try {
            List<String> quotes = Files.readAllLines(filePath);

            // Iterate over the quotes and display them
            System.out.println("Quotes from the file:");
            for (String quote : quotes) {
                System.out.println(quote);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}