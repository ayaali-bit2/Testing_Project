package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    private By productsPageHeader = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    private By productsListSection = By.xpath("/html/body/section[2]/div/div/div[2]");
    private By viewProductLink = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private By productDetailsHeader = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    private By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    private By productCategory = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    private By productPrice = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    private By productAvailability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b");
    private By productCondition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
    private By productBrand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b");
    private By searchBar = By.xpath("//*[@id=\"search_product\"]");
    private By searchButton = By.xpath("//*[@id=\"search_product\"]");
    private By searchedProductsHeader = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    private By relatedProductsSection = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p");

    public void verifyHomePageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeCheck));
        Assert.assertTrue(driver.findElement(homeCheck).isDisplayed(), "Home link is not displayed");
    }

    public void goToProductsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(productsButton));
        driver.findElement(productsButton).click();
    }

    public void verifyProductsPageHeaderDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPageHeader));
        Assert.assertTrue(driver.findElement(productsPageHeader).isDisplayed(), "Products page header is not displayed");
    }

    public void verifyProductsListDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsListSection));
        Assert.assertTrue(driver.findElement(productsListSection).isDisplayed(), "Products list is not displayed");
    }

    public void viewFirstProductDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(viewProductLink));
        driver.findElement(viewProductLink).click();
    }

    public void verifyProductDetailsPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailsHeader));
        Assert.assertTrue(driver.findElement(productDetailsHeader).isDisplayed(), "Product details header is not displayed");
    }

    public void verifyFirstProductDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        Assert.assertEquals(driver.findElement(productName).getText(), "Blue Top", "Product name mismatch");
        Assert.assertEquals(driver.findElement(productCategory).getText(), "Category: Women > Tops", "Product category mismatch");
        Assert.assertEquals(driver.findElement(productPrice).getText(), "Rs. 500", "Product price mismatch");
        Assert.assertEquals(driver.findElement(productAvailability).getText(), "Availability:", "Product availability mismatch");
        Assert.assertEquals(driver.findElement(productCondition).getText(), "Condition:", "Product condition mismatch");
        Assert.assertEquals(driver.findElement(productBrand).getText(), "Brand:", "Product brand mismatch");
    }

    public void enterSearchQuery(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys(product);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
    }

    public void verifySearchResultsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsHeader));
        Assert.assertTrue(driver.findElement(searchedProductsHeader).isDisplayed(), "Search results header is not displayed");
    }

    public void verifyRelatedProductsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(relatedProductsSection));
        Assert.assertTrue(driver.findElement(relatedProductsSection).isDisplayed(), "Related products are not displayed");
    }
}
