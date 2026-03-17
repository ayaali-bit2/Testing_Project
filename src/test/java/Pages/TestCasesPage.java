package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {

    private final By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private final By testCaseButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    private final By verifyTestCasesButton = By.cssSelector("#form > div > div.row > div > h2 > b");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void testCasesButtonFun() {
        navigateToHref(testCaseButton, "navigate to test cases");
    }

    public void verifyTestCasesButtonFun() {
        findElement(verifyTestCasesButton);
        logger.info("Test cases header is visible");
    }
}
