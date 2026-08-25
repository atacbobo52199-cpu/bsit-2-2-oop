public abstract class Account {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account (String accountNumber, String ownerName, double balance) {
    this.accountNumber = accountNumber;
    this.ownerName = ownerName;
    this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        balance = balance + amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }

        balance = balance - amount;
    }

    public abstract String getAccountType();

    protected void applyWithdrawal(double amount) {
        balance = balance - amount;
    }

    @Override
    public String toString() {
        return getAccountType() + " " + accountNumber +
                " (" + ownerName + ")";
    }
}
