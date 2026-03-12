package org.example.extensions;

import java.util.regex.Pattern;

public final class StringExtensions {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@"
                    + "[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?"
                    + "(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)+$");

    private StringExtensions() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static boolean isValidEmail(String value) {
        if (value == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(value).matches();
    }
}
