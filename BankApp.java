import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankApp {
    private static Map<Integer, BankAccount> accounts = new HashMap<>();
    private static int nextAccountNumber = 1001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Open New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    openAccount(scanner);
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    displayAccountDetails(scanner);
                    break;
                case 6:
                    System.out.println("Thank you for using the Bank Account Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Open new account
    private static void openAccount(Scanner scanner) {
        System.out.print("Enter Account Holder Name: ");
        scanner.nextLine(); // consume newline
        String name = scanner.nextLine();
        BankAccount account = new BankAccount(name, nextAccountNumber);
        accounts.put(nextAccountNumber, account);
        System.out.println("Account created successfully. Account Number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    // Deposit money
    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money
    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Check balance
    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Display account details
    private static void displayAccountDetails(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }
}
