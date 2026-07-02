package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private By signInAndSignUpButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private By emailAddressField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)");
    private By passwordField = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)");
    private By signUpButton = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button");
    private By usernameInBar = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private By deleteButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    private By checkDeleted = By.cssSelector("#form > div > div > div > h2 > b");
    private By invalidLoginMessage = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p");

    public void verifyHomeSectionDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(homeCheck));
        Assert.assertTrue(element.isDisplayed(), "Home section is not displayed");
    }

    public void clickSignInAndSignUp() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signInAndSignUpButton));
        String href = element.getAttribute("href");
        driver.navigate().to(href);
    }

    public void enterEmailAddress(String email) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        element.clear();
        element.sendKeys(email);
        Assert.assertEquals(element.getAttribute("value"), email, "Email address input failed");
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        element.clear();
        element.sendKeys(password);
        Assert.assertEquals(element.getAttribute("value"), password, "Password input failed");
    }

    public void clickSignUpButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        element.click();
    }

    public void verifyUserNameDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInBar));
        Assert.assertTrue(element.isDisplayed(), "User name in bar is not displayed");
    }

    public void clickDeleteButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        String href = element.getAttribute("href");
        driver.navigate().to(href);
    }

    public void verifyDeletionConfirmationDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(checkDeleted));
        Assert.assertTrue(element.isDisplayed(), "Deletion confirmation is not displayed");
    }

    public void verifyInvalidLoginMessageVisibility() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginMessage));
        Assert.assertTrue(element.isDisplayed(), "Invalid login message is not displayed");
    }

}