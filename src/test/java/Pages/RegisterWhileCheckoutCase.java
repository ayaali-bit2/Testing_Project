package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterWhileCheckoutCase extends BasePage {

    private final By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private final By selectFirstProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > img");
    private final By selectSecondProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.productinfo.text-center > img");
    private final By hoverOnFirstProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.product-overlay > div");
    private final By hoverOnSecondProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.product-overlay > div");
    private final By continoueShopping = By.cssSelector(".modal-footer .btn-success");
    private final By cartButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
    private final By verifyCartPage = By.cssSelector("#cart_items > div > div.breadcrumbs > ol > li.active");
    private final By procceedToCheckout = By.cssSelector("#do_action > div.container > div > div > a");
    private final By registerORLogin = By.cssSelector("#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a");
    private final By userNameField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)");
    private final By emailAddressField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)");
    private final By signUpButton = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button");
    private final By mr = By.cssSelector("#id_gender1");
    private final By mrs = By.cssSelector("#id_gender2");
    private final By password = By.cssSelector("#password");
    private final By dayDate = By.cssSelector("#days");
    private final By monthDate = By.cssSelector("#months");
    private final By yearDate = By.cssSelector("#years");
    private final By newsletter = By.cssSelector("#newsletter");
    private final By specialOffers = By.cssSelector("#optin");
    private final By firstName = By.cssSelector("#first_name");
    private final By lastName = By.cssSelector("#last_name");
    private final By companyName = By.cssSelector("#company");
    private final By addressField = By.cssSelector("#address1");
    private final By address2Field = By.cssSelector("#address2");
    private final By countryField = By.cssSelector("#country");
    private final By stateField = By.cssSelector("#state");
    private final By cityField = By.cssSelector("#city");
    private final By zipCode = By.cssSelector("#zipcode");
    private final By mobileNumber = By.cssSelector("#mobile_number");
    private final By createAccountButton = By.cssSelector("#form > div > div > div > div.login-form > form > button");
    private final By newUserSignUpVisible = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private final By cartButtonHome = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
    private final By addressDetails = By.cssSelector("#cart_items > div > div:nth-child(2) > h2");
    private final By reviewYourOrder = By.cssSelector("#cart_items > div > div:nth-child(4) > h2");
    private final By textArea = By.cssSelector("#ordermsg > textarea");
    private final By placeOrder = By.cssSelector("#cart_items > div > div:nth-child(7) > a");
    private final By nameOnCard = By.cssSelector("#payment-form > div:nth-child(2) > div > input");
    private final By cardNumber = By.cssSelector("#payment-form > div:nth-child(3) > div > input");
    private final By cvc = By.cssSelector("#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input");
    private final By expirationMonth = By.cssSelector("#payment-form > div:nth-child(4) > div:nth-child(2) > input");
    private final By expirationYear = By.cssSelector("#payment-form > div:nth-child(4) > div:nth-child(3) > input");
    private final By payAndConfirmOrder = By.cssSelector("#submit");
    private final By successMessage = By.cssSelector("#success_message > div");
    private final By delet = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    private final By checkDeleted = By.cssSelector("#form > div > div > div > h2 > b");

    public RegisterWhileCheckoutCase(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void clickOnAddToCartFirstProduct() {
        WebElement elementToHover = findElement(selectFirstProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        WebElement hoverTarget = wait.until(ExpectedConditions.elementToBeClickable(hoverOnFirstProduct));
        hoverTarget.click();
        logger.info("Hovered and interacted with first product overlay");
    }

    public void goToContinueShopping() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continoueShopping));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", continueButton);
        logger.info("Clicked continue shopping via JavaScript");
    }

    public void clickOnAddToCartSecondProduct() {
        WebElement elementToHover = findElement(selectSecondProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        WebElement hoverTarget = wait.until(ExpectedConditions.elementToBeClickable(hoverOnSecondProduct));
        hoverTarget.click();
        logger.info("Hovered and interacted with second product overlay");
    }

    public void goToCartPage() {
        navigateToHref(cartButton, "navigate to cart page");
    }

    public void verifyCartPageFun() {
        findElement(verifyCartPage);
        logger.info("Cart page breadcrumb is visible");
    }

    public void ClickOnProcceedToCheckout() {
        navigateToHref(procceedToCheckout, "proceed to checkout");
    }

    public void ClickOnRegisterORLogin() {
        navigateToHref(registerORLogin, "navigate to register or login");
    }

    public void setUserName(String userName) {
        type(userNameField, userName);
    }

    public void setEmailAddress(String emailAddress) {
        type(emailAddressField, emailAddress);
    }

    public void setSignUpButton() {
        click(signUpButton);
    }

    public void setMr() {
        click(mr);
    }

    public void setMrs() {
        click(mrs);
    }

    public void setPassword(String pass) {
        type(password, pass);
    }

    public void setDayDate(String day) {
        Select daySelector = new Select(findElement(dayDate));
        daySelector.selectByVisibleText(day);
        logger.info("Selected day {}", day);
    }

    public void setMonthDate(String month) {
        Select monthSelector = new Select(findElement(monthDate));
        monthSelector.selectByVisibleText(month);
        logger.info("Selected month {}", month);
    }

    public void setYearDate(String year) {
        Select yearSelector = new Select(findElement(yearDate));
        yearSelector.selectByVisibleText(year);
        logger.info("Selected year {}", year);
    }

    public void setNewsLetter() {
        click(newsletter);
    }

    public void setSpecialOffers() {
        click(specialOffers);
    }

    public void setFirstName(String fName) {
        type(firstName, fName);
    }

    public void setLastNmae(String lName) {
        type(lastName, lName);
    }

    public void setCompanyName(String comName) {
        type(companyName, comName);
    }

    public void setAddressField(String addressText) {
        type(addressField, addressText);
    }

    public void setAddress2Field(String address2Text) {
        type(address2Field, address2Text);
    }

    public void setContoryField(String contoryFi) {
        Select selector = new Select(findElement(countryField));
        selector.selectByVisibleText(contoryFi);
        logger.info("Selected country {}", contoryFi);
    }

    public void setStateField(String stateFi) {
        type(stateField, stateFi);
    }

    public void setCityField(String cityFi) {
        type(cityField, cityFi);
    }

    public void setZipCode(String zipCodefi) {
        type(zipCode, zipCodefi);
    }

    public void setMobileNumber(String mobileNumberText) {
        type(mobileNumber, mobileNumberText);
    }

    public void setCreateAccountButton() {
        click(createAccountButton);
    }

    public void verifyNewUserCreated() {
        findElement(newUserSignUpVisible);
        logger.info("New user registration success section is visible");
    }

    public void clickOnCartButton() {
        navigateToHref(cartButtonHome, "navigate to cart from home");
    }

    public void verifyAddressDetails() {
        findElement(addressDetails);
        logger.info("Address details section is visible");
    }

    public void verifyReviewYourOrder() {
        findElement(reviewYourOrder);
        logger.info("Review your order section is visible");
    }

    public void writeCommentInTextArea(String text) {
        type(textArea, text);
    }

    public void clickOnPlaceOrder() {
        click(placeOrder);
    }

    public void setNameOnCard(String name) {
        type(nameOnCard, name);
    }

    public void setCardNumber(String number) {
        type(cardNumber, number);
    }

    public void setCvc(String cvctext) {
        type(cvc, cvctext);
    }

    public void setExpirationMonth(String month) {
        type(expirationMonth, month);
    }

    public void setExpirationYear(String year) {
        type(expirationYear, year);
    }

    public void clickOnPayAndConfirmOrder() {
        click(payAndConfirmOrder);
    }

    public void checkSuccessMessage() {
        findElement(successMessage);
        logger.info("Payment success message is visible");
    }

    public void clickOnDelete() {
        click(delet);
    }

    public void verifyCheckDeleted() {
        findElement(checkDeleted);
        logger.info("Account deleted confirmation is visible");
    }
}
