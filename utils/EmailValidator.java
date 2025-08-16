package utils;
import java.util.regex.Pattern;

public class EmailValidator {
    // to remember: this static field is to ensure that this is the only copy of this variable, and it will be
    // shared by all objects
    // the explanation to 'final' keyword is to ensure that this variable have a constant value and 
    // is uncheageable (cannot be reassigned unless the mod. is on the internal state)
    // this is also a commonly used regex for email validation
    // checking for a valid local part, an @ symbol, and a valid domain name
    private static final String EMAIL_REGEX = 
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";  
    // compiling this regex pattern
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        if(email == null || email.isEmpty()) {
            return false;
        }
        // try to match the email against the compiled pattern 
        return pattern.matcher(email).matches(); 
    }
}
