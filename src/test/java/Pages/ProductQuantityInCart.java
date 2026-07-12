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

    By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    By viewProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a");
    By productDetailIsOpened = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > img.newarrival");
    By firstProductQuantity = By.cssSelector("#quantity");
    By addToCartButton = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button");
    By viewCartLink = By.cssSelector("#cartModal > div > div > div.modal-body > p:nth-child(2) > a");

    public void HomeCheck() {
        Assert.assertTrue(driver.findElement(homeCheck).isDisplayed(), "Home page header is not visible.");
    }

    public void clickOnViewProduct() {
        WebElement textField = driver.findElement(viewProduct);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void verifyProductDetailIsOpened() {
        Assert.assertTrue(driver.findElement(productDetailIsOpened).isDisplayed(), "Product details page is not opened.");
    }

    public void clickOnAddToCartFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductQuantity));
        quantityInput.clear();
        quantityInput.sendKeys("4");
    }

    public void clickOnAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
    }

    public void clickOnViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        viewCart.click();
    }
}
