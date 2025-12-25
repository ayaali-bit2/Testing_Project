package StepDefination;

import Hooks.Hook;
import Pages.RegisterPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;
import java.time.Duration;

public class RegisterSteps {

    private RegisterPage obj;

    @Given("User is on home page")
    public void beginTest() {
        obj = new RegisterPage(Hook.driver);
        obj.HomeCheck();
    }

    @When("user click signUpOrLogIn button")
    public void clickOnSignUpOrLogin() {
        obj.SingInAndSignUpButton();
    }

    @And("enter username {string}")
    public void setUserName(String userName) {
        obj.setUserName(userName);
    }

    @And("enter email {string}")
    public void setUserEmail(String email) {
        obj.setEmailAddress(email);
    }

    @And("click on signUp button")
    public void clickOnSignUp() {
        obj.setSignUpButton();
    }

    @And("check Accounte is Existed Message")
    public void checkMessage() {
        obj.registerWithExistedUser();
    }

    @And("enter title {string}")
    public void setTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            obj.setMr();
        } else if (title.equalsIgnoreCase("Mrs")) {
            obj.setMrs();
        }
    }

    @And("enter password {string}")
    public void setPassword(String password) {
        obj.setPassword(password);
    }

    @And("enter day birth {string}")
    public void setDay(String day) {
        obj.setDayDate(day);
    }

    @And("enter month birth {string}")
    public void setMonth(String month) {
        obj.setMonthDate(month);
    }

    @And("enter year birth {string}")
    public void setYear(String year) {
        obj.setYearDate(year);
    }

    @And("check newsletter {string}")
    public void checkLetter(String newsletter) {
        if (Boolean.parseBoolean(newsletter)) {
            obj.setNewsLetter();
        }
    }

    @And("check receive specials offers {string}")
    public void checkSpecialOffers(String offers) {
        if (Boolean.parseBoolean(offers)) {
            obj.setSpecialOffers();
        }
    }

    @And("set first name {string}")
    public void setFirstName(String firstName) {
        obj.setFirstName(firstName);
    }

    @And("set last name {string}")
    public void setLastName(String lastName) {
        obj.setLastNmae(lastName);
    }

    @And("set company name {string}")
    public void setCompany(String companyName) {
        obj.setCompanyName(companyName);
    }

    @And("set first address {string}")
    public void setFirstAddress(String address1) {
        obj.setAddressField(address1);
    }

    @And("set second address {string}")
    public void setSecondAddress(String address2) {
        obj.setAddress2Field(address2);
    }

    @And("set country name {string}")
    public void setCountryName(String country) {
        obj.setContoryField(country);
    }

    @And("set state name {string}")
    public void setState(String state) {
        obj.setStateField(state);
    }

    @And("set city name {string}")
    public void setCity(String city) {
        obj.setCityField(city);
    }

    @And("set zipcode {string}")
    public void setZipCode(String zip) {
        obj.setZipCode(zip);
    }

    @And("set mobile number {string}")
    public void setMobileNumber(String mobile) {
        obj.setMobileNumber(mobile);
    }

    @And("click on create account button")
    public void clickOnCreateButton() {
        obj.setCreateAccountButton();
    }

    @Then("verify account is created")
    public void verifyAccountCreated() {
        obj.verifyAccountCreatedFun();
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        obj.clickOnContinueButton();
    }
}