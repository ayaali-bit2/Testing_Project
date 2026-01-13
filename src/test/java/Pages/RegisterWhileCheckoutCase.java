package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class RegisterWhileCheckoutCase {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public RegisterWhileCheckoutCase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    // Page locators
    private By homeHeader = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private By firstProductImage = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > img");
    private By firstProductOverlay = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.product-overlay > div");
    private By secondProductImage = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.productinfo.text-center > img");
    private By secondProductOverlay = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.product-overlay > div");
    private By continueShoppingButton = By.cssSelector(".modal-footer .btn-success");
    private By cartHeaderButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
    private By cartPageHeader = By.cssSelector("#cart_items > div > div.breadcrumbs > ol > li.active");
    private By proceedToCheckoutButton = By.cssSelector("#do_action > div.container > div > div > a");
    private By registerOrLoginLink = By.cssSelector("#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a");
    private By userNameField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)");
    private By emailAddressField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)");
    private By signUpButton = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button");
    private By genderMaleRadio = By.cssSelector("#id_gender1");
    private By genderFemaleRadio = By.cssSelector("#id_gender2");
    private By passwordField = By.cssSelector("#password");
    private By dayDropdown = By.cssSelector("#days");
    private By monthDropdown = By.cssSelector("#months");
    private By yearDropdown = By.cssSelector("#years");
    private By newsletterCheckbox = By.cssSelector("#newsletter");
    private By specialOffersCheckbox = By.cssSelector("#optin");
    private By firstNameField = By.cssSelector("#first_name");
    private By lastNameField = By.cssSelector("#last_name");
    private By companyField = By.cssSelector("#company");
    private By addressLine1Field = By.cssSelector("#address1");
    private By addressLine2Field = By.cssSelector("#address2");
    private By countryDropdown = By.cssSelector("#country");
    private By stateField = By.cssSelector("#state");
    private By cityField = By.cssSelector("#city");
    private By zipCodeField = By.cssSelector("#zipcode");
    private By mobileNumberField = By.cssSelector("#mobile_number");
    private By createAccountButton = By.cssSelector("#form > div > div > div > div.login-form > form > button");
    private By newUserLabel = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private By cartButtonAfterLogin = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
    private By addressDetailsHeader = By.cssSelector("#cart_items > div > div:nth-child(2) > h2");
    private By reviewOrderHeader = By.cssSelector("#cart_items > div > div:nth-child(4) > h2");
    private By orderCommentsTextArea = By.cssSelector("#ordermsg > textarea");
    private By placeOrderButton = By.cssSelector("#cart_items > div > div:nth-child(7) > a");
    private By nameOnCardField = By.cssSelector("#payment-form > div:nth-child(2) > div > input");
    private By cardNumberField = By.cssSelector("#payment-form > div:nth-child(3) > div > input");
    private By cvcField = By.cssSelector("#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input");
    private By expirationMonthField = By.cssSelector("#payment-form > div:nth-child(4) > div:nth-child(2) > input");
    private By expirationYearField = By.cssSelector("#payment-form > div:nth-child(4) > div:nth-child(3) > input");
    private By payAndConfirmOrderButton = By.cssSelector("#submit");
    private By successMessageLabel = By.cssSelector("#success_message > div");
    private By deleteAccountLink = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");
    private By accountDeletedMessage = By.cssSelector("#form > div > div > div > h2 > b");

    // Actions with explicit waits and assertions

    public void verifyHomePageHeaderIsVisible() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(homeHeader)).isDisplayed(), "Home page header is not visible");
    }

    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductImage));
        actions.moveToElement(driver.findElement(firstProductImage)).perform();
        WebElement overlay = wait.until(ExpectedConditions.elementToBeClickable(firstProductOverlay));
        overlay.click();
    }

    public void clickContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }

    public void addSecondProductToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductImage));
        actions.moveToElement(driver.findElement(secondProductImage)).perform();
        WebElement overlay = wait.until(ExpectedConditions.elementToBeClickable(secondProductOverlay));
        overlay.click();
    }

    public void navigateToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartHeaderButton)).click();
    }

    public void verifyCartPageIsVisible() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageHeader)).isDisplayed(), "Cart page is not visible");
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
    }

    public void clickRegisterOrLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(registerOrLoginLink)).click();
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField)).sendKeys(name);
    }

    public void enterEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressField)).sendKeys(email);
    }

    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public void selectGenderMale() {
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadio)).click();
    }

    public void selectGenderFemale() {
        wait.until(ExpectedConditions.elementToBeClickable(genderFemaleRadio)).click();
    }

    public void enterPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(pwd);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(wait.until(ExpectedConditions.elementToBeClickable(dayDropdown))).selectByVisibleText(day);
        new Select(wait.until(ExpectedConditions.elementToBeClickable(monthDropdown))).selectByVisibleText(month);
        new Select(wait.until(ExpectedConditions.elementToBeClickable(yearDropdown))).selectByVisibleText(year);
    }

    public void optInForNewsletter() {
        wait.until(ExpectedConditions.elementToBeClickable(newsletterCheckbox)).click();
    }

    public void optInForSpecialOffers() {
        wait.until(ExpectedConditions.elementToBeClickable(specialOffersCheckbox)).click();
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyField)).sendKeys(company);
    }

    public void enterAddressLine1(String address1) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLine1Field)).sendKeys(address1);
    }

    public void enterAddressLine2(String address2) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLine2Field)).sendKeys(address2);
    }

    public void selectCountry(String country) {
        new Select(wait.until(ExpectedConditions.elementToBeClickable(countryDropdown))).selectByVisibleText(country);
    }

    public void enterState(String state) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateField)).sendKeys(state);
    }

    public void enterCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
    }

    public void enterZipCode(String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField)).sendKeys(zip);
    }

    public void enterMobileNumber(String mobile) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberField)).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }

    public void verifyNewUserAccountCreated() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(newUserLabel)).isDisplayed(), "New user account creation label is not visible");
    }

    public void navigateToCartAfterLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButtonAfterLogin)).click();
    }

    public void verifyAddressDetailsSection() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(addressDetailsHeader)).isDisplayed(), "Address details section is not visible");
    }

    public void verifyReviewYourOrderSection() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(reviewOrderHeader)).isDisplayed(), "Review your order section is not visible");
    }

    public void enterOrderComments(String comments) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderCommentsTextArea)).sendKeys(comments);
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public void enterCardName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCardField)).sendKeys(name);
    }

    public void enterCardNumber(String cardNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField)).sendKeys(cardNumber);
    }

    public void enterCvc(String cvc) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvcField)).sendKeys(cvc);
    }

    public void enterExpirationMonth(String month) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirationMonthField)).sendKeys(month);
    }

    public void enterExpirationYear(String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirationYearField)).sendKeys(year);
    }

    public void clickPayAndConfirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(payAndConfirmOrderButton)).click();
    }

    public void verifyOrderSuccessMessage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLabel)).isDisplayed(), "Order success message is not visible");
    }

    public void clickDeleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountLink)).click();
    }

    public void verifyAccountDeletedMessage() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedMessage)).isDisplayed(), "Account deleted message is not visible");
    }
}