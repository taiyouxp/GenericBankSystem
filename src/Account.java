public class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance, creditLimit;

    // a real constructor method
    public Account(String accountHolder, int accountNumber, double balance, double creditLimit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    // getters and setters methods (there will be more)
    public String getAccountHolder() {return accountHolder;} 
    public int getAccountNumber() {return accountNumber;}
    public double getBalance() {return balance;}
    public double getCreditLimit() {return creditLimit;}
    
    public void setNewLimit(double newLimit) {
        this.creditLimit = newLimit;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $"+amount);
        } else {
            System.out.println("No amount was deposited... (negative value)");
        }
    } 

    public void withdraw(double amount) {
        if (amount < 0) {
            if ((balance + creditLimit) >= amount) {
                balance -= amount;
                System.out.println("Withdrew: $"+amount);
            } else {
                System.out.println("Couldn't process operation, current balance: "+balance);
            }
        } else {
            System.out.println("You cannot withdraw an negative amount");
        }
    }
    
    public void displayInfo() {
        System.out.println("Account id: "+accountNumber);
        System.out.println("Holder: "+accountHolder);
        System.out.println("Balance: $"+balance);
        System.out.println("Credit Limit: $"+creditLimit);
        System.out.println("Current total available funds: $"+(balance+creditLimit));
    }
}