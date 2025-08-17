import java.util.Locale;
import java.util.Scanner;

public class GenericBankSystem {

    public static void main(String[] args) {
        // 1. SETUP
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        BankAdmin myBank = new BankAdmin(); // cria o objeto que gerenciará as contas
        int id = 0; // para gerar números de conta sequenciais
        boolean on = true;

        System.out.println("Bem-vindo ao Sistema Bancário Genérico");

        // 2. O LOOP DO PROGRAMA PRINCIPAL
        while (on) {
            // 2.1 menu de opções atualizado
            System.out.println("\n========Menu========");
            System.out.println("1. Adicionar nova conta");
            System.out.println("2. Exibir todas as contas");
            System.out.println("3. Encontre uma conta pelo número");
            System.out.println("4. Modificar limite de crédito");
            System.out.println("5. Depositar em uma conta");
            System.out.println("6. Sacar de uma conta");
            System.out.println("7. Aplicar Juros (Apenas Conta Poupança)");
            System.out.println("8. Sair");
            System.out.println();
            System.out.print("Por favor, escolha uma das opções acima: ");
            System.out.println("\n====================");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            // 3. ESTRUTURA DE DECISÃO
            switch (choice) {
                case 1: // adicionar nova conta (com escolha de tipo) implementado
                    System.out.println("Escolha o tipo da conta:");
                    System.out.println("1. Conta Poupança");
                    System.out.println("2. Conta Especial");
                    int tipoConta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome do titular da conta: ");
                    String holder = scanner.nextLine();
                    System.out.print("Valor inicial da conta: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Valor de crédito inicial da conta: ");
                    double credit = scanner.nextDouble();

                    Account novaConta = null; // utilizamos a classe pai como tipo 

                    if (tipoConta == 1) {
                        System.out.print("Digite a taxa de juros (ex: 0.05 para 5%): ");
                        double juros = scanner.nextDouble();
                        novaConta = new ContaPoupanca(holder, id++, amount, credit, juros);
                    } else if (tipoConta == 2) {
                        System.out.print("Digite a taxa de saque (ex: 2.50): ");
                        double taxa = scanner.nextDouble();
                        novaConta = new ContaEspecial(holder, id++, amount, credit, taxa);
                    } else {
                        System.out.println("Tipo de conta inválido. Operação cancelada.");
                        break;
                    }

                    myBank.addAccount(novaConta);
                    break;

                case 2: // exibindo todas as informações da conta
                    myBank.displayAccounts();
                    break;

                case 3: // encontrar uma conta
                    System.out.print("Digite o número da conta (id) que você deseja encontrar: ");
                    int searchId = scanner.nextInt();
                    Account foundAcc = myBank.findAccount(searchId);

                    if (foundAcc != null) {
                        System.out.println("---Conta encontrada---");
                        foundAcc.displayInfo(); // POLIMORFISMO: chama o displayInfo() correto para o tipo de conta
                        System.out.println("---------------------\n");
                    } else {
                        System.out.println("-> Nenhuma conta foi encontrada com este número.");
                    }
                    break;

                case 4: // modificar um limite
                    System.out.print("Insira o número da conta para modificar: ");
                    int modAccNum = scanner.nextInt();
                    System.out.print("Insira o novo limite de crédito: ");
                    double newCredLim = scanner.nextDouble();
                    myBank.modifyLimit(modAccNum, newCredLim);
                    break;

                case 5: // depositar
                    System.out.print("Digite o número da conta para depósito: ");
                    int depAccNum = scanner.nextInt();
                    Account depAcc = myBank.findAccount(depAccNum);
                    if (depAcc != null) {
                        System.out.print("Digite o valor a ser depositado: ");
                        double depAmount = scanner.nextDouble();
                        depAcc.deposit(depAmount);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 6: // sacar
                    System.out.print("Digite o número da conta para saque: ");
                    int withAccNum = scanner.nextInt();
                    Account withAcc = myBank.findAccount(withAccNum);
                    if (withAcc != null) {
                        System.out.print("Digite o valor a ser sacado: ");
                        double withAmount = scanner.nextDouble();
                        // POLIMORFISMO 
                        // se for ContaEspecial, chama o withdraw com taxa.
                        // se for ContaPoupanca, chama o withdraw normal.
                        withAcc.withdraw(withAmount);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 7: // aplicar Juros
                    System.out.print("Digite o número da conta poupança para aplicar juros: ");
                    int jurosAccNum = scanner.nextInt();
                    Account jurosAcc = myBank.findAccount(jurosAccNum);

                    // VERIFICAÇÃO DE TIPO E CASTING
                    if (jurosAcc != null && jurosAcc instanceof ContaPoupanca) {
                        // se a conta for do tipo ContaPoupanca, podemos convertê-la (casting)
                        ContaPoupanca cp = (ContaPoupanca) jurosAcc;
                        cp.aplicarJuros(); // agora podemos chamar o método específico
                    } else {
                        System.out.println("Erro: Conta não encontrada ou não é uma Conta Poupança.");
                    }
                    break;

                case 8: // sair
                    on = false;
                    System.out.println("Obrigado por usar o Generic Bank System™");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha um número entre 1 e 8.");
                    break;
            }
        }
        scanner.close(); // Fecha o scanner ao final do programa
    }
}