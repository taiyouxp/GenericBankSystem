public abstract class Account {
    // atributos comuns a todas as contas
    private int accountNumber;
    protected double balance; // 'protected' para que subclasses acessem diretamente 
    private boolean isActive; // para verificar se uma conta está em ativa 

    // 1. método construtor 
    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.isActive = true;
    }

    // 2. métodos getters (acessadores) 
    public int getAccountNumber() {return accountNumber;}
    public double getBalance() {return balance;} 
    public boolean isActive() {return isActive;}

    // 3. método de Comportamento comum a todos
    // 3.1 depositar
    // MSG PRO ED E PRO PEDRO: TROCAR O RETURN PRA STRING 
    public void deposit(double quantia) {
        if (quantia > 0) {
            balance += quantia;
            return "Depositado: R$" + String.format("%.2f", quantia);
        } else {
            return "Erro: Nenhum valor foi depositado (valor inválido).";
        }
    } 
    // 3.2 transferir
    public void transfer(double quantia, Account destino) {
        if (quantia <= 0) {
            System.out.println("O valor da transferência deve ser positivo.");
            return;
        }

        boolean saqueRealizado = this.withdraw(quantia);

        if (saqueRealizado) {
            destino.withdraw(quantia);
            System.out.println("Transferência de R$"+quantia+" para a conta " + destino.getAccountNumber()+ " concluída.");
        } else {
            // a mensagem de erro especifica ja foi mostrada pelo metodo sacar (withdraw)
            System.out.println("Não foi possível realizar a transferência");
        }
    }
    // 4. método abstrato
    // forçando as subclasses a implementarem suas próprias formas de saque:
    public abstract boolean withdraw(double quantia);

    // 5. Mostra apenas as informações que a classe realmente possui.
    public void displayInfo() {
        System.out.println("Número da Conta: " + accountNumber);
        System.out.println("Saldo: R$" + balance);
        System.out.println("Estado da Conta: " + (isActive ? "Ativa" : "Inativa"));
    }
}