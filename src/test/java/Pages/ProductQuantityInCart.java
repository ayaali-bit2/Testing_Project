package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductQuantityInCart extends BasePage {

    private final By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private final By viewProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a");
    private final By productDetailIsOpened = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > img.newarrival");
    private final By firstProductQuantity = By.cssSelector("#quantity");
    private final By addToCartButton = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button");
    private final By viewCartLink = By.cssSelector("#cartModal > div > div > div.modal-body > p:nth-child(2) > a");
    private final By quantityOfProductInCart = By.cssSelector("#product-1 > td.cart_quantity > button");
    private final By cartModalProductId = By.cssSelector("#product_id");

    private String quantity;

    public ProductQuantityInCart(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void clickOnViewProduct() {
        navigateToHref(viewProduct, "navigate to first view product");
    }

    public void verifyProductDetailIsOpened() {
        findElement(productDetailIsOpened);
        logger.info("Product details page is visible");
    }

    public void clickOnAddToCartFirstProduct() {
        WebElement quantityElement = findElement(firstProductQuantity);
        Actions actions = new Actions(driver);
        actions.moveToElement(quantityElement).perform();
        quantityElement.clear();
        quantity = "4";
        quantityElement.sendKeys(quantity);
        logger.info("Updated quantity to {}", quantity);
    }

    public void clickOnAddToCart() {
        click(addToCartButton);
        logger.info("Clicked Add to Cart button");
    }

    public void clickOnViewCart() {
        navigateToHref(viewCartLink, "navigate to cart from modal");
    }

    public void verifyDetailsOfFirstProduct() {
        WebElement element = findElement(quantityOfProductInCart);
        wait.until(ExpectedConditions.visibilityOf(element));
        String value = element.getText();
        logger.info("Quantity in cart: {} expected: {}", value, quantity);
    }
}
