public class Account {
    // 1. atributos 
    private String accountHolder; // TitularConta
    private int accountNumber; // NumeroConta
    private double creditLimit; // saldo, limiteCredito
    protected double balance;

    // 2. método construtor 
    public Account(String accountHolder, int accountNumber, double balance, double creditLimit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    // 3. métodos getters (acessador)
    public String getAccountHolder() {return accountHolder;} 
    public int getAccountNumber() {return accountNumber;}
    public double getBalance() {return balance;}
    public double getCreditLimit() {return creditLimit;}
    
    // 4. método setter (modificador)
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

    public void withdraw(double quantia) {
        if (quantia < 0) {
            if ((balance + creditLimit) >= quantia) {
                balance -= quantia;
                System.out.println("Retirou-se: $" + quantia);
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