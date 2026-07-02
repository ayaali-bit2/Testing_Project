package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesPage {

    WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    By testCaseButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    By verifyTestCasesButton = By.cssSelector("#form > div > div.row > div > h2 > b");

    public void HomeCheck() {
        System.out.println(driver.findElement(homeCheck).isDisplayed());
    }

    public void testCasesButtonFun() {
        WebElement textField = driver.findElement(testCaseButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void verifyTestCasesButtonFun(){
        System.out.println(driver.findElement(verifyTestCasesButton).isDisplayed());
    }

}
