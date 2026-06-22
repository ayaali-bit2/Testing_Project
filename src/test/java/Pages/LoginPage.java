package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By homeCheck = By.cssSelector("div.features_items h2");
    By singInAndSignUpButton = By.cssSelector("a[href='/login']");
    By emailAddressField = By.cssSelector("input[data-qa='login-email']");
    By passwordField = By.cssSelector("input[data-qa='login-password']");
    By signUpButton = By.cssSelector("button[data-qa='login-button']");
    By usernameInBar = By.xpath("//a[contains(.,'Logged in as')]");
    By delet = By.cssSelector("a[href='/delete_account']");
    By checkDeleted = By.cssSelector("h2[data-qa='account-deleted']");
    By invalidLoginMessage = By.xpath("//p[contains(text(),'incorrect')]");

    public void HomeCheck() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeCheck));
    }

    public void SingInAndSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(singInAndSignUpButton)).click();
        wait.until(ExpectedConditions.urlContains("/login"));
    }

    public void setEmailAddressField(String emailAddressFieldtext) {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressField));
        email.clear();
        email.sendKeys(emailAddressFieldtext);
    }

    public void setPasswordField(String passwordFieldtext) {
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        password.clear();
        password.sendKeys(passwordFieldtext);
    }

    public void setSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
        wait.until(webDriver ->
                "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState")));
    }

    public void loginAs(String email, String password) {
        setEmailAddressField(email);
        setPasswordField(password);
        setSignUpButton();
    }

    public void checkUserNameBar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInBar));
    }

    public void deleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(delet)).click();
    }

    public void checkIsDeleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkDeleted));
    }

    public void checkInValidLoginMessageVisability() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginMessage));
    }
}