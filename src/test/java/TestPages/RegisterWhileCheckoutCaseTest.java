package TestPages;

import Pages.RegisterWhileCheckoutCase;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RegisterWhileCheckoutCaseTest extends BaseTest {
    RegisterWhileCheckoutCase obj;

    @Test
    public void RegisterWhileCheckoutCaseTestFun(){
        obj = new RegisterWhileCheckoutCase(driver);

        obj.HomeCheck();
        obj.clickOnAddToCartFirstProduct();
        obj.goTocontinoueShopping();
        obj.clickOnAddToCartSeconedProduct();
        obj.goToCartPage();
        obj.verifyCartPageFun();
        obj.ClickOnProcceedToCheckout();
        obj.ClickOnRegisterORLogin();
        obj.setUserName("johndoe");
        obj.setEmailAddress("john.doe@example.com");
        obj.setSignUpButton();

        obj.setMr();
        obj.setPassword("P@ssw0rd123");
        obj.setDayDate("15");
        obj.setMonthDate("March");
        obj.setYearDate("1990");
        obj.setNewsLetter();
        obj.setSpecialOffers();
        obj.setFirstName("John");
        obj.setLastNmae("Doe");
        obj.setCompanyName("Doe Industries");
        obj.setAddressField("123 Main Street");
        obj.setAddress2Field("Apt 4B");
        obj.setContoryField("United States");
        obj.setStateField("New York");
        obj.setCityField("New York");
        obj.setZipCode("10001");
        obj.setMobileNumber("2125551234");

        obj.setCreateAccountButton();
        obj.verifyNewUserCreated();
        obj.clickOnCartButton();
        obj.ClickOnProcceedToCheckout();
        obj.verifyAddressDetails();
        obj.verifyReviewYourOrder();
        obj.writeCommentInTextArea("Please handle my order with care.");
        obj.clickOnPlaceOrder();

        obj.setNameOnCard("John Doe");
        obj.setCardNumber("4111111111111111");
        obj.setCvc("123");
        obj.setExpirationMonth("12");
        obj.setExpirationYear("2025");
        obj.clickOnPayAndConfirmOrder();
        obj.checkSuccessMessage();
        obj.clickOnDelete();
        obj.verifyCheckDeleted();

    }
}
