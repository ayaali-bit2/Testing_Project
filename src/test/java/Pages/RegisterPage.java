package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    private final By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private final By singInAndSignUpButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private final By newUserSignUpVisible = By.cssSelector("#form > div > div > div:nth-child(3) > div > h2");
    private final By userNameField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)");
    private final By emailAddressField = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)");
    private final By signupBtn = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By enterAccountInformation = By.cssSelector("#form > div > div > div > div.login-form > h2 > b");
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
    private final By alreadyExistedUser = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p");
    private final By verifyAccountCreated = By.cssSelector("#form > div > div > div > h2 > b");
    private final By continueButton = By.cssSelector("#form > div > div > div > div > a");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void SingInAndSignUpButton() {
        navigateToHref(singInAndSignUpButton, "navigate to Sign In and Sign Up page");
    }

    public void NewUserSignUpVisible() {
        findElement(newUserSignUpVisible);
        logger.info("New user sign-up section is visible");
    }

    public void setUserName(String userName) {
        type(userNameField, userName);
    }

    public void setEmailAddress(String emailAddress) {
        type(emailAddressField, emailAddress);
    }

    public void setSignUpButton() {
        click(signupBtn);
    }

    public void setEnterAccountInformation() {
        findElement(enterAccountInformation);
        logger.info("Enter account information section is visible");
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

    public void registerWithExistedUser() {
        findElement(alreadyExistedUser);
        logger.info("Existing user warning is visible");
    }

    public void verifyAccountCreatedFun() {
        findElement(verifyAccountCreated);
        logger.info("Account creation confirmation is visible");
    }

    public void clickOnContinueButton() {
        navigateToHref(continueButton, "continue to next step");
    }
}
