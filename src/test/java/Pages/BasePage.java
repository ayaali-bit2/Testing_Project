package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Logger logger;

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(20);

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        this.logger = LogManager.getLogger(getClass());
    }

    protected WebElement findElement(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.debug("Element located: {}", locator);
            return element;
        } catch (Exception exception) {
            logger.error("Unable to locate element {}: {}", locator, exception.getMessage(), exception);
            throw new RuntimeException("Unable to locate element: " + locator, exception);
        }
    }

    protected void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            logger.info("Clicked element: {}", locator);
        } catch (Exception exception) {
            logger.error("Unable to click element {}: {}", locator, exception.getMessage(), exception);
            throw new RuntimeException("Unable to click element: " + locator, exception);
        }
    }

    protected void type(By locator, String text) {
        try {
            WebElement element = findElement(locator);
            element.clear();
            element.sendKeys(text);
            logger.info("Entered text into {}", locator);
        } catch (Exception exception) {
            logger.error("Unable to type into element {}: {}", locator, exception.getMessage(), exception);
            throw new RuntimeException("Unable to type into element: " + locator, exception);
        }
    }

    protected String readText(By locator) {
        WebElement element = findElement(locator);
        String value = element.getText();
        logger.info("Captured text from {}: {}", locator, value);
        return value;
    }

    protected String getAttribute(By locator, String attribute) {
        WebElement element = findElement(locator);
        String value = element.getAttribute(attribute);
        logger.info("Captured attribute '{}' from {}: {}", attribute, locator, value);
        return value;
    }

    protected void navigateToHref(By locator, String actionDescription) {
        try {
            String href = getAttribute(locator, "href");
            if (href == null || href.isBlank()) {
                throw new RuntimeException("Href is empty for " + locator);
            }
            driver.navigate().to(href);
            logger.info("{} - navigated to {}", actionDescription, href);
        } catch (Exception exception) {
            logger.error("Unable to {}: {}", actionDescription, exception.getMessage(), exception);
            throw new RuntimeException("Unable to " + actionDescription, exception);
        }
    }

    protected void acceptAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            logger.info("Alert accepted");
        } catch (Exception exception) {
            logger.error("Unable to accept alert: {}", exception.getMessage(), exception);
            throw new RuntimeException("Unable to accept alert", exception);
        }
    }
}
