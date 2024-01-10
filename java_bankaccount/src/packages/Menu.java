package packages;
import java.sql.SQLException;
import java.util.Scanner;
public class Menu {
    private Scanner scanner;
    private Bank bankService;

    public void Bank() {
        scanner = new Scanner(System.in);
        bankService = new Bank();
    }

    public void start() throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to the Bank Customer Management System");

        boolean exit = false;
        while (!exit) {
            displayMenu();
            this.scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    addSavingsAccount();
                    break;
                case 3:
                    addCurrentAccount();
                    break;
                case 4:
                    showCustomerList();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nBank Customer Management System Menu:");
        System.out.println("1. Add New Customer");
        System.out.println("2. Add Savings Account");
        System.out.println("3. Add Current Account");
        System.out.println("4. Show Customer List");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addNewCustomer() {
        System.out.println("\nEnter customer details:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);
        newCustomer.setEmail(email);
        newCustomer.setCity(city);
        newCustomer.setContactNumber(contactNumber);

        bankService.addNewCustomer(newCustomer);
        System.out.println("Customer added successfully!");
    }

    private void addSavingsAccount() throws SQLException, ClassNotFoundException {
        System.out.println("\nAdding Savings Account:");
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Initial Savings Balance: ");
        double savingsBalance = scanner.nextDouble();
        scanner.nextLine();

        Account savingsAccount = new Account();
        savingsAccount.setCustomerId(customerId);
        savingsAccount.setSavingsBalance(savingsBalance);

        bankService.addSavingsAccount(savingsAccount);
        System.out.println("Savings Account added successfully!");
    }

    private void addCurrentAccount() throws SQLException, ClassNotFoundException {
        System.out.println("\nAdding Current Account:");
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Initial Current Balance: ");
        double currentBalance = scanner.nextDouble();
        scanner.nextLine();

        Account currentAccount = new Account();
        currentAccount.setCustomerId(customerId);
        currentAccount.setCurrentBalance(currentBalance);

        bankService.addCurrentAccount(currentAccount);
        System.out.println("Current Account added successfully!");
    }

    private void showCustomerList() {
        System.out.println("\nList of Customers:");
        bankService.getAllCustomers();
        bankService.getAllCustomers().forEach(System.out::println);
    }
}
