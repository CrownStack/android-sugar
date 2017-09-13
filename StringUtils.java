public class StringUtils {
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private static boolean isValidEmail(String emailId) {
        if (emailId.trim().matches(EMAIL_PATTERN)) {
            return false;
        } else
            return true;
    }
}
