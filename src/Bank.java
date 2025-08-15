import java.util.ArrayList;

// * preciso pesquisar mais sobre lista de arrays...

// Faltando: 
// transferências, tipos especiais de contas, exclusão de contas
// sistema de senhas, informações persistentes... talvez eu consiga me conectar a um banco de dados... interface gráfica
// mais recursos, como: empréstimo, pessoas que NÃO PAGAM MEU BANCO...
// aprenda também como implementar TDD aqui, para melhorar o código.

public class Bank {
    // again, alguns procedimentos de encapsulamento
    private ArrayList<Account> accounts;
    
    public Bank() {
        accounts = new ArrayList<>(); // como inicializar uma array
    }

    // usando os java utils para array list
    // pacote para adicionar o objeto account com a passagem do parâmetro dele 
    // *esta é uma operação exclusiva para a classe Account

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Conta adicionada com sucesso!\n");
    }
    
    // método para encontrar uma conta pelo accountNumber (age como id)
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // exibir todas as contas
    public void displayAccounts() {
        for (Account account : accounts) {
            account.displayInfo(); System.out.println();
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