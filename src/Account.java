// EXPLICAÇÃO DA CLASSE Account.java

// A classe Account é a base para todas as contas bancárias do sistema. Ela é como um "modelo" que define o que toda e qualquer conta 
// bancária deve ter e o que ela pode fazer. Classes mais específicas, como ContaPoupanca e ContaEspecial, herdarão tudo o que está definido aqui e 
// adicionarão suas próprias características únicas (herança e poliformismo). 

public class Account {
    // 1. ATRIBUTOS (As "Informações" da Conta)
    private String accountHolder; // TitularConta
    private int accountNumber; // NumeroConta
    private double creditLimit; // limiteCredito
    protected double balance;
    private String password;

    // 2. CONSTRUTOR (O "Criador" de Contas)
    public Account(String accountHolder, int accountNumber, double balance, double creditLimit, String password) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.password = password;
    }
    // 3. MÉTODOS (As "Ações" da Conta)

    // 3.1 Métodos getters e Setters
    public String getAccountHolder() { return accountHolder; }
    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public double getCreditLimit() { return creditLimit; }
    
    public void setNewLimit(double newLimit) { this.creditLimit = newLimit; } 
    
    // 3.2 Métodos de Operação 
    public String deposit(double quantia) { // ALTERADO: Métodos agora retornam String
        if (quantia > 0) {
            balance += quantia;
            return "Depositado: R$" + String.format("%.2f", quantia);
        } else {
            return "Erro: Nenhum valor foi depositado (valor inválido).";
        }
    } 

    
    public String withdraw(double quantia) { // ALTERADO E CORRIGIDO: Lógica de saque corrigida e retorna String
        if (quantia <= 0) {
            return "Erro: Você não pode sacar um valor negativo ou nulo.";
        }
        if ((balance + creditLimit) >= quantia) {
            balance -= quantia;
            return "Saque de R$" + String.format("%.2f", quantia) + " realizado com sucesso.";
        } else {
            return "Erro: Saldo insuficiente para processar a operação.";
        }
    }

    // 3.3 Métodos Utilitários
    public void displayInfo() {
        System.out.println("ID da conta: " + accountNumber);
        System.out.println("Titular: " + accountHolder);
        System.out.printf("Saldo: R$%.2f\n", balance);
        System.out.printf("Limite de crédito: R$%.2f\n", creditLimit);
        System.out.printf("Total disponível: R$%.2f\n", (balance + creditLimit));
    }

    public boolean verificarSenha(String senhaParaVerificar) {
        return this.password.equals(senhaParaVerificar);
    }
}