// EXPLICAÇÂO DA CLASSE GenericBankSystem.java

// Esta classe é o ponto de entrada e o controlador principal da sua aplicação. Ela será como o "maestro" de uma orquestra: ela não toca nenhum 
// instrumento (Account, Bank), mas diz a cada um quando e como agir, seguindo a interação do usuário. Suas principais responsabilidades são:

// 1 - Gerenciar o fluxo do programa (menus e navegação).
// 2 - Capturar e processar as entradas do usuário.
// 3 - Conectar as outras classes (Bank, Account, BankUI) para que trabalhem juntas.

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import utils.BankUI;

public class GenericBankSystem {

    // 1. ATRIBUTOS ESTÁTICOS (Configuração Inicial)
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private static BankSysAdm myBank = new BankSysAdm(); // cria o objeto que gerenciará as contas
    private static int idCounter = 1; // para gerar números de conta sequenciais

    // 2. O PONTO DE PARTIDA
    public static void main(String[] args) {
        BankUI.limparTela();
        System.out.println(BankUI.ANSI_YELLOW + "Bem-vindo ao Sistema Bancário Genérico™" + BankUI.ANSI_RESET); // utilizando as cores no terminal
        BankUI.pausar(scanner);
        telaInicial(); // inicia a primeira tela
        scanner.close(); // fecha o scanner quando o programa terminar
    }

    // # 3. A ESTRUTURA DE MENUS (As "Telas")
    public static void telaInicial() {
        while (true) {
            BankUI.exibirCabecalho("TELA INICIAL");
            System.out.println("1. Entrar como Cliente");
            System.out.println("2. Entrar como Admin");
            System.out.println(BankUI.ANSI_RED + "3. Sair do Sistema" + BankUI.ANSI_RESET); // utilizando as cores no terminal
            System.out.print("\nEscolha uma opção: ");

            try { // 3.1. Tratamento de Erros
                int escolha = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer

                switch (escolha) {
                    case 1: telaCliente(); break; // navega para a tela de cliente
                    case 2: telaAdmin(); break; // navega para a tela de admin
                    case 3:
                        BankUI.limparTela();
                        System.out.println(BankUI.ANSI_CYAN + "Obrigado por usar o sistema." + BankUI.ANSI_RESET); // utilizando as cores no terminal
                        return; // encerra o método e, consequentemente, o programa
                    
                    default:
                        BankUI.exibirMensagemErro("Opção inválida."); 
                        BankUI.pausar(scanner);
                }

            } catch (InputMismatchException e) {
                BankUI.exibirMensagemErro("Entrada inválida. Por favor, digite um número.");
                scanner.next();
                BankUI.pausar(scanner);
            }
        }
    }

    // # TELA 2: MENU DE CLIENTE (LOGIN / CRIAR CONTA) #
    public static void telaCliente() {
        while (true) {
            BankUI.exibirCabecalho("ÁREA DO CLIENTE");
            System.out.println("1. Login");
            System.out.println("2. Criar Nova Conta");
            System.out.println("3. Voltar");
            System.out.print("\nEscolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1: realizarLogin(); break;
                case 2: criarNovaConta(); break;
                case 3: return; // volta para a telaInicial()
                default:
                    BankUI.exibirMensagemErro("Opção inválida.");
                    BankUI.pausar(scanner);
            }
        }
    }
    
    // # TELA 3: MENU DO CLIENTE LOGADO #
    public static void telaClienteLogado(Account contaLogada) {
        // ESTRUTURA DE DECISÃO 
        // MSG PRO ED OU PEDRO: GET ACCOUNT HOLDER N EXISTE MAIS, TEM QUE PEGAR AS INFO DO CLIENTE QUE VAI TER 
        // A CONTA, ENTAO TEM Q BOTAR ESSE GETCLIENTENAME EM CONTALOGADA (ISSO SERVE PRA TODAS AS CHAMADAS DESSA CONTA
        // OU SEJA ESSE PARAMETRO SERIA UM CLIENTE (ESSE PRECISA TER UM GETACCOUNT ID PRA IDENTIFICAR A CONTA DELE))
        while (true) {
            BankUI.exibirCabecalho("Bem-vindo(a), " + contaLogada.getClientName() + "!");
            System.out.println("1. Ver meu Saldo e Informações");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println(BankUI.ANSI_RED + "4. Sair (Logout)" + BankUI.ANSI_RESET); // utilizando as cores no terminal
            System.out.print("\nEscolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1: contaLogada.displayInfo(); break;
                case 2:  
                    System.out.print("Digite o valor para depositar: ");
                    double valorDeposito = scanner.nextDouble(); scanner.nextLine();
                    String resDeposito = contaLogada.deposit(valorDeposito);
                    BankUI.exibirMensagemSucesso(resDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble(); scanner.nextLine();
                    String resSaque = contaLogada.withdraw(valorSaque); 
                    if (resSaque.startsWith("Erro:")) {
                        BankUI.exibirMensagemErro(resSaque);
                    } else {
                        BankUI.exibirMensagemSucesso(resSaque);
                    }
                    break;
                case 4: return; // Volta para a telaCliente()
                default: BankUI.exibirMensagemErro("Opção inválida.");
            }
            BankUI.pausar(scanner);
        }
    }
    
    // 4. MÉTODOS AUXILIARES (As Funcionalidades)

    // CRIAR CONTA
    private static void criarNovaConta() {
        BankUI.exibirCabecalho("CRIAÇÃO DE NOVA CONTA");
        System.out.print("Nome do titular: ");
        String holder = scanner.nextLine();
        System.out.print("Crie uma senha: ");
        String password = scanner.nextLine();
        System.out.print("Valor do depósito inicial: R$");
        double amount = scanner.nextDouble();
        System.out.print("Valor do limite de crédito: R$");
        double credit = scanner.nextDouble();
        
        System.out.println("Escolha o tipo da conta: 1. Poupança | 2. Especial"); // adicionar nova conta (com escolha de tipo) implementado
        int tipoConta = scanner.nextInt();
        scanner.nextLine();

        Account novaConta;
        if (tipoConta == 1) {
            System.out.print("Digite a taxa de juros (ex: 0.05 para 5%): ");
            double juros = scanner.nextDouble();
            novaConta = new ContaPoupanca(holder, idCounter++, amount, credit, juros, password);
        } else {
            System.out.print("Digite a taxa de saque (ex: 2.50): ");
            double taxa = scanner.nextDouble();
            novaConta = new ContaEspecial(holder, idCounter++, amount, credit, taxa, password);
        }
        
        String resAdd = myBank.addAccount(novaConta);
        BankUI.exibirMensagemSucesso(resAdd);
        System.out.println(BankUI.ANSI_YELLOW + "IMPORTANTE: O número da sua conta para login é: " + novaConta.getAccountNumber() + BankUI.ANSI_RESET);
        BankUI.pausar(scanner);
    }

    // REALIZAR LOGIN
    private static void realizarLogin() {
        BankUI.exibirCabecalho("LOGIN DO CLIENTE");
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        Account contaEncontrada = myBank.findAccount(numeroConta);
        // MSG PRO ED E PRO PEDRO: NESSE CASO AQUI VERIFICACAO DE SENHA TA EM CLIENTE, DE NOVO 
        if (contaEncontrada != null && contaEncontrada.verificarSenha(senha)) {
            BankUI.exibirMensagemSucesso("Login bem-sucedido!");
            BankUI.pausar(scanner);
            telaClienteLogado(contaEncontrada); // Navega para a tela do cliente logado
        } else {
            BankUI.exibirMensagemErro("Número da conta ou senha inválidos.");
            BankUI.pausar(scanner);
        }
    }
    
    // # TELA de ADMIN e outras funções podem ser adicionadas aqui seguindo o mesmo modelo...
    public static void telaAdmin() {
        // implementação da tela de admin segue o mesmo padrão
        BankUI.exibirCabecalho("PAINEL ADMIN");
        // ... (resto da lógica de admin)
    }
}