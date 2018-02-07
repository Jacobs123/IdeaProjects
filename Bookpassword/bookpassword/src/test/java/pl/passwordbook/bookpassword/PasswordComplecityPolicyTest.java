package pl.passwordbook.bookpassword;

import org.junit.Test;
import pl.passwordbook.bookpassword.password.PasswordComplexityPolicy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PasswordComplecityPolicyTest {

    @Test
    public void testVerify(){
        PasswordComplexityPolicy complexityPolicy = new PasswordComplexityPolicy();
            boolean result = complexityPolicy.verify("qwert123");
            assertTrue("Wynik dla qwert123", result);
    }

    @Test
    public void testVerify2(){
        PasswordComplexityPolicy complexityPolicy = new PasswordComplexityPolicy();
        boolean result = complexityPolicy.verify("123qwerty");
        assertTrue("Wynik dla zxcvp", result);
    }
}
