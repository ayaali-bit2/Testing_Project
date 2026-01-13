package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductWithCart {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductWithCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By homeLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");

    private By firstProductImage = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/img");
    private By secondProductImage = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/img");
    private By firstProductHoverArea = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
    private By secondProductHoverArea = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");

    private By continueShoppingButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[1]/div/div/div[3]/button");
    private By viewCartLink = By.xpath("(//a[@href=\"/view_cart\"])[2]");

    private By firstProductNameInCart = By.cssSelector("#product-1 > td.cart_description > p");
    private By secondProductNameInCart = By.cssSelector("#product-2 > td.cart_description > h4 > a");

    private By firstProductPriceInCart = By.cssSelector("#product-1 > td.cart_price > p");
    private By firstProductQuantityInCart = By.cssSelector("#product-1 > td.cart_quantity > button");
    private By firstProductTotalPriceInCart = By.cssSelector("#product-1 > td.cart_total > p");

    private By secondProductPriceInCart = By.cssSelector("#product-2 > td.cart_price > p");
    private By secondProductQuantityInCart = By.cssSelector("#product-2 > td.cart_quantity > button");
    private By secondProductTotalPriceInCart = By.cssSelector("#product-2 > td.cart_total > p");

    private By homeProductImage = By.xpath("//img[@src=\"/get_product_picture/2\"]");
    private By homeAddToCartButton = By.xpath("(//a[@data-product-id=\"2\"])[2]");

    private By cartTable = By.xpath("//td[@class=\"image\"]");
    private By deleteProductButton = By.xpath("//a[@class=\"cart_quantity_delete\"]");
    private By emptyCartMessage = By.xpath("//span[@id=\"empty_cart\"]");

    public void verifyHomeLinkIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLink));
        Assert.assertTrue(driver.findElement(homeLink).isDisplayed(), "Home link is not displayed");
    }

    public void navigateToProductsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(productsButton));
        driver.findElement(productsButton).click();
    }

    public void addFirstProductToCart() {
        Actions actions = new Actions(driver);
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductImage));
        actions.moveToElement(product).perform();
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(firstProductHoverArea));
        addButton.click();
    }

    public void addSecondProductToCart() {
        Actions actions = new Actions(driver);
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductImage));
        actions.moveToElement(product).perform();
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(secondProductHoverArea));
        addButton.click();
    }

    public void continueShopping() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueBtn.click();
    }

    public void navigateToCart() {
        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        cartLink.click();
    }

    public void verifyFirstProductIsAddedToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductNameInCart));
        Assert.assertTrue(driver.findElement(firstProductNameInCart).isDisplayed(), "First product not added to cart");
    }

    public void verifySecondProductIsAddedToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductNameInCart));
        Assert.assertTrue(driver.findElement(secondProductNameInCart).isDisplayed(), "Second product not added to cart");
    }

    public void verifyFirstProductDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductPriceInCart));
        Assert.assertTrue(driver.findElement(firstProductPriceInCart).isDisplayed(), "First product price not displayed");
        Assert.assertTrue(driver.findElement(firstProductQuantityInCart).isDisplayed(), "First product quantity not displayed");
        Assert.assertTrue(driver.findElement(firstProductTotalPriceInCart).isDisplayed(), "First product total price not displayed");
    }

    public void verifySecondProductDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductPriceInCart));
        Assert.assertTrue(driver.findElement(secondProductPriceInCart).isDisplayed(), "Second product price not displayed");
        Assert.assertTrue(driver.findElement(secondProductQuantityInCart).isDisplayed(), "Second product quantity not displayed");
        Assert.assertTrue(driver.findElement(secondProductTotalPriceInCart).isDisplayed(), "Second product total price not displayed");
    }

    public void addProductFromHome() {
        Actions actions = new Actions(driver);
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(homeProductImage));
        actions.moveToElement(product).perform();
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(homeAddToCartButton));
        addButton.click();
    }

    public void verifyCartPageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTable));
        Assert.assertTrue(driver.findElement(cartTable).isDisplayed(), "Cart page is not displayed");
    }

    public void removeProductFromCart() {
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteProductButton));
        deleteBtn.click();
    }

    public void verifyCartIsEmpty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
        Assert.assertTrue(driver.findElement(emptyCartMessage).isDisplayed(), "Cart is not empty");
    }
}
