package TestPages;

import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RegisterPageTest extends BaseTest {

    RegisterPage obj;

//    @Test
//    public void validRegister(){
//        obj = new RegisterPage(driver);
//
//        obj.HomeCheck();
//        obj.SingInAndSignUpButton();
//
//        obj.NewUserSignUpVisible();
//
//        obj.setUserName("Aya");
//        obj.setEmailAddress("ayaali@gmail.com");
//        obj.setSignUpButton();
//
//        obj.setEnterAccountInformation();
//
//        obj.setMrs();
//        obj.setPassword("123456789");
//        obj.setDayDate("7");
//        obj.setMonthDate("February");
//        obj.setYearDate("2002");
//
//        obj.setNewsLetter();
//        obj.setSpecialOffers();
//
//        obj.setFirstName("Aya");
//        obj.setLastNmae("Ali");
//        obj.setCompanyName("NTI");
//        obj.setAddressField("jkbgakjrbakjre");
//        obj.setAddress2Field("nkajgrjgbjkbjkfjkbvjkb");
//        obj.setContoryField("India");
//        obj.setStateField("single");
//        obj.setCityField("cairo");
//        obj.setZipCode("112233");
//        obj.setMobileNumber("012234555");
//
//        obj.setCreateAccountButton();
//    }


    @Test
    public void registerWithExistingUser(){
        obj = new RegisterPage(driver);

        obj.HomeCheck();
        obj.SingInAndSignUpButton();

        obj.NewUserSignUpVisible();

        obj.setUserName(utils.TestConfig.existingUsername());
        obj.setEmailAddress(utils.TestConfig.existingEmail());
        obj.setSignUpButton();

        obj.registerWithExistedUser();
    }

}
