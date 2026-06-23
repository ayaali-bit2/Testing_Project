package utils;

import java.util.regex.Pattern;

public final class StringExtensions {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)+$");

    private StringExtensions() {
        throw new IllegalStateException("Utility class");
    }

      /**
     * Validates whether the provided string is a valid email address.
     *
     * @param value email address to validate
     * @return true if the email is valid; otherwise false
     */

    public static boolean isValidEmail(String value) {
        if (value == null) {
            return false;
        }

        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            return false;
        }

        return EMAIL_PATTERN.matcher(trimmed).matches();
    }
}