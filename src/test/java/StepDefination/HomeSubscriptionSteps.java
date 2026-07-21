package StepDefination;

import Hooks.Hook;
import Pages.HomeSubscriptionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSubscriptionSteps {

    private HomeSubscriptionPage subscriptionPage;

    @When("they scroll to or reveal the footer subscription area")
    public void theyScrollToOrRevealTheFooterSubscriptionArea() {
        subscriptionPage = new HomeSubscriptionPage(Hook.driver);
        subscriptionPage.HomeCheck();
        subscriptionPage.verifySubscriptionFun();
    }

    @And("they type {string} into the newsletter field")
    public void theyTypeIntoTheNewsletterField(String email) {
        subscriptionPage.setEmailVerication(email);
    }

    @And("they click the submit button")
    public void theyClickTheSubmitButton() {
        subscriptionPage.clickOnSubmitButtonVerication();
    }

    @Then("the subscription confirmation message should be visible")
    public void theSubscriptionConfirmationMessageShouldBeVisible() {
        subscriptionPage.verifySubscriptionFun();
    }
}
