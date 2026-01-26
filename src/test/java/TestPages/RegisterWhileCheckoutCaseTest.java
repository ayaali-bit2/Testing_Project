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
        obj.setUserName("JohnDoe");
        obj.setEmailAddress("john.doe@example.com");
        obj.setSignUpButton();

        obj.setMr();
        obj.setPassword("Password123!");
        obj.setDayDate("15");
        obj.setMonthDate("August");
        obj.setYearDate("1990");
        obj.setNewsLetter();
        obj.setSpecialOffers();
        obj.setFirstName("John");
        obj.setLastNmae("Doe");
        obj.setCompanyName("ExampleCorp");
        obj.setAddressField("123 Main Street");
        obj.setAddress2Field("Apt 4B");
        obj.setContoryField("United States");
        obj.setStateField("California");
        obj.setCityField("Los Angeles");
        obj.setZipCode("90001");
        obj.setMobileNumber("5551234567");

        obj.setCreateAccountButton();
        obj.verifyNewUserCreated();
        obj.clickOnCartButton();
        obj.ClickOnProcceedToCheckout();
        obj.verifyAddressDetails();
        obj.verifyReviewYourOrder();
        obj.writeCommentInTextArea("This is a test order comment.");
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
