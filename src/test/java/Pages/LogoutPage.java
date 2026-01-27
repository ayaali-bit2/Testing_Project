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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By homeSectionHeader = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private By signInAndSignUpLink = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private By newUserSignUpHeader = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2");
    private By emailAddressField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)");
    private By passwordField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)");
    private By signUpButton = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button");
    private By usernameInBar = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private By logoutLink = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    public void verifyHomeSectionIsDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(homeSectionHeader));
        Assert.assertTrue(element.isDisplayed(), "Home section header should be displayed.");
    }

    public void clickSignInAndSignUp() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signInAndSignUpLink));
        element.click();
    }

    public void verifyNewUserSignUpSectionIsVisible() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(newUserSignUpHeader));
        Assert.assertTrue(element.isDisplayed(), "New user sign-up section should be visible.");
    }

    public void enterEmailAddress(String email) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        element.clear();
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        element.clear();
        element.sendKeys(password);
    }

    public void clickSignUp() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        element.click();
    }

    public void verifyUsernameIsDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInBar));
        Assert.assertTrue(element.isDisplayed(), "Username should be displayed in the navigation bar.");
    }

    public void clickLogout() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        element.click();
    }
}
