package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class FailureScreenshotUtil {

    private static final Path SCREENSHOT_DIRECTORY = Paths.get(
            System.getProperty("screenshot.output.dir", "target/screenshots"));
    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-SSS");

    private FailureScreenshotUtil() {
    }

    public static void capture(WebDriver driver, String testName) {
        if (driver == null || !(driver instanceof TakesScreenshot)) {
            return;
        }

        try {
            Files.createDirectories(SCREENSHOT_DIRECTORY);

            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String fileName = sanitize(testName) + "-" +
                    LocalDateTime.now().format(TIMESTAMP_FORMAT) + ".png";

            Files.write(SCREENSHOT_DIRECTORY.resolve(fileName), screenshot);
            Allure.addAttachment("Failure screenshot - " + testName,
                    "image/png", new ByteArrayInputStream(screenshot), ".png");
        } catch (IOException | RuntimeException exception) {
            System.err.println("Unable to capture failure screenshot for " + testName +
                    ": " + exception.getMessage());
        }
    }

    private static String sanitize(String value) {
        String sanitized = value == null ? "unknown-test" : value.replaceAll("[^a-zA-Z0-9._-]", "_");
        return sanitized.isBlank() ? "unknown-test" : sanitized;
    }
}
