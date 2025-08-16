import java.util.ArrayList;

// * gotta search more about array list... 
// missing out: 
// transferences, inheritance account types, delete account, 
// password system, persistent information.. maybe ill connect with a DB.. GUI interface
// more features, such as: loan, people who do NOT PAY MY BANK... 
// also,learn how to implement TDD here, to better the code.

public class BankAdmin {
    // again, some procedures of encapsulation
    // this is the unique attribute 
    private ArrayList<Account> accounts;
    // private ArrayList<Client> clients;
    
    public BankAdmin() {
        accounts = new ArrayList<>(); // how to initialize an array
    }

    // usando os java utils para array list
    // pacote para adicionar o objeto account com a passagem do parâmetro dele 
    // *esta é uma operação exclusiva para a classe Account

    // 3. métodos de Comportamento
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Conta adicionada com sucesso!\n");
    }
    
    // método para encontrar uma conta pelo accountNumber (age como id)
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account; // retorna o objeto conta encontrado
            }
        }
        return null; // retorna nulo se não encontrar
    }

    // exibir todas as contas
    public void displayAccounts() {
        int count = 0;
        for (Account account : accounts) {
            count++;
            account.displayInfo(); System.out.println();
        }
        if(count == 0) { // just to ensure the message 
            System.out.println("theres no account on the system ! ");
        }
    }
    // modificar os limites usando o método de pesquisa anterior
    public void modifyLimit(int accountNumber, double newLimit) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.setNewLimit(newLimit);
            System.out.println("Atualizado com sucesso: $"+account.getCreditLimit()+" é seu novo limite !");
        } else {
            System.out.println("Erro na operação: conta não encontrada...");
        }
    }
}