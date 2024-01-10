import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        long factorial = 1;

        try {
            do {
                System.out.print("Enter a number : ");
                number = scanner.nextInt();

                if (number < 0 || number > 10) {
                    System.out.println("Enter a number between 0 and 10.");
                }
            } while (number < 0 || number > 10);

            if (number == 0 || number == 1) {
                factorial = 1;
            } else {
                for (int i = 2; i <= number; i++) {
                    factorial *= i;
                }
            }

            System.out.println("Factorial of " + number + " is: " + factorial);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number between 0 and 10.");
        } finally {
            scanner.close();
        }
    }
}