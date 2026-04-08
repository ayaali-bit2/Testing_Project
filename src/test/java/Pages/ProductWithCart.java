package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductWithCart {
    private static final Logger logger = LogManager.getLogger(ProductWithCart.class);
    WebDriver driver;

    public ProductWithCart(WebDriver driver) {
        this.driver = driver;
    }

    By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");

    By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");

    By selectFirstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/img");
    By selectSecondProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/img");

    By hoverOnFirstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div");
    By hoverOnSecondProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div");

    By continoueShopping = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[1]/div/div/div[3]/button");

    By viewCartLink = By.xpath("(//a[@href=\"/view_cart\"])[2]");

    By firstProductAddedToCart = By.cssSelector("#product-1 > td.cart_description > p");
    By secondProductAddedToCart = By.cssSelector("#product-2 > td.cart_description > h4 > a");

    By firstProductPriceInCartPage = By.cssSelector("#product-1 > td.cart_price > p");
    By firstProductQuantityInCartPage = By.cssSelector("#product-1 > td.cart_quantity > button");
    By firstProductTotalPriceInCartPage = By.cssSelector("#product-1 > td.cart_total > p");

    By seconedProductPriceInCartPage = By.cssSelector("#product-2 > td.cart_price > p");
    By seconedProductQuantityInCartPage = By.cssSelector("#product-2 > td.cart_quantity > button");
    By seconedProductTotalPriceInCartPage = By.cssSelector("#product-2 > td.cart_total > p");

    By hoverProductFromHome = By.xpath("//img[@src=\"/get_product_picture/2\"]");
    By clickAddToCartHome = By.xpath("(//a[@data-product-id=\"2\"])[2]");

    By verifyCartPage = By.xpath("//td[@class=\"image\"]");
    By deleteProductFromCart = By.xpath("//a[@class=\"cart_quantity_delete\"]");

    By verifyCartEmpty = By.xpath("//span[@id=\"empty_cart\"]");

    public void HomeCheck() {
        boolean homeVisible = driver.findElement(homeCheck).isDisplayed();
        logger.info("Home check visibility: {}", homeVisible);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        logger.debug("Scrolled down on home page by 500 pixels");
    }

    public void goToProductsPage() {
        WebElement textField = driver.findElement(productsButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
        logger.info("Navigated to products page: {}", value2);
    }

    public void clickOnAddToCartFirstProduct(){
        WebElement elementToHover = driver.findElement(selectFirstProduct);

        // Find the element to click (can be the same or revealed after hover)
        WebElement elementToClick = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));

        // Create Actions instance
        Actions actions = new Actions(driver);

        // Perform hover and click
        actions.moveToElement(elementToHover).perform();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(hoverOnFirstProduct));
        elementToClick.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Clicked Add to Cart for first product");
    }

    public void clickOnAddToCartSeconedProduct(){
        WebElement elementToHover = driver.findElement(selectSecondProduct);

        // Find the element to click (can be the same or revealed after hover)
        WebElement elementToClick = driver.findElement(hoverOnSecondProduct);

        // Create Actions instance
        Actions actions = new Actions(driver);

        // Perform hover and click
        actions.moveToElement(elementToHover).perform();
        elementToClick.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Clicked Add to Cart for second product");
    }

    public void goTocontinoueShopping(){
//        WebElement textField = driver.findElement(continoueShopping);
//        textField.click();
        //driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the modal is visible and the button is clickable
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continoueShopping));
        continueButton.click();
        logger.info("Clicked Continue Shopping");
    }

    public void goToCart(){
        WebElement textField = driver.findElement(viewCartLink);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
        logger.info("Navigated to cart page: {}", value2);
    }

    public void verifyFirstProductAddedToCart(){
        boolean firstProductVisible = driver.findElement(firstProductAddedToCart).isDisplayed();
        logger.info("First product added to cart visible: {}", firstProductVisible);
    }

    public void verifySeconedProductAddedToCart(){
        boolean secondProductVisible = driver.findElement(secondProductAddedToCart).isDisplayed();
        logger.info("Second product added to cart visible: {}", secondProductVisible);
    }

    public void verifyDetailsOfFirstProduct(){
        boolean firstPriceVisible = driver.findElement(firstProductPriceInCartPage).isDisplayed();
        boolean firstQuantityVisible = driver.findElement(firstProductQuantityInCartPage).isDisplayed();
        boolean firstTotalVisible = driver.findElement(firstProductTotalPriceInCartPage).isDisplayed();

        logger.info("First product details visibility - price: {}, quantity: {}, total: {}",
                firstPriceVisible, firstQuantityVisible, firstTotalVisible);
    }

    public void verifyDetailsOfSecondProduct(){
        boolean secondPriceVisible = driver.findElement(seconedProductPriceInCartPage).isDisplayed();
        boolean secondQuantityVisible = driver.findElement(seconedProductQuantityInCartPage).isDisplayed();
        boolean secondTotalVisible = driver.findElement(seconedProductTotalPriceInCartPage).isDisplayed();

        logger.info("Second product details visibility - price: {}, quantity: {}, total: {}",
                secondPriceVisible, secondQuantityVisible, secondTotalVisible);
    }

    public void chooseProductFromHome(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

        WebElement elementToHover = driver.findElement(hoverProductFromHome);

        // Find the element to click (can be the same or revealed after hover)
        WebElement elementToClick = driver.findElement(clickAddToCartHome);

        // Create Actions instance
        Actions actions = new Actions(driver);

        // Perform hover and click
        actions.moveToElement(elementToHover).perform();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(clickAddToCartHome));
        elementToClick.click();
        logger.info("Selected product from home and clicked Add to Cart");
    }

    public void checkVerifyCartPage(){
        boolean cartPageVisible = driver.findElement(verifyCartPage).isDisplayed();
        logger.info("Cart page verification element visible: {}", cartPageVisible);
    }

    public void checkDeleteProductFromCart(){
        driver.findElement(deleteProductFromCart).click();
        logger.info("Clicked delete product from cart");
    }

    public void checkVerifyCartEmpty(){
        boolean cartEmptyVisible = driver.findElement(verifyCartEmpty).isDisplayed();
        logger.info("Cart empty message visible: {}", cartEmptyVisible);
    }
}