package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogoutPage {

        WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }


    By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    By singInAndSignUpButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    By emailAddressField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)");
    By passwordField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)");

    By newUserSignUpVisible = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2");

    By signUpButton = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button");

    By usernameInBar = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");

    By logoutButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    public void HomeCheck() {
        Assert.assertTrue(driver.findElement(homeCheck).isDisplayed(), "Featured items section should be visible on the home page.");
    }

    public void SingInAndSignUpButton() {
        WebElement textField = driver.findElement(singInAndSignUpButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void NewUserSignUpVisible() {
        Assert.assertTrue(driver.findElement(newUserSignUpVisible).isDisplayed(), "New user signup prompt should be present on the logout page.");
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

    public void checkUserNameBar(){
        Assert.assertTrue(driver.findElement(usernameInBar).isDisplayed(), "Username bar should remain visible for verification on the logout page.");
    }

    public void logoutButtonFun() {
        WebElement textField = driver.findElement(logoutButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

}