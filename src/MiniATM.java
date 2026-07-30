import java.util.Scanner;

public class MiniATM {

    static double balance = 1000.00;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("==================================");
        System.out.println("      WELCOME TO MINI ATM");
        System.out.println("==================================");

        while (running) {

            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    deposit();
                    break;

                case "2":
                    withdraw();
                    break;

                case "3":
                    checkBalance();
                    break;

                case "4":
                    running = false;
                    System.out.println("Thank you for using Mini ATM!");
                    break;

                default:
                    System.out.println("Please choose 1 to 4 only.");
            }
        }
    }

    // Deposit
    static void deposit() {

        System.out.print("Enter amount to deposit: ");

        try {

            double amount = Double.parseDouble(input.nextLine());

            if (amount <= 0) {
                throw new InvalidAmountException("Amount must be greater than 0.");
            }

            balance += amount;

            System.out.printf("Deposited PHP %.2f%n", amount);
            System.out.printf("New Balance: PHP %.2f%n", balance);

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid number.");

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println("-- transaction finished --");
        }
    }

    // Withdraw
    static void withdraw() {

        System.out.print("Enter amount to withdraw: ");

        try {

            double amount = Double.parseDouble(input.nextLine());

            if (amount <= 0) {
                throw new InvalidAmountException("Amount must be greater than 0.");
            }

            if (amount > balance) {
                throw new InsufficientFundsException(
                        "Insufficient funds. You are short by PHP " +
                                String.format("%.2f", amount - balance),
                        amount - balance);
            }

            balance -= amount;

            System.out.printf("Withdrew PHP %.2f%n", amount);
            System.out.printf("New Balance: PHP %.2f%n", balance);

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid number.");

        } catch (InvalidAmountException | InsufficientFundsException e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println("-- transaction finished --");
        }
    }

    // Check Balance
    static void checkBalance() {

        System.out.printf("Current Balance: PHP %.2f%n", balance);
    }
}

class InsufficientFundsException extends Exception {

    private double shortfall;

    public InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public double getShortfall() {
        return shortfall;
    }
}

class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}