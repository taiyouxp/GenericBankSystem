public class Account {
    private String accountHolder;
    private int accountNumber;
    protected double balance; // o limite de crédito será excluído aqui mais tarde para torná-lo na conta atual 
    private double creditLimit;
    private boolean accountState; // para verificar se uma conta está em débito

    // 2. método construtor 
    public Account(String accountHolder, int accountNumber, double balance, double creditLimit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        //this.creditLimit = creditLimit; // isso vai ser deletado porque não poderia fazer parte da classe abstrata account (a classe 'super')
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
    
    public void withdraw(double quantia) {
        if (quantia > 0) {
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
    // implementará um método de verificação posteriormente para saber se a conta está em débito ou é regulamentada
    // public void state(boolean state) {}

    public void displayInfo() {
        System.out.println("ID da conta: " + accountNumber);
        System.out.println("Titular: " + accountHolder);
        System.out.println("Saldo: $" + balance);
        System.out.println("Limite de crédito: $" + creditLimit);
        System.out.println("Total atual de fundos disponíveis (saldo + limite de crédito): $" + (balance+creditLimit));
    }
}