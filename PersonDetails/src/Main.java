
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Person> personsList = new ArrayList<>();
            char choice;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add Person");
                System.out.println("2. Display Persons");
                System.out.println("3. Store Persons List to File");
                System.out.println("4. Quit");

                System.out.print("Enter your choice: ");
                choice = scanner.next().charAt(0);

                switch (choice) {
                    case '1':
                        Person newPerson = new Person("", "", "", "", "");
                        newPerson.addPersonDetails();
                        personsList.add(newPerson);
                        break;
                    case '2':
                        if (personsList.isEmpty()) {
                            System.out.println("Persons list is empty.");
                        } else {
                            for (Person person : personsList) {
                                person.displayPersons();
                            }
                        }
                        break;
                    case '3':
                        if (personsList.isEmpty()) {
                            System.out.println("No persons to store.");
                        } else {
                            try {
                                Person person = personsList.get(0);
                                person.storeToFile();
                            } catch (IOException e) {
                                System.out.println("Error occurred while storing persons to file: " + e.getMessage());
                            }
                        }
                        break;
                    case '4':
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != '4');
        }
    }