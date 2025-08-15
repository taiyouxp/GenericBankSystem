public class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance, creditLimit;

    // um método construtor real
    public Account(String accountHolder, int accountNumber, double balance, double creditLimit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    // métodos getters e setters (haverá mais)
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
            System.out.println("Depositado: $" + amount);
        } else {
            System.out.println("Nenhum valor foi depositado... (valor negativo)");
        }
    } 

    public void withdraw(double amount) {
        if (amount < 0) {
            if ((balance + creditLimit) >= amount) {
                balance -= amount;
                System.out.println("Retirou-se: $"+amount);
            } else {
                System.out.println("Não foi possível processar a operação, saldo atual: " + balance);
            }
        } else {
            System.out.println("Você não pode sacar um valor negativo");
        }
    }
    
    public void displayInfo() {
        System.out.println("ID da conta: " + accountNumber);
        System.out.println("Titular: " + accountHolder);
        System.out.println("Saldo: $" + balance);
        System.out.println("Limite de crédito: $" + creditLimit);
        System.out.println("Total atual de fundos disponíveis (saldo + limite de crédito): $" + (balance+creditLimit));
    }
}