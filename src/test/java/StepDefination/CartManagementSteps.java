package StepDefination;

import Hooks.Hook;
import Pages.ProductQuantityInCart;
import Pages.ProductWithCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps {

    private ProductQuantityInCart quantityPage;
    private ProductWithCart withCartPage;

    @When("they open the first product's detail page")
    public void theyOpenTheFirstProductsDetailPage() {
        quantityPage = new ProductQuantityInCart(Hook.driver);
        quantityPage.clickOnViewProduct();
        quantityPage.verifyProductDetailIsOpened();
    }

    @And("they add that product to the cart")
    public void theyAddThatProductToTheCart() {
        quantityPage.clickOnAddToCartFirstProduct();
        quantityPage.clickOnAddToCart();
    }

    @And("they open the cart view")
    public void theyOpenTheCartView() {
        quantityPage.clickOnViewCart();
    }

    @Then("the cart should show the added product with its details")
    public void theCartShouldShowTheAddedProductWithItsDetails() {
        quantityPage.verifyDetailsOfFirstProduct();
    }

    @When("they choose a product from the home page")
    public void theyChooseAProductFromTheHomePage() {
        withCartPage = new ProductWithCart(Hook.driver);
        withCartPage.chooseProductFromHome();
    }

    @And("they go to the cart page")
    public void theyGoToTheCartPage() {
        withCartPage.goToCart();
    }

    @Then("the cart page header should be displayed")
    public void theCartPageHeaderShouldBeDisplayed() {
        withCartPage.checkVerifyCartPage();
    }

    @When("they delete the product from the cart")
    public void theyDeleteTheProductFromTheCart() {
        withCartPage.checkDeleteProductFromCart();
    }

    @Then("the cart should display that it is empty")
    public void theCartShouldDisplayThatItIsEmpty() {
        withCartPage.checkVerifyCartEmpty();
    }
}
