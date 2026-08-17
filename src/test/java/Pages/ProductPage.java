package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    By homeCheck = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
    By productsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    By verifyProductsButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");

    By verifyProductsListVisable = By.xpath("/html/body/section[2]/div/div/div[2]");

    By clickOnViewProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");

    By checkNavigationIntoRightProduct = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");

    By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    By productCategory = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    By productPrice = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    By productAvailability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b");
    By productCondition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
    By productBrand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b");

    By searchBar = By.xpath("//*[@id=\"search_product\"]");
    By getSearchButton = By.xpath("//*[@id=\"search_product\"]");

    By verifySearchedProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");

    By relatedSearchProducts = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p");

    public void HomeCheck() {
        org.testng.Assert.assertTrue(driver.findElement(homeCheck).isDisplayed(), "Home page is not displayed");
    }

    public void productsButtonFun() {
        WebElement textField = driver.findElement(productsButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void verifyProductsButtonFun(){
        org.testng.Assert.assertTrue(driver.findElement(verifyProductsButton).isDisplayed(), "Products heading is not displayed");
    }

    public void verifyProductsVisableFun(){
        org.testng.Assert.assertTrue(driver.findElement(verifyProductsListVisable).isDisplayed(), "Products list is not displayed");
    }

    public void clickOnViewProductFun(){
        WebElement textField = driver.findElement(clickOnViewProduct);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void checkNavigationIntoRightProductFun(){
        org.testng.Assert.assertTrue(driver.findElement(checkNavigationIntoRightProduct).isDisplayed(), "Product details are not displayed");
    }

    public void checkDetailsOfFirstProduct(){

        String productNametext = driver.findElement(productName).getText();
        Assert.assertEquals(productNametext,"Blue Top","Product Name Fail");

        String productCategorytext = driver.findElement(productCategory).getText();
        Assert.assertEquals(productCategorytext,"Category: Women > Tops","Product Category Fail");

        String productPricetext = driver.findElement(productPrice).getText();
        Assert.assertEquals(productPricetext,"Rs. 500","Product Price Fail");

        String productAvailabilitytext = driver.findElement(productAvailability).getText();
        Assert.assertEquals(productAvailabilitytext,"Availability:","Product Avability Fail");

        String productConditiontext = driver.findElement(productCondition).getText();
        Assert.assertEquals(productConditiontext,"Condition:","Product Condition Fail");

        String productBrandtext = driver.findElement(productBrand).getText();
        Assert.assertEquals(productBrandtext,"Brand:","Product Brand Fail");

    }

    public void addValueToSearchBar(String product){
        driver.findElement(searchBar).sendKeys(product);
    }

    public void clickOnSearchButton(){
        driver.findElement(getSearchButton).click();
    }

    public void verifySearchedProductFun(){
        org.testng.Assert.assertTrue(driver.findElement(verifySearchedProduct).isDisplayed(), "Search results are not displayed");
    }

    public void getRelatedSearchProductsFun(){
        org.testng.Assert.assertTrue(driver.findElement(relatedSearchProducts).isDisplayed(), "Related search products are not displayed");
    }


}
