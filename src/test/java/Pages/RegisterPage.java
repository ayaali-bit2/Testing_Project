package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class RegisterPage  {

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

    public void HomeCheck() {
        org.testng.Assert.assertTrue(driver.findElement(homeCheck).isDisplayed(), "Home page is not displayed");
    }

    public void SingInAndSignUpButton() {
        WebElement textField = driver.findElement(singInAndSignUpButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void NewUserSignUpVisible() {
        org.testng.Assert.assertTrue(driver.findElement(newUserSignUpVisible).isDisplayed(), "Sign-up form is not displayed");
    }

    public void setUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void setEmailAddress(String emailAddress) {
        driver.findElement(emailAddressField).sendKeys(emailAddress);
    }

    public void setSignUpButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(signupBtn));
        element.click();
    }

    public void setEnterAccountInformation() {
        org.testng.Assert.assertTrue(driver.findElement(enterAccountInformation).isDisplayed(), "Account information form is not displayed");
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

    public void registerWithExistedUser(){
        org.testng.Assert.assertTrue(driver.findElement(alreadyExistedUser).isDisplayed(), "Existing-account message is not displayed");
    }

    public void verifyAccountCreatedFun(){
        org.testng.Assert.assertTrue(driver.findElement(verifyAccountCreated).isDisplayed(), "Account-created message is not displayed");
    }

    public void clickOnContinueButton(){
        WebElement textField = driver.findElement(continueButtin);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }
}
