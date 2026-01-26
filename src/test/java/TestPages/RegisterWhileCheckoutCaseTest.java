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
        obj.setUserName("testuser_automation");
        obj.setEmailAddress("testuser_automation@example.com");
        obj.setSignUpButton();

        obj.setMr();
        obj.setPassword("SecurePass!2026");
        obj.setDayDate("10");
        obj.setMonthDate("January");
        obj.setYearDate("1985");
        obj.setNewsLetter();
        obj.setSpecialOffers();
        obj.setFirstName("Test");
        obj.setLastNmae("Automation");
        obj.setCompanyName("AutomationCorp");
        obj.setAddressField("500 Automation Avenue");
        obj.setAddress2Field("Suite 100");
        obj.setContoryField("United States");
        obj.setStateField("California");
        obj.setCityField("San Francisco");
        obj.setZipCode("94107");
        obj.setMobileNumber("4151234567");

        obj.setCreateAccountButton();
        obj.verifyNewUserCreated();
        obj.clickOnCartButton();
        obj.ClickOnProcceedToCheckout();
        obj.verifyAddressDetails();
        obj.verifyReviewYourOrder();
        obj.writeCommentInTextArea("Please handle test order with care.");
        obj.clickOnPlaceOrder();

        obj.setNameOnCard("Test Automation");
        obj.setCardNumber("4242424242424242");
        obj.setCvc("456");
        obj.setExpirationMonth("01");
        obj.setExpirationYear("2030");
        obj.clickOnPayAndConfirmOrder();
        obj.checkSuccessMessage();
        obj.clickOnDelete();
        obj.verifyCheckDeleted();

    }
}
