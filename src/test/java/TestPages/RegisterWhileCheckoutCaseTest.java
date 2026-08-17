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
        obj.setUserName(utils.TestConfig.checkoutUsername());
        obj.setEmailAddress(utils.TestConfig.checkoutEmail());
        obj.setSignUpButton();

        obj.setMr();
        obj.setPassword(utils.TestConfig.checkoutPassword());
        obj.setDayDate(utils.TestConfig.checkoutValue("birth.day"));
        obj.setMonthDate(utils.TestConfig.checkoutValue("birth.month"));
        obj.setYearDate(utils.TestConfig.checkoutValue("birth.year"));
        obj.setNewsLetter();
        obj.setSpecialOffers();
        obj.setFirstName(utils.TestConfig.checkoutValue("first.name"));
        obj.setLastNmae(utils.TestConfig.checkoutValue("last.name"));
        obj.setCompanyName(utils.TestConfig.checkoutValue("company"));
        obj.setAddressField(utils.TestConfig.checkoutValue("address"));
        obj.setAddress2Field(utils.TestConfig.checkoutValue("address2"));
        obj.setContoryField(utils.TestConfig.checkoutValue("country"));
        obj.setStateField(utils.TestConfig.checkoutValue("state"));
        obj.setCityField(utils.TestConfig.checkoutValue("city"));
        obj.setZipCode(utils.TestConfig.checkoutValue("zipcode"));
        obj.setMobileNumber(utils.TestConfig.checkoutValue("mobile"));

        obj.setCreateAccountButton();
        obj.verifyNewUserCreated();
        obj.clickOnCartButton();
        obj.ClickOnProcceedToCheckout();
        obj.verifyAddressDetails();
        obj.verifyReviewYourOrder();
        obj.writeCommentInTextArea(utils.TestConfig.checkoutValue("comment"));
        obj.clickOnPlaceOrder();

        obj.setNameOnCard(utils.TestConfig.checkoutValue("card.name"));
        obj.setCardNumber(utils.TestConfig.checkoutValue("card.number"));
        obj.setCvc(utils.TestConfig.checkoutValue("card.cvc"));
        obj.setExpirationMonth(utils.TestConfig.checkoutValue("card.expiration.month"));
        obj.setExpirationYear(utils.TestConfig.checkoutValue("card.expiration.year"));
        obj.clickOnPayAndConfirmOrder();
        obj.checkSuccessMessage();
        obj.clickOnDelete();
        obj.verifyCheckDeleted();

    }
}
