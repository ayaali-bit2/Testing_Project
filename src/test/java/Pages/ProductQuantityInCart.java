package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductQuantityInCart {

    private final WebDriver driver;

    public ProductQuantityInCart(WebDriver driver) {
        this.driver = driver;
    }

    private final By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private final By viewProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a");
    private final By productDetailIsOpened = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > img.newarrival");
    private final By firstProductQuantity = By.cssSelector("#quantity");
    private final By addToCartButton = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button");
    private final By viewCartLink = By.cssSelector("#cartModal > div > div > div.modal-body > p:nth-child(2) > a");
    private final By quantityOfProductInCart = By.cssSelector("#product-1 > td.cart_quantity > button");

    public void HomeCheck() {
        Assert.assertTrue(driver.findElement(homeCheck).isDisplayed(), "Home link should be visible");
    }

    public void clickOnViewProduct() {
        WebElement textField = driver.findElement(viewProduct);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void verifyProductDetailIsOpened() {
        Assert.assertTrue(driver.findElement(productDetailIsOpened).isDisplayed(), "Product detail page should be displayed");
    }

    public void setProductQuantity(String quantity) {
        WebElement quantityInput = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(firstProductQuantity));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void clickOnAddToCart() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        element.click();
    }

    public void clickOnViewCart() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(viewCartLink));
        element.click();
    }

    public void verifyCartQuantity(String expectedQuantity) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(quantityOfProductInCart));
        String actualQuantity = element.getText().trim();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Cart quantity should match the requested value");
    }
}
