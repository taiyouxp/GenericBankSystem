// EXPLICAÇÃO DA CLASSE ContaEspecial.java

// A classe ContaEspecial define um tipo de conta que herda as características de uma Account genérica, mas com uma regra de negócio específica: 
// a cobrança de uma taxa a cada saque.

// 1. HERANÇA 
public class ContaEspecial extends Account {

    // 2. ATRIBUTO ESPECÍFICO 
    private double taxaDeSaque; // atributo específico da Conta Especial

    // 3. CONSTRUTOR
    public ContaEspecial(String accountHolder, int accountNumber, double balance, double creditLimit, double taxaDeSaque, String password) {
        super(accountHolder, accountNumber, balance, creditLimit, password);
        this.taxaDeSaque = taxaDeSaque;
    }

    // 4. SOBRESCRITA DE MÉTODO 
    @Override // ALTERADO: Sobrescrito para retornar String e aplicar a taxa
    public String withdraw(double quantia) {
        if (quantia <= 0) {
            return "Erro: Você não pode sacar um valor nulo ou negativo.";
        }
        
        double totalDebit = quantia + this.taxaDeSaque; // calcula o valor total a ser debitado

        if ((this.balance + getCreditLimit()) >= totalDebit) {
            this.balance -= totalDebit; // modifica o saldo diretamente!
            return "Saque de R$" + String.format("%.2f", quantia) + " realizado com sucesso.\n" +
                   "Taxa de saque de R$" + String.format("%.2f", this.taxaDeSaque) + " aplicada.";
        } else {
            return "Erro: Saldo insuficiente para processar a operação (saque + taxa).";
        }
    }
}