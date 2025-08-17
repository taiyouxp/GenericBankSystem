import java.util.ArrayList;

// * Preciso pesquisar mais sobre lista de arrays...
// faltando:
// transferências, tipos de contas de herança, exclusão de contas,
// sistema de senhas, informações persistentes... talvez eu me conecte a um banco de dados... interface gráfica
// mais recursos, como: empréstimo, pessoas que NÃO PAGAM MEU BANCO...
// aprenda também como implementar TDD aqui, para melhorar o código.

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
        if(count == 0) { // só para garantir a mensagem 
            System.out.println("não há nenhuma conta no sistema! ");
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