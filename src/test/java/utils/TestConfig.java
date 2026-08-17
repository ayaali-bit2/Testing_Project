package utils;

public final class TestConfig {

    private TestConfig() {
    }

    public static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.isBlank()) {
            value = System.getenv(key);
        }
        return value == null || value.isBlank() ? defaultValue : value;
    }

    public static String baseUrl() {
        return get("base.url", "https://automationexercise.com/");
    }

    public static String validEmail() {
        return get("test.valid.email", "ayaali@gmail.com");
    }

    public static String validPassword() {
        return get("test.valid.password", "123456789");
    }

    public static String invalidEmail() {
        return get("test.invalid.email", "invalid@example.com");
    }

    public static String invalidPassword() {
        return get("test.invalid.password", "invalid-password");
    }

    public static String contactUploadFile() {
        return get("contact.upload.file", "src/test/resources/fixtures/contact-upload.txt");
    }
}
