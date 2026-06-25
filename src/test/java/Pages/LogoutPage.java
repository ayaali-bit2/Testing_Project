package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private By signInAndSignUpButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private By emailAddressField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)");
    private By passwordField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)");
    private By newUserSignUpVisible = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2");
    private By signUpButton = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button");
    private By usernameInBar = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private By logoutButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    public void verifyHomeIsDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(homeCheck));
        Assert.assertTrue(element.isDisplayed(), "Home section is not displayed");
    }

    public void clickSignInAndSignUp() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signInAndSignUpButton));
        String url = element.getAttribute("href");
        driver.navigate().to(url);
    }

    public void verifyNewUserSignUpVisible() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(newUserSignUpVisible));
        Assert.assertTrue(element.isDisplayed(), "New user sign up section is not visible");
    }

    public void enterEmailAddress(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressField));
        element.clear();
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        element.clear();
        element.sendKeys(password);
    }

    public void clickSignUpButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        element.click();
    }

    public void verifyUsernameInBar() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInBar));
        Assert.assertTrue(element.isDisplayed(), "Username is not displayed after login");
    }

    public void clickLogoutButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        String url = element.getAttribute("href");
        driver.navigate().to(url);
    }

}
