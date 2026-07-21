package StepDefination;

import Hooks.Hook;
import Pages.RegisterWhileCheckoutCase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterWhileCheckoutSteps {

    private RegisterWhileCheckoutCase checkout;

    @Given("the shopper is on the automationexercise.com home page")
    public void theShopperIsOnTheAutomationexerciseComHomePage() {
        checkout = new RegisterWhileCheckoutCase(Hook.driver);
        checkout.HomeCheck();
    }

    @When("they add the first product to the cart")
    public void theyAddTheFirstProductToTheCart() {
        checkout.clickOnAddToCartFirstProduct();
    }

    @And("they continue shopping")
    public void theyContinueShopping() {
        checkout.goTocontinoueShopping();
    }

    @And("they add a second product to the cart")
    public void theyAddASecondProductToTheCart() {
        checkout.clickOnAddToCartSeconedProduct();
    }

    @And("they go to the cart page")
    public void theyGoToTheCartPage() {
        checkout.goToCartPage();
    }

    @Then("the cart should show the added products")
    public void theCartShouldShowTheAddedProducts() {
        checkout.verifyCartPageFun();
    }

    @When("they proceed to checkout")
    public void theyProceedToCheckout() {
        checkout.ClickOnProcceedToCheckout();
    }

    @And("they choose to register or login")
    public void theyChooseToRegisterOrLogin() {
        checkout.ClickOnRegisterORLogin();
    }

    @And("they key in username {string} and email {string}")
    public void theyKeyInUsernameAndEmail(String username, String email) {
        checkout.setUserName(username);
        checkout.setEmailAddress(email);
    }

    @And("they complete the registration form with title {string}, password {string}, birth date {string}, and enable newsletter and special offers")
    public void theyCompleteTheRegistrationForm(String title, String password, String birthDate) {
        if ("Mr".equalsIgnoreCase(title)) {
            checkout.setMr();
        } else {
            checkout.setMrs();
        }
        checkout.setPassword(password);
        String[] birthParts = birthDate.split(" ");
        if (birthParts.length == 3) {
            checkout.setDayDate(birthParts[0]);
            checkout.setMonthDate(birthParts[1]);
            checkout.setYearDate(birthParts[2]);
        }
        checkout.setNewsLetter();
        checkout.setSpecialOffers();
    }

    @And("they fill their personal details with name {string}, company {string}, address {string}, address2 {string}, country {string}, state {string}, city {string}, zip {string}, and mobile {string}")
    public void theyFillTheirPersonalDetails(String fullName, String company, String address, String address2, String country, String state, String city, String zip, String mobile) {
        String[] nameParts = fullName.split(" ", 2);
        checkout.setFirstName(nameParts[0]);
        checkout.setLastNmae(nameParts.length > 1 ? nameParts[1] : "");
        checkout.setCompanyName(company);
        checkout.setAddressField(address);
        checkout.setAddress2Field(address2);
        checkout.setContoryField(country);
        checkout.setStateField(state);
        checkout.setCityField(city);
        checkout.setZipCode(zip);
        checkout.setMobileNumber(mobile);
    }

    @And("they create the account")
    public void theyCreateTheAccount() {
        checkout.setCreateAccountButton();
    }

    @Then("the site should confirm the new user was created")
    public void theSiteShouldConfirmTheNewUserWasCreated() {
        checkout.verifyNewUserCreated();
    }

    @When("they return to the cart page and proceed to checkout again")
    public void theyReturnToTheCartPageAndProceedToCheckoutAgain() {
        checkout.clickOnCartButton();
        checkout.ClickOnProcceedToCheckout();
    }

    @And("they verify the saved address details and the review your order section")
    public void theyVerifyTheSavedAddressDetailsAndTheReviewYourOrderSection() {
        checkout.verifyAddressDetails();
        checkout.verifyReviewYourOrder();
    }

    @And("they write {string} into the comment box")
    public void theyWriteIntoTheCommentBox(String comment) {
        checkout.writeCommentInTextArea(comment);
    }

    @And("they place the order")
    public void theyPlaceTheOrder() {
        checkout.clickOnPlaceOrder();
    }

    @And("they enter cardholder name {string}, card number {string}, CVC {string}, expiration {string}")
    public void theyEnterCardholderNameCardNumberCvcExpiration(String cardholderName, String cardNumber, String cvc, String expiration) {
        checkout.setNameOnCard(cardholderName);
        checkout.setCardNumber(cardNumber);
        checkout.setCvc(cvc);
        String[] expirationParts = expiration.split("/");
        if (expirationParts.length == 2) {
            checkout.setExpirationMonth(expirationParts[0]);
            checkout.setExpirationYear(expirationParts[1]);
        }
    }

    @And("they confirm the payment")
    public void theyConfirmThePayment() {
        checkout.clickOnPayAndConfirmOrder();
    }

    @Then("the success message should be displayed")
    public void theSuccessMessageShouldBeDisplayed() {
        checkout.checkSuccessMessage();
    }

    @When("they delete the order")
    public void theyDeleteTheOrder() {
        checkout.clickOnDelete();
    }

    @Then("the order deletion confirmation should be visible")
    public void theOrderDeletionConfirmationShouldBeVisible() {
        checkout.verifyCheckDeleted();
    }
}
