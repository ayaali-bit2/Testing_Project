package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StringExtensionsTest {

    @DataProvider(name = "validEmails")
    public Object[][] validEmails() {
        return new Object[][]{
                {"user@example.com"},
                {"customer+tag@sub.domain.co"},
                {"first.last@domain.io"},
                {"name123@company-name.org"}
        };
    }

    @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmails() {
        return new Object[][]{
                {"@no-local-part.com"},
                {"missing-at-symbol.com"},
                {"trailing-dot.@domain.com"},
                {"user@-invalid-domain.com"},
                {null}
        };
    }

    @Test(dataProvider = "validEmails")
    public void isValidEmail_acceptsValidAddresses(String email) {
        assertTrue(StringExtensions.isValidEmail(email));
    }

    @Test(dataProvider = "invalidEmails")
    public void isValidEmail_rejectsInvalidAddresses(String email) {
        assertFalse(StringExtensions.isValidEmail(email));
    }
}
