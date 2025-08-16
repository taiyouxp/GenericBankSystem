public class Account {
    private String accountHolder;
    private int accountNumber;
    protected double balance; // creditLimit will be deleted here later to make it on the currentAccount 
    private double creditLimit;
    private boolean accountState; // to check if an account is in debit

    // 2. método construtor 
    public Account(String accountHolder, int accountNumber, double balance, double creditLimit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        //this.creditLimit = creditLimit; // this is going to be deleted
        // cause it couldnt be part of the abstract class account (the 'super' class)
    }

    // 3. métodos getters (acessador)
    public String getAccountHolder() {return accountHolder;} 
    public int getAccountNumber() {return accountNumber;}
    public double getBalance() {return balance;}
    public double getCreditLimit() {return creditLimit;} 
    public boolean getState() {return accountState;}
    public void setNewLimit(double newLimit) {
        this.creditLimit = newLimit;
    }


    // 5. métodos de Comportamento
    public void deposit(double quantia) {
        if (quantia > 0) {
            balance += quantia;
            System.out.println("Depositado: $" + quantia);
        } else {
            System.out.println("Nenhum valor foi depositado... (valor negativo)");
        }
    } 
    
    public void withdraw(double amount) {
        if (amount > 0) {
            if ((balance + creditLimit) >= amount) {
                balance -= amount;
                System.out.println("Withdrew: $"+amount);
            } else {
                System.out.println("Não foi possível processar a operação, saldo atual: " + balance);
            }
        } else { 
            System.out.println("You cannot withdraw an negative amount");
        }
    }
    // will implement a verification method later to know if the account is in debit or is regulated
    // public void state(boolean state) {}

    public void displayInfo() {
        System.out.println("ID da conta: " + accountNumber);
        System.out.println("Titular: " + accountHolder);
        System.out.println("Saldo: $" + balance);
        System.out.println("Limite de crédito: $" + creditLimit);
        System.out.println("Total atual de fundos disponíveis (saldo + limite de crédito): $" + (balance+creditLimit));
    }
}