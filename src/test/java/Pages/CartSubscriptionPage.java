package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartSubscriptionPage extends BasePage {

    private final By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private final By cartButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
    private final By verifySubscription = By.cssSelector("#footer > div.footer-widget > div > div > div.col-sm-3.col-sm-offset-1 > div > h2");
    private final By emailVerification = By.cssSelector("#susbscribe_email");
    private final By submitButtonVerification = By.cssSelector("#subscribe");
    private final By successMessage = By.cssSelector("#success-subscribe > div");

    public CartSubscriptionPage(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void clickOnCartButton() {
        navigateToHref(cartButton, "navigate to cart page");
    }

    public void verifySubscriptionFun() {
        findElement(verifySubscription);
        logger.info("Subscription section is visible");
    }

    public void setEmailVerication(String email) {
        type(emailVerification, email);
    }

    public void clickOnSubmitButtonVerication() {
        click(submitButtonVerification);
        findElement(successMessage);
        logger.info("Subscription success message is visible");
    }
}
