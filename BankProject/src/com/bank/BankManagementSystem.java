package com.bank;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankManagementSystem {
    private CustomerService customerService;
    private AccountService accountService;
    private Scanner scanner;

    public BankManagementSystem() throws SQLException {
        customerService = new CustomerService();
        accountService = new AccountService();
        scanner = new Scanner(System.in);
    }


public void displayMenu() {
    while (true) {
        System.out.println("\n__--Welcome to Banking Systems --__");
        System.out.println("1. Add New Customer");
        System.out.println("2. Add Account for Customer");
        System.out.println("3. Show Customer Accounts");
        System.out.println("4. Delete Customer by ID");
        System.out.println("5. Search Customer by ID");
        System.out.println("6. Show All Customers");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addNewCustomer();
                break;
            case 2:
                addAccountForCustomer();
                break;
            case 3:
                showCustomerAccounts();
                break;
            case 4:
                deleteCustomerById();
                break;
            case 5:
                getCustomerById();
                break;
            case 6:
                getAllCustomers();
                break;
            case 7:
                System.out.println("Exiting...");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}

private void addNewCustomer() {
    try {
        System.out.println("Enter New Customer Details:");

        String newFirstName = getInput("First Name");
        String newLastName = getInput("Last Name");
        String newEmail = getInput("Email");
        String newCity = getInput("City");
        String newContactNumber = getInput("Contact Number");

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(newFirstName);
        newCustomer.setLastName(newLastName);
        newCustomer.setEmail(newEmail);
        newCustomer.setCity(newCity);
        newCustomer.setContactNumber(newContactNumber);

        customerService.addNewCustomer(newCustomer);
        System.out.println("New customer added successfully.");
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter valid data.");
        scanner.nextLine();
    } catch (Exception e) {
        System.out.println("Error adding new customer: " + e.getMessage());
    }
}

    private String getInput(String fieldName) {
        while (true) {
            System.out.print(fieldName + ": ");
            String input = scanner.nextLine().trim();
            try {
                if (fieldName.equals("First Name") || fieldName.equals("Last Name")) {
                    validateStringInput(input, fieldName);
                } else if (fieldName.equals("Email")) {
                    validateEmailInput(input);
                } else if (fieldName.equals("Contact Number")) {
                    validateContactNumberInput(input);
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }



    private void addAccountForCustomer() {
        System.out.print("\nEnter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Account Type (savings/current): ");
        String accountType = scanner.nextLine();
        System.out.print("Balance: ");
        BigDecimal balance = new BigDecimal(scanner.nextLine());

        Account newAccount = new Account();
        newAccount.setAccountType(accountType);
        newAccount.setBalance(balance);

        accountService.addAccountForCustomer(customerId, newAccount);
        System.out.println("Account added successfully.");
    }

    private void showCustomerAccounts() {
        System.out.print("\nEnter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        List<Account> accounts = accountService.getAccountsByCustomerId(customerId);
        if (accounts.isEmpty()) {
            System.out.println("No accounts found for Customer ID " + customerId);
        } else {
            System.out.println("Accounts for Customer ID " + customerId + ":");
            for (Account account : accounts) {
                System.out.println(account.getAccountNumber() + ": " + account.getAccountType() + ", Balance: " + account.getBalance());
            }
        }
    }

    private void getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if (customers != null) {
            System.out.println("All Customers:");
            for (Customer customer : customers) {
                System.out.println("ID: " + customer.getCustomerId());
                System.out.println("Name: " + customer.getFirstName() + " " + customer.getLastName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("City: " + customer.getCity());
                System.out.println("Contact Number: " + customer.getContactNumber());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("No customers found.");
        }
    }


    private void validateStringInput(String input, String fieldName) throws Exception {
        if (input.isEmpty()) {
            throw new Exception(fieldName + " cannot be empty.");
        }
        if (!input.matches("^[a-zA-Z]+$")) {
            throw new Exception(fieldName + " should contain only alphabetic characters.");
        }
    }

    private void validateEmailInput(String email) throws Exception {
        if (email.isEmpty()) {
            throw new Exception("Email cannot be empty.");
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new Exception("Invalid email format.");
        }
    }

    private void validateContactNumberInput(String contactNumber) throws Exception {
        if (contactNumber.isEmpty()) {
            throw new Exception("Contact number cannot be empty.");
        }
        if (!contactNumber.matches("\\d{10}")) {
            throw new Exception("Invalid contact number. It should be a 10-digit number.");
        }
    }



    private void deleteCustomerById() {
        try {
            System.out.print("Enter Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine();

            List<Account> customerAccounts = accountService.getAccountsByCustomerId(customerId);
            if (!customerAccounts.isEmpty()) {
                System.out.println("Cannot delete customer. Associated accounts exist.");

            } else {
                customerService.deleteCustomerById(customerId);
                System.out.println("Customer deleted successfully.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error deleting customer: " + e.getMessage());
        }
    }

    private void getCustomerById() {
            System.out.print("Enter Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine();

            Customer customer = customerService.getCustomerById(customerId);
            if (customer != null) {
                System.out.println("Customer Details:");
                System.out.println("ID: " + customer.getCustomerId());
                System.out.println("First Name: " + customer.getFirstName());
                System.out.println("Last Name: " + customer.getLastName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("City: " + customer.getCity());
                System.out.println("Contact Number: " + customer.getContactNumber());
            } else {
                System.out.println("Customer not found.");
            }
        }}



