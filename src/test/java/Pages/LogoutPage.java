package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {

    private final By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private final By singInAndSignUpButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private final By emailAddressField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)");
    private final By passwordField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)");
    private final By newUserSignUpVisible = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2");
    private final By signUpButton = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button");
    private final By usernameInBar = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private final By logoutButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void SingInAndSignUpButton() {
        navigateToHref(singInAndSignUpButton, "navigate to Sign In and Sign Up page");
    }

    public void NewUserSignUpVisible() {
        findElement(newUserSignUpVisible);
        logger.info("New user sign-up is visible");
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

    public void logoutButtonFun() {
        navigateToHref(logoutButton, "log out from account");
    }
}
