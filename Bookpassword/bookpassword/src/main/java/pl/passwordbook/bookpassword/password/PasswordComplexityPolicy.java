package pl.passwordbook.bookpassword.password;

public class PasswordComplexityPolicy {

    private static final int MIN_LENGTH = 8;
    private static final int MIN_DIGITS = 3;

    public boolean verify(String password) {

        int pwdLenght = password.length();
        int pwdDigit = 0;
        boolean result = true;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                pwdDigit++;
            }
        }

        if (pwdLenght < MIN_LENGTH) {
            return false;
        }

        if (pwdDigit < MIN_DIGITS) {
            return false;
        }
        return result;

    }
}
