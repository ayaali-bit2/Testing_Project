package TestPages;

import Pages.RegisterWhileCheckoutCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RegisterWhileCheckoutCaseTest extends BaseTest {
    RegisterWhileCheckoutCase obj;

    @Test(groups = {"smoke", "regression"})
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
        obj.writeCommentInTextArea("jrkgnerjknrjk");
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

    @Test(groups = {"regression"})
    public void invalidCardNumberBlocksPayment() {
        openPaymentPage();

        obj.setNameOnCard("Test User");
        obj.setCardNumber("not-a-card-number");
        obj.setCvc("123");
        obj.setExpirationMonth("12");
        obj.setExpirationYear("2035");

        Assert.assertFalse(
                obj.isPaymentFormValid(),
                "An invalid card number must fail payment validation");
        Assert.assertTrue(
                obj.isPaymentFormDisplayed(),
                "The payment form must remain visible after invalid card input");
    }

    @Test(groups = {"regression"})
    public void expiredCardDetailsBlockPayment() {
        openPaymentPage();

        obj.setNameOnCard("Test User");
        obj.setCardNumber("4111111111111111");
        obj.setCvc("123");
        obj.setExpirationMonth("01");
        obj.setExpirationYear("2020");

        Assert.assertFalse(
                obj.isPaymentFormValid(),
                "Expired card details must fail payment validation");
        Assert.assertTrue(
                obj.isPaymentFormDisplayed(),
                "The payment form must remain visible for expired card details");
    }

    @Test(groups = {"smoke", "regression"})
    public void requiredPaymentFieldsCannotBeSubmittedEmpty() {
        openPaymentPage();

        obj.clickOnPayAndConfirmOrder();

        Assert.assertFalse(
                obj.isPaymentFormValid(),
                "The payment form must be invalid when required fields are empty");
        Assert.assertTrue(
                obj.isPaymentFormDisplayed(),
                "The payment form must remain visible when required fields are empty");
        Assert.assertTrue(
                obj.isFieldInvalid("#payment-form input[name='name_on_card']"),
                "Cardholder name must be required");
        Assert.assertTrue(
                obj.isFieldInvalid("#payment-form input[name='card_number']"),
                "Card number must be required");
    }

    @Test(groups = {"regression"})
    public void requiredAddressFieldsCannotBeSubmittedEmpty() {
        obj = new RegisterWhileCheckoutCase(driver);
        openCheckoutRegistrationPage();

        obj.setUserName("checkoutuser" + System.currentTimeMillis());
        obj.setEmailAddress("checkout" + System.currentTimeMillis() + "@example.com");
        obj.setSignUpButton();

        obj.setMrs();
        obj.setPassword("Password123!");
        obj.setDayDate("7");
        obj.setMonthDate("May");
        obj.setYearDate("2002");
        obj.setFirstName("Checkout");
        obj.setLastNmae("User");
        obj.setContoryField("India");
        obj.setStateField("Cairo");
        obj.setCityField("Cairo");
        obj.setZipCode("112233");
        obj.setMobileNumber("01000000000");
        obj.setCreateAccountButton();

        Assert.assertTrue(
                obj.isFieldInvalid("#address1"),
                "Address line 1 must be required");
    }

    private void openPaymentPage() {
        openCheckoutRegistrationPage();

        obj.setUserName("paymentuser" + System.currentTimeMillis());
        obj.setEmailAddress("payment" + System.currentTimeMillis() + "@example.com");
        obj.setSignUpButton();

        obj.setMrs();
        obj.setPassword("Password123!");
        obj.setDayDate("7");
        obj.setMonthDate("May");
        obj.setYearDate("2002");
        obj.setFirstName("Payment");
        obj.setLastNmae("User");
        obj.setContoryField("India");
        obj.setStateField("Cairo");
        obj.setCityField("Cairo");
        obj.setZipCode("112233");
        obj.setMobileNumber("01000000000");
        obj.setAddressField("1 Test Street");
        obj.setCreateAccountButton();

        obj.clickOnCartButton();
        obj.ClickOnProcceedToCheckout();
        obj.verifyAddressDetails();
        obj.verifyReviewYourOrder();
        obj.clickOnPlaceOrder();
    }

    private void openCheckoutRegistrationPage() {
        obj.HomeCheck();
        obj.clickOnAddToCartFirstProduct();
        obj.goTocontinoueShopping();
        obj.goToCartPage();
        obj.verifyCartPageFun();
        obj.ClickOnProcceedToCheckout();
        obj.ClickOnRegisterORLogin();
    }
}
