package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeSubscriptionPage extends BasePage {

    private final By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private final By verifySubscription = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    private final By emailVerification = By.xpath("//*[@id=\"susbscribe_email\"]");
    private final By submitButtonVerification = By.xpath("//*[@id=\"subscribe\"]");
    private final By successMessage = By.cssSelector("#success-subscribe > div");

    public HomeSubscriptionPage(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
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
