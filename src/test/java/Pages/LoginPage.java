package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By delet = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    private final By checkDeleted = By.cssSelector("#form > div > div > div > h2 > b");
    private final By invalidLoginMessage = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void deleteButton() {
        WebElement textField = driver.findElement(delet);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void checkIsDeleted() {
        driver.findElement(checkDeleted).isDisplayed();
    }

    public void checkInValidLoginMessageVisability() {
        driver.findElement(invalidLoginMessage).isDisplayed();
    }
}
