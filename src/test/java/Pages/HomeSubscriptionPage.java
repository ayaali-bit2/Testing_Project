package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeSubscriptionPage {

    private static final Logger logger = LogManager.getLogger(HomeSubscriptionPage.class);

    WebDriver driver;

    public HomeSubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");

    By verifySubscription = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    By emailVerication = By.xpath("//*[@id=\"susbscribe_email\"]");
    By submitButtonVerication = By.xpath("//*[@id=\"subscribe\"]");

    public void HomeCheck() {
        boolean isHomeVisible = driver.findElement(homeCheck).isDisplayed();
        logger.info("Home link visible: {}", isHomeVisible);
    }

    public void verifySubscriptionFun() {
        boolean isSubscriptionVisible = driver.findElement(verifySubscription).isDisplayed();
        logger.info("Subscription section visible: {}", isSubscriptionVisible);
    }

    public void setEmailVerication(String email) {
        driver.findElement(emailVerication).sendKeys(email);
        logger.info("Entered subscription email.");
    }

    public void clickOnSubmitButtonVerication() {
        driver.findElement(submitButtonVerication).click();

        boolean isSuccessVisible = driver.findElement(By.cssSelector("#success-subscribe > div")).isDisplayed();
        logger.info("Subscription success message visible: {}", isSuccessVisible);

//        driver.findElement(submitButtonVerication).click();
    }
}