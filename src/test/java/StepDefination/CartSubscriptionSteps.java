package StepDefination;

import Hooks.Hook;
import Pages.CartSubscriptionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSubscriptionSteps {

    private CartSubscriptionPage subscriptionPage;

    @When("they open the cart panel or click on the cart button")
    public void theyOpenTheCartPanelOrClickOnTheCartButton() {
        subscriptionPage = new CartSubscriptionPage(Hook.driver);
        subscriptionPage.HomeCheck();
        subscriptionPage.clickOnCartButton();
    }

    @And("they focus on the newsletter input")
    public void theyFocusOnTheNewsletterInput() {
        subscriptionPage.verifySubscriptionFun();
    }

    @And("they enter {string}")
    public void theyEnter(String email) {
        subscriptionPage.setEmailVerication(email);
    }

    @And("they submit the subscription")
    public void theySubmitTheSubscription() {
        subscriptionPage.clickOnSubmitButtonVerication();
    }

    @Then("the subscription confirmation area should be displayed")
    public void theSubscriptionConfirmationAreaShouldBeDisplayed() {
        subscriptionPage.verifySubscriptionFun();
    }
}
