public class ContaCorrente extends Account {
    private double creditLimit; // atributo espec. 1: contaCorrente possui limite de cheque especial 

    // 1. método construtor (que chama o construtor da superclasse Conta)
    public ContaCorrente(int accountNumber, double balance, double creditLimit) {
        super(accountNumber, balance);
        this.creditLimit = creditLimit; 
    }

    // 2. essa implementação é obrigatória pro método abstrato sacar 
    // (pois define o modo especifico de saque da ContaCorrente)
    @Override   
        // MSG PARA ED E PEDRO: TALVEZ SEJA MELHOR TROCAR ESSE RETORNO BOOLEAN DE SACAR PRA STRING MESMO COMO O ED
        // IMPLEMENTOU
        
    public boolean withdraw(double quantia) {
        if(quantia <= 0) {
            System.out.println("Não é possível sacar um valor um negativo.");
            return false; // falha 1
        } 

        //ContaCorrente vai implementar uma lógica especifica: usando saldo + limite para sacar 
        if (quantia <= (getBalance() + this.creditLimit)) {
            // usando o saldo (atributo protected) diretamente 
            this.balance -= quantia;
            System.out.println("Saque de R$"+quantia+" realizado. Novo saldo: R$" + getBalance());
            return true; // sucesso  
        } else {
            System.out.println("Saque não autorizado, saldo insuficiente.");
            return false; // falha 2
        }
    }
    // 3. metodo para saber se contaCorrente é devedora
     /**
     * verifica se a conta está atualmente em débito (usando o cheque especial)
     * @return true se o saldo for negativo, false caso contrário
     */
    public boolean isInDebt() {
        return (this.getBalance() < 0);
    }

    // 3.1 metodo para saber a quantia que a conta está devendo
     /** Calcula e retorna o valor do limite de crédito que está sendo utilizado no momento
     * @return O valor positivo que a conta está devendo. Retorna 0 se o saldo for positivo (não tem limite sendo usado)
     */
    public double getValueUtilized() {
        if(isInDebt()) {
            return -getBalance(); // ex: se saldo = -300, então -(-300) = 300 
        } else {
            return 0.0;
        }
    }
    // 3.2 metodo para saber o valor restante de crédito de limite que ainda tem
    public double getAvailableLimit() {
        return this.creditLimit - getValueUtilized();
    }
    // 4. sobreescreve o displayInfo() para adicionar informações especificas dessa subclasse 
    @Override
    public void displayInfo() {
        super.displayInfo(); // chamando o metodo principal e adicionando as informações da subclasse abaixo
        System.out.println("Limite de crédito total: R$"+this.creditLimit);
        if(isInDebt()) { // se tiver em debito com o banco, mostra o credito que ainda tem, e que ainda pode ser utilizado
            System.out.println(">> Valor utilizado do limite: R$"+getValueUtilized()+
            "\n>> Limite de crédito ainda disponível: R$"+ getAvailableLimit());
        }
    }
}