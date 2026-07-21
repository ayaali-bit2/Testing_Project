package StepDefination;

import Hooks.Hook;
import Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterExistingUserSteps {

    private RegisterPage registerPage;

    @When("they click Sign Up / Login")
    public void theyClickSignUpLogin() {
        registerPage = new RegisterPage(Hook.driver);
        registerPage.SingInAndSignUpButton();
    }

    @And("the New User Signup form is visible")
    public void theNewUserSignupFormIsVisible() {
        registerPage.NewUserSignUpVisible();
    }

    @And("they type {string} into the name field")
    public void theyTypeIntoTheNameField(String name) {
        registerPage.setUserName(name);
    }

    @And("they type {string} into the email field")
    public void theyTypeIntoTheEmailField(String email) {
        registerPage.setEmailAddress(email);
    }

    @And("they click the Sign Up button")
    public void theyClickTheSignUpButton() {
        registerPage.setSignUpButton();
    }

    @Then("the page should show that the account already exists")
    public void thePageShouldShowThatTheAccountAlreadyExists() {
        registerPage.registerWithExistedUser();
    }
}
