package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductQuantityInCart {

    private WebDriver driver;

    private By homeLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private By viewProductLink = By.cssSelector(
            "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a");
    private By productDetailImage = By.cssSelector(
            "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > img.newarrival");
    private By quantityField = By.cssSelector("#quantity");
    private By addToCartButton = By.cssSelector(
            "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button");
    private By viewCartLink = By.cssSelector(
            "#cartModal > div > div > div.modal-body > p:nth-child(2) > a");
    private By cartQuantityButton = By.cssSelector("#product-1 > td.cart_quantity > button");

    public ProductQuantityInCart(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyHomeLinkIsDisplayed() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(homeLink));
        Assert.assertTrue(element.isDisplayed(), "Home link is not displayed");
    }

    public void clickViewProductLink() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(viewProductLink));
        driver.navigate().to(element.getAttribute("href"));
    }

    public void verifyProductDetailIsDisplayed() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(productDetailImage));
        Assert.assertTrue(element.isDisplayed(), "Product detail is not displayed");
    }

    public void setQuantityForFirstProduct(String quantity) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(quantityField));
        element.clear();
        element.sendKeys(quantity);
    }

    public void clickAddToCart() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        element.click();
    }

    public void clickViewCartLink() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(viewCartLink));
        driver.navigate().to(element.getAttribute("href"));
    }

    public void verifyQuantityInCart(String expectedQuantity) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(cartQuantityButton));
        String actualQuantity = element.getText();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Cart quantity does not match expected");
    }
}
