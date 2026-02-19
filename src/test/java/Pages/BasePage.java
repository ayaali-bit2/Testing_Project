package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    private final By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private final By singInAndSignUpButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private final By emailAddressField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)");
    private final By passwordField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)");
    private final By signUpButton = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button");
    private final By usernameInBar = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private final By logoutButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void HomeCheck() {
        System.out.println(driver.findElement(homeCheck).isDisplayed());
    }

    public void SingInAndSignUpButton() {
        WebElement textField = driver.findElement(singInAndSignUpButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void setEmailAddressField(String emailAddressFieldtext) {
        driver.findElement(emailAddressField).sendKeys(emailAddressFieldtext);
    }

    public void setPasswordField(String passwordFieldtext) {
        driver.findElement(passwordField).sendKeys(passwordFieldtext);
    }

    public void setSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void checkUserNameBar() {
        driver.findElement(usernameInBar).isDisplayed();
    }

    private void clickLogoutButton() {
        WebElement textField = driver.findElement(logoutButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void logIn(String emailAddressFieldtext, String passwordFieldtext) {
        setEmailAddressField(emailAddressFieldtext);
        setPasswordField(passwordFieldtext);
        setSignUpButton();
    }

    public void logOut() {
        clickLogoutButton();
    }
}
