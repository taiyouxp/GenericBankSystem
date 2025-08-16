import utils.EmailValidator;
import utils.AddressValidator;

public class Client {
    private String clientName;
    private int clientID; // this one only needs the constructor method and not a set
    private String clientEmail;
    private String clientPassword;
    private String clientAddress;
    
    private Account account; // this is a single field and can hold any subclass of account 

    // 1. CONSTRUCTOR METHOD
    public Client(int clientID, String name, String email, String password, String address) {
        this.clientID = clientID; // setting id directly
        this.account = null; // a new client starts with no account 

        // calling the setter methods to validate and set the other fields: 
        setClientName(name);
        setEmail(email);
        setPassword(password);
        setAddress(address);
    }
    // 2 SETTER METHODS
    // 2.1 FOR THE CLIENT'S FIELDS 
    public void setClientName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Error: Username cannot be empty.");
        } else if (clientName.length() > 50) {
            System.out.println("Username is too long! Has to be less than 50 characters.");
        } else {
            this.clientName = userName;
            System.out.println("Success: Client name has been set.");
        }
    }

    public void setEmail(String email) {
        // a method from the class EmailValidator
        if (EmailValidator.isValidEmail(email)) {
            this.clientEmail = email;
            System.out.println("Success: email has been set.");
        } else {
            System.out.println("Error: invalid email format provided.");
        }
    }

    public void setPassword(String password) {
        // a regular expression to validate the password.
        // ^   : asserts position at the start of the string.
        // \\d : matches any digit (equivalent to [0-9]).
        // {4} : is a quantifier, meaning "exactly 4 times".
        // $   : asserts position at the end of the string.
        String passwordRegex = "^\\d{4}$";
        // checking if the password field is not null and matches the pattern 
        if(password != null && password.matches(passwordRegex)) {
            this.clientPassword = password;
            System.out.println("Success: Password has been set.");
        } else {
            System.out.println("Error: Password must be exactly 4 digits long.");
        }
    }

    public void setAddress(String adress) {
        if(AddressValidator.isValidAddress(adress)) {
            this.clientAddress = adress;
            System.out.println("Success: Adress has been set.");
        } else {
            System.out.println("Error: Password must be exactly 4 digits long.");
        }
    }

    // 2.2 TO OPEN AN ACCOUNT
    /**  
    * pay close attention on this one. we are going to open the actual type of the account on the GenericBankSystem class
    *this is to enforce that the account only have a single and only one type of account *exclusively
    * @param newAccount The account to assign (which can be CurrentAccount, SavingAccount or SpecialAccount)
    */
    public void setAccount(Account newAccount) {
        if (this.account == null) {
            if (newAccount != null) {
                this.account = newAccount;
                // getting the specific class name for a feedback message
                // getclass: 
                System.out.println(newAccount.getClass().getSimpleName()+ " opened succesfully for "+ this.clientName);
            } else {
                System.out.println("Error: cannot assign a null account.");
            }
        } else {
            // this is in case that an account already exists for this client 
            System.out.println("Error: " + this.clientName + " already has an account and cannot open another one.");
        }
    }

    // 3. GETTER METHODS
    public String getClientName() {return clientName;}
    public int getClientID() {return clientID;}
    public String getEmail() {return clientEmail;}
    public String getPassword() {return clientPassword;}
    public String getAddress() {return clientAddress;}
    public Account getAccount() {return account;}
}