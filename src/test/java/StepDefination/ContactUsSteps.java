package StepDefination;

import Hooks.Hook;
import Pages.ContactUsFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {

    private ContactUsFormPage contactUsFormPage;

    @Given("the visitor is on the automationexercise.com home page")
    public void theVisitorIsOnTheAutomationexerciseComHomePage() {
        contactUsFormPage = new ContactUsFormPage(Hook.driver);
        contactUsFormPage.HomeCheck();
    }

    @When("they click the Contact Us button")
    public void theyClickTheContactUsButton() {
        contactUsFormPage.contactUsFormButtonFun();
    }

    @And("the \"Get In Touch\" section is visible")
    public void theGetInTouchSectionIsVisible() {
        contactUsFormPage.checkGetInTouchVisible();
    }

    @And("they enter {string} as the name")
    public void theyEnterAsTheName(String name) {
        contactUsFormPage.setNameContact(name);
    }

    @And("they enter {string} as the email")
    public void theyEnterAsTheEmail(String email) {
        contactUsFormPage.setEmailContact(email);
    }

    @And("they enter {string} as the subject")
    public void theyEnterAsTheSubject(String subject) {
        contactUsFormPage.setSubjectContact(subject);
    }

    @And("they enter {string} as the message")
    public void theyEnterAsTheMessage(String message) {
        contactUsFormPage.setMessageContact(message);
    }

    @And("they attach the file {string}")
    public void theyAttachTheFile(String filePath) {
        contactUsFormPage.setFileContact(filePath);
    }

    @And("they submit the form")
    public void theySubmitTheForm() {
        contactUsFormPage.clickSubmitButton();
    }

    @Then("an alert should appear confirming submission")
    public void anAlertShouldAppearConfirmingSubmission() {
        contactUsFormPage.alertFun();
    }

    @And("the success message should be displayed")
    public void theSuccessMessageShouldBeDisplayed() {
        contactUsFormPage.verifySuccessMessage();
    }

    @When("they go back to the home page")
    public void theyGoBackToTheHomePage() {
        contactUsFormPage.goHomeButtonFun();
    }

    @Then("the homepage hero section should be visible again")
    public void theHomepageHeroSectionShouldBeVisibleAgain() {
        contactUsFormPage.HomeCheck();
    }
}
