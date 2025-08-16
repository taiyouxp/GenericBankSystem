package utils;
public class AddressValidator {
    
    public static boolean isValidAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            System.out.println("Validation Error: Address cannot be empty.");
            return false;
        }
        String trimmedAddress = address.trim();
        if (trimmedAddress.length() < 5 || trimmedAddress.length() > 150) {
            System.out.println("Validation Error: Address must be between 5 and 150 characters.");
            return false;
        }
        // the first regex '.*\\d.*' means "any character, followed by a digit, followed by any characters" 
        // checks atleast one digit
        // the second regex '.*[a-zA-Z].*' checks for the presence of atleast one letter 
        if(!trimmedAddress.matches(".*\\d.*") && !trimmedAddress.matches(".*[a-zA-Z].*")) {
            System.out.println("Validation error: Address must contain atleast one digit and one letter");
            return false;
        }

        return true; // if all the checks have passed
    }
}
