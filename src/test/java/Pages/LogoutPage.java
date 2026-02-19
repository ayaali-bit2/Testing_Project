package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {

    private final By newUserSignUpVisible = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void NewUserSignUpVisible() {
        System.out.println(driver.findElement(newUserSignUpVisible).isDisplayed());
    }
}
