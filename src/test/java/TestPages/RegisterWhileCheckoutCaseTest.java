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
        obj.setUserName("MODY");
        obj.setEmailAddress("mody2002@gmail.com");
        obj.setSignUpButton();

        obj.setMr();
        obj.setPassword("123456789");
        obj.setDayDate("7");
        obj.setMonthDate("May");
        obj.setYearDate("2002");
        obj.setNewsLetter();
        obj.setSpecialOffers();
        obj.setFirstName("Mody");
        obj.setLastNmae("Ali");
        obj.setCompanyName("Egypt");
        obj.setAddressField("frehigknaagkn");
        obj.setAddress2Field("jkejkebjkbk");
        obj.setContoryField("bafjkvfjkab");
        obj.setStateField("cairo");
        obj.setCityField("gesr el suaz");
        obj.setZipCode("223344");
        obj.setMobileNumber("012334455");

        obj.setCreateAccountButton();
        obj.verifyNewUserCreated();
        obj.clickOnCartButton();
        obj.ClickOnProcceedToCheckout();
        obj.verifyAddressDetails();
        obj.verifyReviewYourOrder();
        obj.writeCommentInTextArea(utils.TestConfig.checkoutValue("comment"));
        obj.clickOnPlaceOrder();

        obj.setNameOnCard("mody");
        obj.setCardNumber("wekjerjkb");
        obj.setCvc("222");
        obj.setExpirationMonth("02");
        obj.setExpirationYear("2024");
        obj.clickOnPayAndConfirmOrder();
        obj.checkSuccessMessage();
        obj.clickOnDelete();
        obj.verifyCheckDeleted();

    }
}
