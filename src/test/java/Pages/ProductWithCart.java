package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductWithCart extends BasePage {

    private final By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private final By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    private final By selectFirstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/img");
    private final By selectSecondProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/img");
    private final By hoverOnFirstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div");
    private final By hoverOnSecondProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div");
    private final By continoueShopping = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[1]/div/div/div[3]/button");
    private final By viewCartLink = By.xpath("(//a[@href=\"/view_cart\"])[2]");
    private final By firstProductAddedToCart = By.cssSelector("#product-1 > td.cart_description > p");
    private final By secondProductAddedToCart = By.cssSelector("#product-2 > td.cart_description > h4 > a");
    private final By firstProductPriceInCartPage = By.cssSelector("#product-1 > td.cart_price > p");
    private final By firstProductQuantityInCartPage = By.cssSelector("#product-1 > td.cart_quantity > button");
    private final By firstProductTotalPriceInCartPage = By.cssSelector("#product-1 > td.cart_total > p");
    private final By secondProductPriceInCartPage = By.cssSelector("#product-2 > td.cart_price > p");
    private final By secondProductQuantityInCartPage = By.cssSelector("#product-2 > td.cart_quantity > button");
    private final By secondProductTotalPriceInCartPage = By.cssSelector("#product-2 > td.cart_total > p");
    private final By hoverProductFromHome = By.xpath("//img[@src=\"/get_product_picture/2\"]");
    private final By clickAddToCartHome = By.xpath("(//a[@data-product-id=\"2\"])[2]");
    private final By verifyCartPage = By.xpath("//td[@class=\"image\"]");
    private final By deleteProductFromCart = By.xpath("//a[@class=\"cart_quantity_delete\"]");
    private final By verifyCartEmpty = By.xpath("//span[@id=\"empty_cart\"]");
    private final By cartButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");

    public ProductWithCart(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        logger.debug("Scrolled the window on HomeCheck");
    }

    public void goToProductsPage() {
        navigateToHref(productsButton, "navigate to products page");
    }

    public void clickOnAddToCartFirstProduct() {
        WebElement elementToHover = findElement(selectFirstProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        WebElement hoverTarget = wait.until(ExpectedConditions.elementToBeClickable(hoverOnFirstProduct));
        hoverTarget.click();
        logger.info("Added first product to cart");
    }

    public void clickOnAddToCartSecondProduct() {
        WebElement elementToHover = findElement(selectSecondProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        WebElement hoverTarget = wait.until(ExpectedConditions.elementToBeClickable(hoverOnSecondProduct));
        hoverTarget.click();
        logger.info("Added second product to cart");
    }

    public void goToContinueShopping() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continoueShopping));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", continueButton);
        logger.info("Clicked on continue shopping");
    }

    public void goToCart() {
        navigateToHref(viewCartLink, "navigate to cart page");
    }

    public void verifyFirstProductAddedToCart() {
        findElement(firstProductAddedToCart);
        logger.info("First product is displayed in cart");
    }

    public void verifySecondProductAddedToCart() {
        findElement(secondProductAddedToCart);
        logger.info("Second product is displayed in cart");
    }

    public void verifyDetailsOfFirstProduct() {
        findElement(firstProductPriceInCartPage);
        findElement(firstProductQuantityInCartPage);
        findElement(firstProductTotalPriceInCartPage);
        logger.info("First product pricing details are visible in cart");
    }

    public void verifyDetailsOfSecondProduct() {
        findElement(secondProductPriceInCartPage);
        findElement(secondProductQuantityInCartPage);
        findElement(secondProductTotalPriceInCartPage);
        logger.info("Second product pricing details are visible in cart");
    }

    public void chooseProductFromHome() {
        WebElement elementToHover = findElement(hoverProductFromHome);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickAddToCartHome));
        button.click();
        logger.info("Added product from home section to cart");
    }

    public void checkVerifyCartPage() {
        findElement(verifyCartPage);
        logger.info("Cart verification section is visible");
    }

    public void checkDeleteProductFromCart() {
        click(deleteProductFromCart);
        logger.info("Deleted product from cart");
    }

    public void checkVerifyCartEmpty() {
        findElement(verifyCartEmpty);
        logger.info("Cart is empty");
    }

    public void clickOnCartButton() {
        navigateToHref(cartButton, "navigate to cart page");
    }
}
