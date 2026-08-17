package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public final class TestConfig {

    private static final String DATA_RESOURCE = "test-data.properties";
    private static final Properties TEST_DATA = loadTestData();

    private TestConfig() {
    }

    public static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (isBlank(value)) {
            value = System.getenv(toEnvironmentKey(key));
        }
        if (isBlank(value)) {
            value = TEST_DATA.getProperty(key);
        }
        return isBlank(value) ? defaultValue : value;
    }

    public static String baseUrl() {
        return external("base.url", "https://automationexercise.com/");
    }

    public static String validEmail() {
        return get("login.valid.email", "valid-email-not-configured@example.com");
    }

    public static String validPassword() {
        return get("login.valid.password", "password-not-configured");
    }

    public static String invalidEmail() {
        return get("login.invalid.email", "invalid-email@example.com");
    }

    public static String invalidPassword() {
        return get("login.invalid.password", "invalid-password");
    }

    public static String existingUsername() {
        return get("register.existing.username", "existing-user");
    }

    public static String existingEmail() {
        return get("register.existing.email", "existing-user@example.com");
    }

    public static String checkoutUsername() {
        return get("checkout.username", "checkout-user");
    }

    public static String checkoutEmail() {
        return get("checkout.email", "checkout-user@example.com");
    }

    public static String checkoutPassword() {
        return get("checkout.password", "checkout-password");
    }

    public static String checkoutValue(String field) {
        return get("checkout." + field, "");
    }

    public static String subscriptionEmail() {
        return get("subscription.email", "subscriber@example.com");
    }

    public static String contactValue(String field) {
        return get("contact." + field, "");
    }

    public static String productSearch() {
        return get("product.search", "product");
    }

    public static String productQuantity() {
        return get("product.quantity", "1");
    }

    public static String contactUploadFile() {
        return external("contact.upload.file", "src/test/resources/fixtures/contact-upload.txt");
    }

    private static String external(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (isBlank(value)) {
            value = System.getenv(toEnvironmentKey(key));
        }
        return isBlank(value) ? defaultValue : value;
    }

    private static Properties loadTestData() {
        Properties properties = new Properties();
        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream(DATA_RESOURCE)) {
            if (input == null) {
                return properties;
            }
            properties.load(input);
            return properties;
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load " + DATA_RESOURCE, exception);
        }
    }

    private static String toEnvironmentKey(String key) {
        return key.replace('.', '_').toUpperCase(Locale.ROOT);
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
