public class ContaPoupanca extends Account  //  "extends" estabelece a herança
{ 
    private double taxaDeJuros; // atributo específico da Conta Poupança

    // 1. construtor da classe filha
    public ContaPoupanca(String accountHolder, int accountNumber, double balance, double creditLimit, double taxaDeJuros) 
    {
        // 2. chamada ao construtor da superclasse (Account)
        super(accountHolder, accountNumber, balance, creditLimit);
        
        // 3. inicialização do atributo específico desta classe
        this.taxaDeJuros = taxaDeJuros;
    }

    // 4. método específico da Conta Poupança
    public void aplicarJuros() 
    {
        double juros = getBalance() * this.taxaDeJuros;
        deposit(juros); // reutiliza o método deposit() da classe pai
        System.out.println("Juros de $" + juros + " aplicados com sucesso.");
    }
    
    // 5. sobrescrevendo um método da classe pai para adicionar informações
    @Override
    public void displayInfo() 
    {
        super.displayInfo(); // chama o método original da classe Account para não reescrever tudo
        System.out.println("Tipo de Conta: Poupança");
        System.out.println("Taxa de Juros: " + (taxaDeJuros * 100) + "%");
    }
}