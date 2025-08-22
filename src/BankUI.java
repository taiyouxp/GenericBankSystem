// EXPLICAÇÂO DA CLASSE BankUI.java

// A classe BankUI é uma classe utilitária (ou "helper class"). Sua única responsabilidade é gerenciar a aparência visual do programa no terminal. 
// Ela centraliza todas as funções relacionadas à formatação da interface do usuário (UI - User Interface), como limpar a tela, exibir textos 
// coloridos e criar cabeçalhos padronizados.


import java.util.Scanner;

public class BankUI {

    // 1. ATRIBUTOS 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    // 2. MÉTODOS UTILITÁRIOS

    // 2.1 LIMPAR TELA
    public static void limparTela() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) { /* Ignora erros */ }
    }

    // 2.2 PAUSAR SCANNER
    public static void pausar(Scanner scanner) {
        System.out.print(ANSI_YELLOW + "\nPressione Enter para continuar..." + ANSI_RESET);
        scanner.nextLine();
    }

    // 2.3 EXIBIR CABEÇALHO
    public static void exibirCabecalho(String titulo) {
        limparTela();
        System.out.println(ANSI_CYAN + "========================================");
        System.out.println("      " + titulo.toUpperCase());
        System.out.println("========================================" + ANSI_RESET);
        System.out.println();
    }

    // 2.4 MENSSAGEM DE SUCESSO
    public static void exibirMensagemSucesso(String mensagem) {
        System.out.println(ANSI_GREEN + "\n" + mensagem + ANSI_RESET);
    }

    // 2.5 MESSAGEM DE ERRO
    public static void exibirMensagemErro(String mensagem) {
        System.out.println(ANSI_RED + "\n" + mensagem + ANSI_RESET);
    }
}