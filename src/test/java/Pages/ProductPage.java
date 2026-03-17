package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage extends BasePage {

    private final By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    private final By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    private final By verifyProductsButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    private final By verifyProductsListVisible = By.xpath("/html/body/section[2]/div/div/div[2]");
    private final By clickOnViewProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private final By checkNavigationIntoRightProduct = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    private final By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    private final By productCategory = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    private final By productPrice = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    private final By productAvailability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b");
    private final By productCondition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
    private final By productBrand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b");
    private final By searchBar = By.xpath("//*[@id=\"search_product\"]");
    private final By searchButton = By.xpath("//*[@id=\"search_product\"]");
    private final By verifySearchedProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    private final By relatedSearchProducts = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void productsButtonFun() {
        navigateToHref(productsButton, "navigate to products");
    }

    public void verifyProductsButtonFun() {
        findElement(verifyProductsButton);
        logger.info("Products heading is visible");
    }

    public void verifyProductsVisableFun() {
        findElement(verifyProductsListVisible);
        logger.info("Product listings are visible");
    }

    public void clickOnViewProductFun() {
        navigateToHref(clickOnViewProduct, "navigate to the first product detail");
    }

    public void checkNavigationIntoRightProductFun() {
        findElement(checkNavigationIntoRightProduct);
        logger.info("Navigation landed on the correct product");
    }

    public void checkDetailsOfFirstProduct() {
        String productNameText = readText(productName);
        Assert.assertEquals(productNameText, "Blue Top", "Product Name Fail");

        String productCategoryText = readText(productCategory);
        Assert.assertEquals(productCategoryText, "Category: Women > Tops", "Product Category Fail");

        String productPriceText = readText(productPrice);
        Assert.assertEquals(productPriceText, "Rs. 500", "Product Price Fail");

        String productAvailabilityText = readText(productAvailability);
        Assert.assertEquals(productAvailabilityText, "Availability:", "Product Avability Fail");

        String productConditionText = readText(productCondition);
        Assert.assertEquals(productConditionText, "Condition:", "Product Condition Fail");

        String productBrandText = readText(productBrand);
        Assert.assertEquals(productBrandText, "Brand:", "Product Brand Fail");
    }

    public void addValueToSearchBar(String product) {
        type(searchBar, product);
    }

    public void clickOnSearchButton() {
        click(searchButton);
    }

    public void verifySearchedProductFun() {
        findElement(verifySearchedProduct);
        logger.info("Searched product section is visible");
    }

    public void getRelatedSearchProductsFun() {
        findElement(relatedSearchProducts);
        logger.info("Related products listing is visible");
    }
}
