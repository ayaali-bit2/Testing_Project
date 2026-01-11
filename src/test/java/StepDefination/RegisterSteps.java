package StepDefination;

import Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseTest;

public class RegisterSteps extends BaseTest {

    private RegisterPage obj;

    @Given("User is on home page")
    public void beginTest(){
        obj = new RegisterPage(driver);
        obj.HomeCheck();
    }

    @When("user click signUpOrLogIn button")
    public void clickOnSignUpOrLogin(){
        obj.SingInAndSignUpButton();
    }

    @And("enter username")
    public void setUserName(){
        obj.setUserName("batta");
    }

    @And("enter email")
    public void setUserEmail(){
        obj.setEmailAddress("batta2002@gmail.com");
    }

    @And("click on signUp button")
    public void clickOnSignUp(){
        obj.setSignUpButton();
    }

    @Then("check Accounte is Existed Message")
    public void checkMessage(){
        obj.registerWithExistedUser();
    }
//    @And("enter title")
//    public void setTitle(){
//        obj.setMrs();
//    }
//
//    @And("enter password")
//    public void setPassword(){
//        obj.setPassword("asdfg");
//    }
//
//    @And("enter day birth")
//    public void setDay(){
//        obj.setDayDate("2");
//    }
//
//    @And("enter month birth")
//    public void setMonth(){
//        obj.setMonthDate("May");
//    }
//
//    @And("enter year birth")
//    public void setYear(){
//        obj.setYearDate("2002");
//    }
//
//    @And("check newsletter")
//    public void checkLetter(){
//        obj.setNewsLetter();
//    }
//
//    @And("check recieve specials offers")
//    public void checkSpecialOffers(){
//        obj.setSpecialOffers();
//    }
//
//    @And("set first name")
//    public void setFisrtName(){
//        obj.setFirstName("batta");
//    }
//
//    @And("set last name")
//    public void setLastName(){
//        obj.setLastNmae("naser");
//    }
//
//    @And("set company name")
//    public void setCompany(){
//        obj.setCompanyName("NTI");
//    }
//
//    @And("set first address")
//    public void setFirstAddress(){
//        obj.setAddressField("fhvkkjbk");
//    }
//
//    @And("set seconed address")
//    public void setSecondAddress(){
//        obj.setAddress2Field("hvkvnekjb");
//    }
//
//    @And("set country name")
//    public void setCountryName(){
//        obj.setContoryField("India");
//    }
//
//    @And("set state name")
//    public void setState(){
//        obj.setStateField("Cairo");
//    }
//
//    @And("set city name")
//    public void setCity(){
//        obj.setCityField("gesr el sauz");
//    }
//
//    @And("set zipcode")
//    public void setZipCode(){
//        obj.setZipCode("112233");
//    }
//
//    @And("set mobile number")
//    public void setMobileNumber(){
//        obj.setMobileNumber("123446768");
//    }
//
//    @And("click on create on create button")
//    public void clickOnCreateButton(){
//        obj.setCreateAccountButton();
//    }
//
//    @Then("verify account is created")
//    public void verifyAccountCreated(){
//        obj.verifyAccountCreatedFun();
//    }



}
