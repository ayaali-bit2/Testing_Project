package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterWhileCheckoutCase {

    private static final Logger logger = LogManager.getLogger(RegisterWhileCheckoutCase.class);
    WebDriver driver;

    public RegisterWhileCheckoutCase(WebDriver driver) {
        this.driver = driver;
    }

    By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");

    By selectFirstProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.productinfo.text-center > img");
    By selectSecondProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.productinfo.text-center > img");

    By hoverOnFirstProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.product-overlay > div");
    By hoverOnSecondProduct = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(4) > div > div.single-products > div.product-overlay > div");

    By continoueShopping = By.cssSelector(".modal-footer .btn-success");

    By cartButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");

    By verifyCartPage = By.cssSelector("#cart_items > div > div.breadcrumbs > ol > li.active");

    By procceedToCheckout = By.cssSelector("#do_action > div.container > div > div > a");

    By registerORLogin = By.cssSelector("#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a");

    By userNameField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)");
    By emailAddressField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)");

    By signUpButton = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button");


    By Mr = By.cssSelector("##id_gender1");
    By Mrs = By.cssSelector("#id_gender2");

    By password = By.cssSelector("#password");

    By dayDate = By.cssSelector("#days");
    By monthDate = By.cssSelector("#months");
    By yearDate = By.cssSelector("#years");

    By newsLetter = By.cssSelector("#newsletter");
    By specialOffers = By.cssSelector("#optin");

    By firstName = By.cssSelector("#first_name");
    By lastNmae = By.cssSelector("#last_name");

    By companyName = By.cssSelector("#company");

    By addressField = By.cssSelector("#address1");
    By address2Field = By.cssSelector("#address2");

    By contoryField = By.cssSelector("#country");

    By stateField = By.cssSelector("#state");
    By cityField = By.cssSelector("#city");
    By zipCode = By.cssSelector("#zipcode");
    By mobileNumber = By.cssSelector("#mobile_number");

    By createAccountButton = By.cssSelector("#form > div > div > div > div.login-form > form > button");

    By newUserSignUpVisible = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");

    By cartButtonHome = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");

    By addressDetails = By.cssSelector("#cart_items > div > div:nth-child(2) > h2");
    By reviewYourOrder = By.cssSelector("#cart_items > div > div:nth-child(4) > h2");

    By textArea = By.cssSelector("#ordermsg > textarea");
    By placeOrder = By.cssSelector("#cart_items > div > div:nth-child(7) > a");

    By nameOnCard = By.cssSelector("#payment-form > div:nth-child(2) > div > input");
    By cardNumber = By.cssSelector("#payment-form > div:nth-child(3) > div > input");
    By cvc = By.cssSelector("#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input");
    By expirationMonth = By.cssSelector("#payment-form > div:nth-child(4) > div:nth-child(2) > input");
    By expirationYear = By.cssSelector("#payment-form > div:nth-child(4) > div:nth-child(3) > input");

    By payAndConfirmOrder = By.cssSelector("#submit");

    By successMessage = By.cssSelector("#success_message > div");

    By delet = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a");

    By checkDeleted = By.cssSelector("#form > div > div > div > h2 > b");

    public void HomeCheck() {
        boolean isDisplayed = driver.findElement(homeCheck).isDisplayed();
        logger.info("Home section is displayed: {}", isDisplayed);
    }

    public void clickOnAddToCartFirstProduct(){
        WebElement elementToHover = driver.findElement(selectFirstProduct);

        // Find the element to click (can be the same or revealed after hover)
        WebElement elementToClick = driver.findElement(hoverOnFirstProduct);

        // Create Actions instance
        Actions actions = new Actions(driver);

        // Perform hover and click
        actions.moveToElement(elementToHover).perform();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(hoverOnFirstProduct));
//        elementToClick.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void goTocontinoueShopping(){
//        WebElement textField = driver.findElement(continoueShopping);
//        textField.click();
        //driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait until the modal is visible and the button is clickable
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continoueShopping));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", continueButton);
    }

    public void clickOnAddToCartSeconedProduct(){
        WebElement elementToHover = driver.findElement(selectSecondProduct);

        // Find the element to click (can be the same or revealed after hover)
        WebElement elementToClick = driver.findElement(hoverOnSecondProduct);

        // Create Actions instance
        Actions actions = new Actions(driver);

        // Perform hover and click
        actions.moveToElement(elementToHover).perform();
        elementToClick.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void goToCartPage(){
        WebElement element = driver.findElement(cartButton);
        String value = element.getAttribute("href");
        driver.navigate().to(value);
    }

    public void verifyCartPageFun(){
        boolean isDisplayed = driver.findElement(verifyCartPage).isDisplayed();
        logger.info("Cart page is displayed: {}", isDisplayed);
    }

    public void ClickOnProcceedToCheckout(){
        WebElement element = driver.findElement(procceedToCheckout);
        String value = element.getAttribute("href");
        driver.navigate().to(value);
    }

    public void ClickOnRegisterORLogin(){
        WebElement element = driver.findElement(registerORLogin);
        String value = element.getAttribute("href");
        driver.navigate().to(value);
    }

    public void setUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void setEmailAddress(String emailAddress) {
        driver.findElement(emailAddressField).sendKeys(emailAddress);
    }

    public void setSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void setMr() {
        driver.findElement(Mr).click();
    }

    public void setMrs() {
        driver.findElement(Mrs).click();
    }

    public void setPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void setDayDate(String day) {
        Select daySeletor = new Select(driver.findElement(dayDate));
        daySeletor.selectByContainsVisibleText(day);
    }

    public void setMonthDate(String month) {
        Select daySeletor = new Select(driver.findElement(monthDate));
        daySeletor.selectByContainsVisibleText(month);
    }

    public void setYearDate(String year) {
        Select daySeletor = new Select(driver.findElement(yearDate));
        daySeletor.selectByContainsVisibleText(year);
    }

    public void setNewsLetter() {
        driver.findElement(newsLetter).click();
    }

    public void setSpecialOffers() {
        driver.findElement(specialOffers).click();
    }

    public void setFirstName(String fName) {
        driver.findElement(firstName).sendKeys(fName);
    }

    public void setLastNmae(String lName) {
        driver.findElement(lastNmae).sendKeys(lName);
    }

    public void setCompanyName(String comName) {
        driver.findElement(companyName).sendKeys(comName);
    }

    public void setAddressField(String addressText) {
        driver.findElement(addressField).sendKeys(addressText);
    }

    public void setAddress2Field(String address2Text) {
        driver.findElement(address2Field).sendKeys(address2Text);
    }

    public void setContoryField(String contoryFi) {
        Select selector = new Select(driver.findElement(contoryField));
        selector.selectByContainsVisibleText(contoryFi);
    }

    public void setStateField(String stateFi) {
        driver.findElement(stateField).sendKeys(stateFi);
    }

    public void setCityField(String cityFi) {
        driver.findElement(cityField).sendKeys(cityFi);
    }

    public void setZipCode(String zipCodefi) {
        driver.findElement(zipCode).sendKeys(zipCodefi);
    }

    public void setMobileNumber(String mobileNumberText) {
        driver.findElement(mobileNumber).sendKeys(mobileNumberText);
    }

    public void setCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }

    public void verifyNewUserCreated(){
        boolean isDisplayed = driver.findElement(newUserSignUpVisible).isDisplayed();
        logger.info("New user sign-up indicator is displayed: {}", isDisplayed);
    }

    public void clickOnCartButton(){
        WebElement element = driver.findElement(cartButtonHome);
        String value = element.getAttribute("href");
        driver.navigate().to(value);
    }

    public void verifyAddressDetails(){
        boolean isDisplayed = driver.findElement(addressDetails).isDisplayed();
        logger.info("Address details section is displayed: {}", isDisplayed);
    }

    public void verifyReviewYourOrder(){
        boolean isDisplayed = driver.findElement(reviewYourOrder).isDisplayed();
        logger.info("Review your order section is displayed: {}", isDisplayed);
    }

    public void writeCommentInTextArea(String text){
        driver.findElement(textArea).sendKeys(text);
    }

    public void clickOnPlaceOrder(){
        driver.findElement(placeOrder).click();
    }

    public void setNameOnCard(String name) {
        driver.findElement(nameOnCard).sendKeys(name);
    }

    public void setCardNumber(String number) {
        driver.findElement(cardNumber).sendKeys(number);
    }

    public void setCvc(String cvctext) {
        driver.findElement(cvc).sendKeys(cvctext);
    }

    public void setExpirationMonth(String month) {
        driver.findElement(expirationMonth).sendKeys(month);
    }

    public void setExpirationYear(String year) {
        driver.findElement(expirationYear).sendKeys(year);
    }

    public void clickOnPayAndConfirmOrder(){
        driver.findElement(payAndConfirmOrder).click();
    }

    public void checkSuccessMessage(){
        boolean isDisplayed = driver.findElement(successMessage).isDisplayed();
        logger.info("Order success message is displayed: {}", isDisplayed);
    }

    public void clickOnDelete(){
        driver.findElement(delet).click();
    }

    public void verifyCheckDeleted(){
        boolean isDisplayed = driver.findElement(checkDeleted).isDisplayed();
        logger.info("Account deleted confirmation is displayed: {}", isDisplayed);
    }

}