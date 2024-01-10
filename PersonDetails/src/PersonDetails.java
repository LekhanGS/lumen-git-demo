import java.io.IOException;

public interface PersonDetails {
    void addPersonDetails();
    void displayPersons();
    void storeToFile() throws IOException;
}