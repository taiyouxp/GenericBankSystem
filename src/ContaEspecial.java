public class ContaEspecial extends Account {

    private double taxaDeSaque; // atributo específico da Conta Especial

    public ContaEspecial(String accountHolder, int accountNumber, double balance, double creditLimit, double taxaDeSaque) {
        // chama o construtor da classe pai (Account)
        super(accountHolder, accountNumber, balance, creditLimit);
        this.taxaDeSaque = taxaDeSaque;
    }

    // sobrescrevendo o método de saque para adicionar a taxa
    @Override
    public void withdraw(double quantia) {
        double totalDebit = quantia + this.taxaDeSaque; // calcula o valor total a ser debitado

        if (quantia <= 0) {
            System.out.println("Você não pode sacar um valor nulo ou negativo.");
            return; // encerra o método aqui
        }

        // verifica se o saldo (incluindo limite) é suficiente para o saque + taxa
        if ((this.balance + getCreditLimit()) >= totalDebit) {
            this.balance -= totalDebit; // modifica o saldo diretamente!
            System.out.println("Retirou-se: $" + quantia);
            System.out.println("Taxa de saque de $" + this.taxaDeSaque + " aplicada.");
            System.out.println("Novo saldo: $" + this.balance);
        } else {
            System.out.println("Não foi possível processar a operação (saque + taxa), saldo insuficiente.");
            System.out.println("Fundos disponíveis (saldo + limite): $" + (this.balance + getCreditLimit()));
        }
    }
}