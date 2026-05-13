package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");

    By singInAndSignUpButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    By newUserSignUpVisible = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2");

    By userNameField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)");
    By emailAddressField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)");

    By signupBtn = By.xpath("//button[@data-qa=\"signup-button\"]");
    By enterAccountInformation = By.cssSelector("#form > div > div > div > div.login-form > h2 > b");

    By Mr = By.cssSelector("#id_gender1");
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

    By alreadyExistedUser = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p");

    By verifyAccountCreated = By.cssSelector("#form > div > div > div > h2 > b");

    By continueButtin = By.cssSelector("#form > div > div > div > div > a");

    private WebDriverWait waitDriver() {
        return new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    private WebElement waitUntilVisible(By locator) {
        return waitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitUntilClickable(By locator) {
        return waitDriver().until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void type(By locator, String value) {
        WebElement element = waitUntilVisible(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void HomeCheck() {
        System.out.println(waitUntilVisible(homeCheck).isDisplayed());
    }

    public void SingInAndSignUpButton() {
        waitUntilClickable(singInAndSignUpButton).click();
    }

    public void NewUserSignUpVisible() {
        System.out.println(waitUntilVisible(newUserSignUpVisible).isDisplayed());
    }

    public void setUserName(String userName) {
        type(userNameField, userName);
    }

    public void setEmailAddress(String emailAddress) {
        type(emailAddressField, emailAddress);
    }

    public void setSignUpButton() {
        waitUntilClickable(signupBtn).click();
    }

    public void setEnterAccountInformation() {
        System.out.println(waitUntilVisible(enterAccountInformation).isDisplayed());
    }

    public void setMr() {
        waitUntilClickable(Mr).click();
    }

    public void setMrs() {
        waitUntilClickable(Mrs).click();
    }

    public void setPassword(String pass) {
        type(password, pass);
    }

    public void setDayDate(String day) {
        Select daySeletor = new Select(waitUntilVisible(dayDate));
        daySeletor.selectByContainsVisibleText(day);
    }

    public void setMonthDate(String month) {
        Select daySeletor = new Select(waitUntilVisible(monthDate));
        daySeletor.selectByContainsVisibleText(month);
    }

    public void setYearDate(String year) {
        Select daySeletor = new Select(waitUntilVisible(yearDate));
        daySeletor.selectByContainsVisibleText(year);
    }

    public void setNewsLetter() {
        waitUntilClickable(newsLetter).click();
    }

    public void setSpecialOffers() {
        waitUntilClickable(specialOffers).click();
    }

    public void setFirstName(String fName) {
        type(firstName, fName);
    }

    public void setLastNmae(String lName) {
        type(lastNmae, lName);
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
        Select selector = new Select(waitUntilVisible(contoryField));
        selector.selectByContainsVisibleText(contoryFi);
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
        waitUntilClickable(createAccountButton).click();
    }

    public void registerWithExistedUser() {
        waitUntilVisible(alreadyExistedUser).isDisplayed();
    }

    public void verifyAccountCreatedFun() {
        System.out.println(waitUntilVisible(verifyAccountCreated).isDisplayed());
    }

    public void clickOnContinueButton() {
        waitUntilClickable(continueButtin).click();
    }
}