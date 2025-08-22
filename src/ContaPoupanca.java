// EXPLICAÇÃO DA CLASSE ContaPoupanca.java

// A classe ContaPoupanca representa uma conta de poupança. Ela herda todas as características de uma Account padrão, mas adiciona a 
// capacidade de render juros e se identifica de forma diferente.

// 1. HERANÇA E ATRIBUTO ESPECÍFICO
public class ContaPoupanca extends Account { 
    private double taxaDeJuros; // atributo específico da Conta Poupança

    // 2. CONSTRUTOR
    public ContaPoupanca(String accountHolder, int accountNumber, double balance, double creditLimit, double taxaDeJuros, String password) {
        super(accountHolder, accountNumber, balance, creditLimit, password);
        this.taxaDeJuros = taxaDeJuros;
    }

    // 3. ADICÇAO DE NOVO MÉTODO
    public String aplicarJuros() { // ALTERADO: Retorna String
        double juros = getBalance() * this.taxaDeJuros;
        deposit(juros); // reutiliza o método deposit() da classe pai
        return "Juros de R$" + String.format("%.2f", juros) + " aplicados com sucesso.";
    }
    
    // 4. SOBRESCRITA PARA ESTENDER FUNCIONALIDADE
    @Override
    public void displayInfo() {
        super.displayInfo(); // chama o método original da classe Account
        System.out.println("Tipo de Conta: Poupança");
        System.out.println("Taxa de Juros: " + (taxaDeJuros * 100) + "%");
    }
}