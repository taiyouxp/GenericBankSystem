import java.util.ArrayList;

// * gotta search more about array list... 
// missing out: 
// transferences, especial account types, delete account, 
// password system, persistent information.. maybe ill connect with a DB.. GUI interface
// more features, such as: loan, people who do NOT PAY MY BANK... 
// also,learn how to implement TDD here, to better the code.

public class Bank {
    // again, some procedures of encapsulation
    private ArrayList<Account> accounts;
    
    public Bank() {
        accounts = new ArrayList<>(); // how to initialize an array
    }
    // using the java utils for array list
    // package to add the object account with the passage of the parameter of it 
    // *this is an exclusive operation for Account class
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("account added succesfully!\n");
    }
    
    // method to find an account by the accountNumber (acts like id)
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // display all accounts
    public void displayAccounts() {
        for (Account account : accounts) {
            account.displayInfo(); System.out.println();
        }
    }
    // modify the limits using the previous method of search 
    public void modifyLimit(int accountNumber, double newLimit) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.setNewLimit(newLimit);
            System.out.println("Succefully updated: $"+account.getCreditLimit()+" is your new limit !");
        } else {
            System.out.println("Error in operation: account not found...");
        }
    }
}