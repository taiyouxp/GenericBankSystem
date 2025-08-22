// EXPLICAÇÂO DA CLASSE Bank.java

// Se a classe Account representa uma conta individual, a classe Bank representa a instituição bancária INTEIRA. Sua principal responsabilidade é 
// gerenciar a coleção de todas as contas que existem no sistema. Ela atua como um "gerente geral" ou um "arquivo central" para as contas.

import java.util.ArrayList;

public class Bank {
    // 1. ATRIBUTO (O "Cofre" de Contas)
    private ArrayList<Account> accounts; // uma lista para guardar todas as contas

    // 2. CONSTRUTOR (A "criação" do Banco)
    public Bank() {
        accounts = new ArrayList<>(); // como inicializar uma array
    }

    // 3. MÉTODOS (Os "Serviços" do Banco)

    // 3.1 ADICIONA CONTA
    public String addAccount(Account account) { // ALTERADO: Agora retorna uma String com a mensagem de sucesso
        accounts.add(account);
        return "Conta adicionada com sucesso!";
    }

    // 3.2 PROCURA CONTA
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account; // retorna o objeto conta encontrado
            }
        }
        return null; // retorna nulo se não encontrar
    }

    // 3.3 MOSTRAR CONTAS
    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println(BankUI.ANSI_YELLOW + "Nenhuma conta cadastrada no sistema." + BankUI.ANSI_RESET); // utilizando as cores no terminal

        } else {
            for (Account account : accounts) {
                account.displayInfo(); System.out.println();
            }
        }
    }
    
    // 3.4 MODIFICAR LIMITE
    public String modifyLimit(int accountNumber, double newLimit) { // ALTERADO: Agora retorna uma String com o resultado
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.setNewLimit(newLimit);
            return "Atualizado com sucesso: R$" + String.format("%.2f", account.getCreditLimit()) + " é seu novo limite!";
        } else {
            return "Erro na operação: conta não encontrada...";
        }
    }
}