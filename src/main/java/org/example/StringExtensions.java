package org.example;

import java.util.regex.Pattern;

public final class StringExtensions {

    private static final Pattern EMAIL_REGEX = Pattern.compile(
            "^(?!\\.)[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?!-)[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$");

    private StringExtensions() {
        // Prevent instantiation
    }

    public static boolean isValidEmail(String value) {
        if (value == null) {
            return false;
        }
        return EMAIL_REGEX.matcher(value).matches();
    }
}
