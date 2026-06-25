package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductQuantityInCart {

    WebDriver driver;
    WebDriverWait wait;
    String quantity;

    public ProductQuantityInCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    By viewProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a");
    By productDetailIsOpened = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > img.newarrival");
    By firstProductQuantity = By.cssSelector("#quantity");
    By addToCartButton = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button");
    By viewCartLink = By.cssSelector("#cartModal > div > div > div.modal-body > p:nth-child(2) > a");
    By quantityOfProductInCart = By.cssSelector("#product-1 > td.cart_quantity > button");

    public void HomeCheck() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(homeCheck));
        System.out.println(element.isDisplayed());
    }

    public void clickOnViewProduct() {
        WebElement textField = wait.until(ExpectedConditions.elementToBeClickable(viewProduct));
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void verifyProductDetailIsOpened() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailIsOpened));
        System.out.println(element.isDisplayed());
    }

    public void clickOnAddToCartFirstProduct() {
        WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductQuantity));
        quantity = "4";
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        elementToHover.clear();
        elementToHover.sendKeys(quantity);
    }

    public void clickOnAddToCart() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        button.click();
    }

    public void clickOnViewCart() {
        WebElement textField = wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void verifyDetailsOfFirstProduct() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityOfProductInCart));
        String value = element.getText();
        System.out.println(value.equals(quantity));
    }
}
