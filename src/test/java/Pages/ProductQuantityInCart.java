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

    public ProductQuantityInCart(WebDriver driver) {
        this.driver = driver;
    }

    String quantity;

    By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    By viewProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.choose > ul > li > a");

    By productDetailIsOpened = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > img.newarrival");

    By firstProductQuantity = By.cssSelector("#quantity");

    By addToCartButton = By.cssSelector("body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button");
    By viewCartLink = By.cssSelector("#cartModal > div > div > div.modal-body > p:nth-child(2) > a");

    By quantityOfProductInCart = By.cssSelector("#product-1 > td.cart_quantity > button");

    public void HomeCheck() {
        org.testng.Assert.assertTrue(driver.findElement(homeCheck).isDisplayed(), "Home page is not displayed");
    }

    public void clickOnViewProduct(){
        WebElement textField = driver.findElement(viewProduct);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void verifyProductDetailIsOpened(){
        org.testng.Assert.assertTrue(driver.findElement(productDetailIsOpened).isDisplayed(), "Product detail page is not displayed");
    }

    public void clickOnAddToCartFirstProduct(){
        WebElement elementToHover = driver.findElement(firstProductQuantity);

        // Find the element to click (can be the same or revealed after hover)
        WebElement elementToClick = driver.findElement(By.cssSelector("#product_id"));

        // Create Actions instance
        Actions actions = new Actions(driver);

        quantity = "4";
        // Perform hover and click
        actions.moveToElement(elementToHover).perform();
        elementToHover.clear();
        elementToHover.sendKeys(quantity);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickOnAddToCart(){
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickOnViewCart(){
        WebElement textField = driver.findElement(viewCartLink);
        String value2 = textField.getAttribute("href");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(textField));
        driver.navigate().to(value2);


    }

    public void verifyDetailsOfFirstProduct(){
        WebElement element = driver.findElement(quantityOfProductInCart);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement element2 = wait.until(
                ExpectedConditions.visibilityOf(element));
        String value = element.getText();
        System.out.println(value == quantity);

    }
}
