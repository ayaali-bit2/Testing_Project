package org.example.extensions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StringExtensionsTest {

    @DataProvider(name = "validEmails")
    public static Object[][] validEmails() {
        return new Object[][]{
                {"example@example.com"},
                {"user.name+tag+sorting@example.co.uk"},
                {"user_name@example.io"},
                {"user-name@sub.domain.org"},
                {"user123@sub-domain.example.net"}
        };
    }

    @DataProvider(name = "invalidEmails")
    public static Object[][] invalidEmails() {
        return new Object[][]{
                {"plainaddress"},
                {"@missing-local-part.com"},
                {"missing-at-sign.net"},
                {"user@.com"},
                {"user@domain..com"},
                {"user@domain"},
                {""},
                {null}
        };
    }

    @Test(dataProvider = "validEmails")
    public void isValidEmail_shouldReturnTrue_forValidEmails(String email) {
        assertTrue(StringExtensions.isValidEmail(email));
    }

    @Test(dataProvider = "invalidEmails")
    public void isValidEmail_shouldReturnFalse_forInvalidEmails(String email) {
        assertFalse(StringExtensions.isValidEmail(email));
    }
}
