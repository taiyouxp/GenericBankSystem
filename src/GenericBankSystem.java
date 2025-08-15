import java.util.Scanner;
public class GenericBankSystem {
    
    public static void main(String[] args) {
        try (// 1. SETUP 
        Scanner scanner = new Scanner(System.in)) {
            // first instance for the bank          
            Bank myBank = new Bank(); // it actually creates the array of accounts
            // this is calling the constructor method 'Account', that needs these parameters: 
            // 1. string accountHolder (the 'name' of the user)
            // 2. string accountNumber (the 'id' of the user)
            // 3. double balance (self-explaining)
            // 4. double creditLimit (how much one can borrow)
            
            int id = 00000;
            System.out.println("Welcome to the Generic Bank System™"); 
            boolean on = true;
            // 2. THE MAIN PROGRAM LOOP 
            while (on) {
                // 2.1 these are the option the user will have to manage the account 
                System.out.println("========Menu========");
                System.out.println("1. Add a new account");
                System.out.println("2. Display all accounts");
                System.out.println("3. Find an account by number");
                System.out.println("4. Modify credit limit");
                System.out.println("5. Painel admin");
                System.out.println("6. Exit");
                System.out.println("Please choose one of the options above: ");
                System.out.println("====================");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice) {
                    case 1: // add new account
                        System.out.println("name of holder of the account: ");
                        String holder = scanner.nextLine();
                        System.out.println("initial amount of the account: ");
                        double amount = scanner.nextDouble();
                        System.out.println("initial credit value of the account: ");
                        double credit = scanner.nextDouble();
                        
                        Account account = new Account(holder, id++, amount, credit);
                        myBank.addAccount(account);
                        break;
                    case 2: // displaying all account info 
                        myBank.displayAccounts();
                        break;
                    case 3: // to find an account
                        System.out.println("enter the account number (id) you want to find: ");
                        int searchId = scanner.nextInt();
                        Account foundAcc = myBank.findAccount(searchId);
                        
                        if (foundAcc != null) {
                            System.out.println("---Account found---");
                            foundAcc.displayInfo();
                            System.out.println("-------------------\n");
                        } else {
                            System.out.println("-> no account founded with this number.");
                        }
                        break;
                    case 4: // to modify a limit 
                        System.out.print("enter account number to modify: ");
                        int modAccNum = scanner.nextInt();
                        
                        System.out.print("enter the new credit limit: ");
                        double newCredLim = scanner.nextDouble();
                        scanner.nextLine(); // to consume the next line

                        myBank.modifyLimit(modAccNum, newCredLim);
                        break;
                    case 5:
                        System.out.println("========Menu admin========");
                        System.out.println("1. Display all accounts");
                        System.out.println("2. Display id accounts");
                        System.out.println("3. Edit accounts");
                        System.out.println("====================");
                        int choiceAdmin = scanner.nextInt();

                        if (choiceAdmin==1){
                                myBank.displayAccounts();
                        }
                        else if (choiceAdmin==2){
                                System.out.println("Search account id:");
                                int idAccount  = scanner.nextInt();
                                myBank.findAccount(idAccount);
                        }
                        else if (choiceAdmin==3){
                                System.out.println("");
                                System.out.println("========Edit count========");
                                System.out.println("1. Put count");
                                System.out.println("2. Delete count");
                                System.out.println("====================");
                                int choiceOption = scanner.nextInt();

                                if (choiceOption==1){
                                    System.out.println("========Put count========");
                                    System.out.println("====================");
                                }
                                else if (choiceOption==2){
                                    System.out.println("========Delete count========");
                                    System.out.println("====================");
                                }
                        }
                    case 6: 
                        on = false; // this will end the loop (the program itself)
                        System.out.println("thank for using Generic Bank System™");
                        break;
                    default: 
                        System.out.println("invalid option. please choose a number between 1 and 5");
                        break;
                }
            }
        }
    }
}