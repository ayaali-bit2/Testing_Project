package StepDefination;

import utils.BaseTest;
import Pages.LogoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps extends BaseTest {

    LogoutPage obj;

    @Given("User is on home page logout")
    public void checkHome(){
        obj = new LogoutPage(driver);
        obj.HomeCheck();
    }

    @When("user click signUpOrLogIn button logout")
    public void clickOnSignInOrLogInButton(){
        obj.SingInAndSignUpButton();
    }

    @And("enter correct email")
    public void setEmail(){
        obj.setEmailAddressField("ayaali@gmail.com");
    }

    @And("enter correct password")
    public void setPassword(){
        obj.setPasswordField("123456789");
    }

    @And("click on login button logout")
    public void logInButton(){
        obj.setSignUpButton();
    }

    @And("verify success login")
    public void successLoginMessage(){
        obj.checkUserNameBar();
    }

    @Then("click on logout button")
    public void clickOnLogOut(){
        obj.logoutButtonFun();
    }
}
