public class ATMService {

    // Overloading
    public void deposit(Account account, double amount) {

        account.deposit(amount);

        System.out.printf(
                "Deposited PHP %.2f%n", amount);
    }

    public void deposit(Account account, double amount, String note) {

        account.deposit(amount);

        System.out.printf(
                "Deposited PHP %.2f - %s%n",
                amount, note);
    }

    // Varargs
    public double depositAll(Account account, double... amounts) {

        double total = 0;

        for (double amount : amounts) {

            account.deposit(amount);

            total = total + amount;
        }

        return total;
    }

    // Pass-by-value demo
    public void tryToReplace(Account account) {

        account = new SavingsAccount(
                "XX-000",
                "Ghost Account",
                0,
                0
        );

        System.out.println(
                "Inside the method : " + account);

        // Java passes the reference by value.
        // Reassigning this parameter does not change
        // the original variable in main().
    }

    public void addBonus(Account account, double bonus) {

        account.deposit(bonus);

        // The object is changed, so the change is visible
        // to main() because both references point to
        // the same object.
    }

    // Transfer
    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {

        from.withdraw(amount);

        to.deposit(amount);
    }
}