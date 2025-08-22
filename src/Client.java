// EXPLICAÇÃO DA CLASSE Cliente.java

// A classe Client representa o cliente do banco como uma pessoa. Ela é responsável por armazenar e gerenciar os dados pessoais do cliente, como nome, 
// e-mail e endereço, etc..
// Essa classe também atua como um "elo de ligação", conectando os dados pessoais do cliente à sua respectiva conta bancária.

import utils.EmailValidator;
import utils.AddressValidator;

public class Client {

    // 1. ATRIBUTOS (Dados Pessoais do Cliente)
    private String clientName;
    private int clientID; // este só precisa do método construtor e não de um conjunto
    private String clientEmail;
    private String clientPassword;
    private String clientAddress;
    
    private Account account; // este é um campo único e pode conter qualquer subclasse de conta 

    // 2. MÉTODO CONSTRUCTOR (O "Cadastro" do Cliente)
    public Client(int clientID, String name, String email, String password, String address) {
        this.clientID = clientID; // definindo o id diretamente
        this.account = null; // um novo cliente começa sem conta

        // chamando os métodos setter para validar e definir os outros campos:
        setClientName(name);
        setEmail(email);
        setPassword(password);
        setAddress(address);
    }
    
    // 3. MÉTODOS SETTER (Os "Validadores" de Dados)
    public void setClientName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Erro: O nome de usuário não pode estar vazio.");
        } else if (clientName.length() > 50) {
            System.out.println("O nome de usuário é muito longo! Deve ter menos de 50 caracteres.");
        } else {
            this.clientName = userName;
            System.out.println("Sucesso: O nome do cliente foi definido.");
        }
    }

    public void setEmail(String email) {
        // um método da classe EmailValidator
        if (EmailValidator.isValidEmail(email)) {
            this.clientEmail = email;
            System.out.println("Sucesso: e-mail foi definido.");
        } else {
            System.out.println("Erro: formato de e-mail inválido fornecido.");
        }
    }

    public void setPassword(String password) {

        // uma expressão regular para validar a senha.

        // ^   : afirma a posição no início da string.
        // \\d : corresponde a qualquer dígito (equivalente a [0-9]).
        // {4} : é um quantificador, significando "exatamente 4 vezes".
        // $   : afirma a posição no final da string.

        String passwordRegex = "^\\d{4}$";
        // verificando se o campo de senha não é nulo e corresponde ao padrão
        if(password != null && password.matches(passwordRegex)) {
            this.clientPassword = password;
            System.out.println("Sucesso: a senha foi definida.");
        } else {
            System.out.println("Erro: A senha deve ter exatamente 4 dígitos.");
        }
    }

    public void setAddress(String adress) {
        if(AddressValidator.isValidAddress(adress)) {
            this.clientAddress = adress;
            System.out.println("Sucesso: Endereço foi definido.");
        } else {
            System.out.println("Erro: A senha deve ter exatamente 4 dígitos.");
        }
    }

    // # PARA ABRIR UMA CONTA
    
    /**  
    * Preste bastante atenção nisso. Vamos abrir o tipo real da conta na classe GenericBankSystem
    * isso é para garantir que a conta tenha apenas um único tipo de conta *exclusivamente
    
    * @param newAccount A conta a ser atribuída (que pode ser Conta Corrente, Conta Poupança ou Conta Especial)
    */

    public void setAccount(Account newAccount) {
        if (this.account == null) {
            if (newAccount != null) {
                this.account = newAccount;
                // obtendo o nome da classe específica para uma mensagem de feedback
                // getclass: 
                System.out.println(newAccount.getClass().getSimpleName()+ " aberto com sucesso para "+ this.clientName);
            } else {
                System.out.println("Erro: não é possível atribuir uma conta nula.");
            }
        } else {
            // isso é caso já exista uma conta para este cliente
            System.out.println("Erro: " + this.clientName + " já tem uma conta e não pode abrir outra.");
        }
    }

    // 4. MÉTODOS GETTER (Os "Leitores" de Dados)
    public String getClientName() {return clientName;}
    public int getClientID() {return clientID;}
    public String getEmail() {return clientEmail;}
    public String getPassword() {return clientPassword;}
    public String getAddress() {return clientAddress;}
    public Account getAccount() {return account;}
}