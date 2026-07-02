package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductQuantityInCart {

    private WebDriver driver;
    private WebDriverWait wait;
    private String quantity;

    private By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private By viewProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a");
    private By productDetailIsOpened = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > img.newarrival");
    private By firstProductQuantity = By.cssSelector("#quantity");
    private By addToCartButton = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button");
    private By viewCartLink = By.cssSelector("#cartModal > div > div > div.modal-body > p:nth-child(2) > a");
    private By quantityOfProductInCart = By.cssSelector("#product-1 > td.cart_quantity > button");

    public ProductQuantityInCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void HomeCheck() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(homeCheck));
        System.out.println(element.isDisplayed());
    }

    public void clickOnViewProduct() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(viewProduct));
        String url = element.getAttribute("href");
        driver.navigate().to(url);
    }

    public void verifyProductDetailIsOpened() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailIsOpened));
        System.out.println(element.isDisplayed());
    }

    public void clickOnAddToCartFirstProduct() {
        WebElement quantityInput = wait.until(ExpectedConditions.elementToBeClickable(firstProductQuantity));
        WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#product_id")));
        Actions actions = new Actions(driver);
        quantity = "4";
        actions.moveToElement(quantityInput).perform();
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        elementToClick.click();
    }

    public void clickOnAddToCart() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        element.click();
    }

    public void clickOnViewCart() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        String url = link.getAttribute("href");
        driver.navigate().to(url);
    }

    public void verifyDetailsOfFirstProduct() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityOfProductInCart));
        String value = element.getText();
        System.out.println(value.equals(quantity));
    }
}