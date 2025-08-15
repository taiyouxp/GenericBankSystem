import java.util.Scanner;
public class GenericBankSystem {
    
    public static void main(String[] args) {
        try (// 1. SETUP 
        Scanner scanner = new Scanner(System.in)) {
            // primeira instância para o banco

            Bank myBank = new Bank(); // it actually creates the array of accounts - cria a lista de contas
            
            // isso está chamando o método construtor 'Account', que precisa destes parâmetros:
            // 1. string accountHolder (o 'nome' do usuário)
            // 2. string accountNumber (o 'id' do usuário)
            // 3. double balance (autoexplicativo)
            // 4. double creditLimit (quanto se pode emprestar)
            
            int id = 00000;
            System.out.println("Bem-vindo ao Sistema Bancário Genérico™"); 
            boolean on = true;

            // 2. O LOOP DO PROGRAMA PRINCIPAL

            while (on) {
                // 2.1 estas são as opções que o usuário terá para gerenciar a conta
                System.out.println("========Menu========");
                System.out.println("1. Adicionar nova conta");
                System.out.println("2. Exibir todas as contas");
                System.out.println("3. Encontre uma conta pelo número");
                System.out.println("4. Modificar limite de crédito");
                System.out.println("5. Sair");
                System.out.println("Por favor, escolha uma das opções acima: ");
                System.out.println("====================");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice) {
                    case 1: // adicionar nova conta
                        System.out.println("nome do titular da conta: ");
                        String holder = scanner.nextLine();
                        System.out.println("valor inicial da conta: ");
                        double amount = scanner.nextDouble();
                        System.out.println("valor de crédito inicial da conta: ");
                        double credit = scanner.nextDouble();
                        
                        Account account = new Account(holder, id++, amount, credit);
                        myBank.addAccount(account);
                        break;

                    case 2: // exibindo todas as informações da conta
                        myBank.displayAccounts();
                        break;

                    case 3: // para encontrar uma conta
                        System.out.println("digite o número da conta (id) que você deseja encontrar: ");
                        int searchId = scanner.nextInt();
                        Account foundAcc = myBank.findAccount(searchId);
                        
                        if (foundAcc != null) {
                            System.out.println("---Conta encontrada---");
                            foundAcc.displayInfo();
                            System.out.println("-------------------\n");
                        } else {
                            System.out.println("-> nenhuma conta foi encntrada com este número.");
                        }
                        break;

                    case 4: // modificar um limite
                        System.out.print("insira o número da conta para modificar: ");
                        int modAccNum = scanner.nextInt();
                        
                        System.out.print("insira o novo limite de crédito: ");
                        double newCredLim = scanner.nextDouble();
                        scanner.nextLine(); // para consumir a próxima linha

                        myBank.modifyLimit(modAccNum, newCredLim);
                        break;

                    case 5: 
                        on = false; // isso encerrará o loop (o próprio programa)
                        System.out.println("Obrigado por usar o Generic Bank System™");
                        break;

                    default: 
                        System.out.println("Opção inválida. Escolha um número entre 1 e 5.");
                        break;
                }
            }
        }
    }
}