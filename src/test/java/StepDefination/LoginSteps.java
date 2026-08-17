package StepDefination;

import Hooks.Hook;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage obj;

    @Given("User is on home page login")
    public void homecheck(){
        obj = new LoginPage(Hook.driver);
        obj.HomeCheck();
    }

    @When("user click signUpOrLogIn button login")
    public void signUpOrLogIn(){
        obj.SingInAndSignUpButton();
    }


    @And("enter incorrect email")
    public void enterEmail(){
        obj.setEmailAddressField(utils.TestConfig.invalidEmail());
    }

    @And("enter incorrect password")
    public void enterPassword(){
        obj.setPasswordField(utils.TestConfig.invalidPassword());
    }

    @And("click on login button")
    public void clickOnLogin(){
        obj.setSignUpButton();
    }

    @Then("check Invalid Messsage")
    public void checkMessage(){
        obj.checkInValidLoginMessageVisability();
    }

}
