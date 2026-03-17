package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private final By singInAndSignUpButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private final By emailAddressField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)");
    private final By passwordField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)");
    private final By signUpButton = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button");
    private final By usernameInBar = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private final By delet = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    private final By checkDeleted = By.cssSelector("#form > div > div > div > h2 > b");
    private final By invalidLoginMessage = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void SingInAndSignUpButton() {
        navigateToHref(singInAndSignUpButton, "navigate to Sign In and Sign Up page");
    }

    public void setEmailAddressField(String emailAddressFieldtext) {
        type(emailAddressField, emailAddressFieldtext);
    }

    public void setPasswordField(String passwordFieldtext) {
        type(passwordField, passwordFieldtext);
    }

    public void setSignUpButton() {
        click(signUpButton);
    }

    public void checkUserNameBar() {
        findElement(usernameInBar);
        logger.info("Username bar is visible");
    }

    public void deleteButton() {
        navigateToHref(delet, "navigate to account deletion");
    }

    public void checkIsDeleted() {
        findElement(checkDeleted);
        logger.info("Account deletion confirmation is visible");
    }

    public void checkInValidLoginMessageVisability() {
        findElement(invalidLoginMessage);
        logger.info("Invalid login message is visible");
    }
}
