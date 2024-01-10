import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Person implements PersonDetails {
    private String id;
    private String firstName;
    private String lastName;
    private String city;
    private String email;

    public Person(String id, String firstName, String lastName, String city, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void addPersonDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ID: ");
        id = scanner.nextLine();

        System.out.print("Enter First Name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = scanner.nextLine();

        System.out.print("Enter City: ");
        city = scanner.nextLine();

        System.out.print("Enter Email: ");
        email = scanner.nextLine();
    }

    @Override
    public void displayPersons() {
        System.out.println("List of Persons:");
        System.out.println("ID\tFirst Name\tLast Name\tCity\tEmail");
        System.out.println("----------------------------------------------");
        System.out.println(id + "\t" + firstName + "\t\t" + lastName + "\t\t" + city + "\t" + email);
        System.out.println("----------------------------------------------");
    }

    @Override
    public void storeToFile() throws IOException {
        Path filePath = Paths.get("persons.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.write("List of Persons:\n");
            writer.write("ID\tFirst Name\tLast Name\tCity\tEmail\n");
            writer.write("----------------------------------------------\n");
            writer.write(id + "\t" + firstName + "\t\t" + lastName + "\t\t" + city + "\t" + email + "\n");
            writer.write("----------------------------------------------\n");
        }
        System.out.println("Persons list stored to file successfully.");
    }
}