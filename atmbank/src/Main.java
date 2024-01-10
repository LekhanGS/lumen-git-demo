import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int attempts = 3;

    public static void main(String[] args) {
        greetCustomer();

        String accountNumber = getAccountNumber();
        if (!isValidAccountNumber(accountNumber)) {
            System.out.println("Invalid account number. Exiting...");
            return;
        }

        int pin = getPIN();
        while (!isValidPIN(pin)) {
            attempts--;
            if (attempts == 0) {
                System.out.println("No attempts remaining. Exiting...");
                return;
            }
            pin = getPIN();
        }

        double amount = getWithdrawalAmount();
        if (isValidWithdrawalAmount(amount)) {
            performWithdrawal(amount);
            System.out.println("Successful withdrawal of " + amount + ". Thank you!");
        } else {
            System.out.println("Invalid withdrawal amount. Exiting...");
        }
    }

    private static void greetCustomer() {
        System.out.println("Welcome to the Console ATM!");
    }

    private static String getAccountNumber() {
        System.out.print("Enter your account number: ");
        return scanner.nextLine();
    }

    private static boolean isValidAccountNumber(String accountNumber) {
        return accountNumber.length() % 2 != 0;
    }

    private static int getPIN() {
        System.out.print("Enter your 4-digit PIN: ");
        return scanner.nextInt();
    }

    private static boolean isValidPIN(int pin) {
        return String.valueOf(pin).length() == 4;
    }

    private static double getWithdrawalAmount() {
        int attempts = 4;
        double amount;
        do {
            System.out.print("Enter the amount to withdraw (multiple of 100 and positive): ");
            amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            attempts--;
            if (attempts == 0) {
                System.out.println("No attempts remaining. Exiting...");
                System.exit(0);
            }
        } while (!isValidWithdrawalAmount(amount));
        return amount;
    }

    private static boolean isValidWithdrawalAmount(double amount) {
        return amount > 0 && amount % 100 == 0;
    }

    private static void performWithdrawal(double amount) {
        // Perform withdrawal logic here (e.g., update balance, etc.)
        // For this demonstration, just print the withdrawal amount
        System.out.println("Withdrawing amount: " + amount);
    }
}