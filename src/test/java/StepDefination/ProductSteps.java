package StepDefination;

import Hooks.Hook;
import Pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductSteps {

    private ProductPage productPage;

    @When("they click on the Products link in the header")
    public void theyClickOnTheProductsLinkInTheHeader() {
        productPage = new ProductPage(Hook.driver);
        productPage.productsButtonFun();
    }

    @Then("the products listing should be visible")
    public void theProductsListingShouldBeVisible() {
        productPage.verifyProductsButtonFun();
        productPage.verifyProductsVisableFun();
    }

    @When("they open the first product's detail view")
    public void theyOpenTheFirstProductsDetailView() {
        productPage.clickOnViewProductFun();
        productPage.checkNavigationIntoRightProductFun();
    }

    @Then("the product name should be {string}")
    public void theProductNameShouldBe(String expectedName) {
        Assert.assertEquals(productPage.getProductNameText(), expectedName, "Product name mismatch");
    }

    @And("the category should mention {string}")
    public void theCategoryShouldMention(String expectedCategory) {
        Assert.assertEquals(productPage.getProductCategoryText(), expectedCategory, "Product category mismatch");
    }

    @And("the price should be {string}")
    public void thePriceShouldBe(String expectedPrice) {
        Assert.assertEquals(productPage.getProductPriceText(), expectedPrice, "Product price mismatch");
    }

    @And("the availability, condition, and brand labels should be displayed")
    public void availabilityConditionAndBrandLabelsShouldBeDisplayed() {
        Assert.assertTrue(productPage.getProductAvailabilityText().contains("Availability"), "Availability label not displayed");
        Assert.assertTrue(productPage.getProductConditionText().contains("Condition"), "Condition label not displayed");
        Assert.assertTrue(productPage.getProductBrandText().contains("Brand"), "Brand label not displayed");
    }

    @When("they navigate to the Products page")
    public void theyNavigateToTheProductsPage() {
        productPage = new ProductPage(Hook.driver);
        productPage.productsButtonFun();
        productPage.verifyProductsButtonFun();
        productPage.verifyProductsVisableFun();
    }

    @And("they type {string} into the search field")
    public void theyTypeIntoTheSearchField(String query) {
        productPage.addValueToSearchBar(query);
    }

    @And("they submit the search")
    public void theySubmitTheSearch() {
        productPage.clickOnSearchButton();
    }

    @Then("the matching product results should appear with a heading for the search")
    public void matchingProductResultsShouldAppearWithHeading() {
        Assert.assertTrue(productPage.isSearchResultsHeadingVisible(), "Search result heading missing");
    }

    @And("the related search products section should remain visible")
    public void relatedSearchProductsSectionShouldRemainVisible() {
        Assert.assertTrue(productPage.isRelatedSearchProductsVisible(), "Related search products section missing");
    }
}
