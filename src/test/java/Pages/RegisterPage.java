package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class RegisterPage {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    // =========================
    // Locators
    // =========================
    private final By homeCheck = By.cssSelector(".features_items .title.text-center");

    private final By signInAndSignUpButton = By.cssSelector("a[href='/login']");
    private final By newUserSignUpVisible = By.cssSelector(".signup-form h2");

    private final By userNameField = By.cssSelector("input[data-qa='signup-name']");
    private final By emailAddressField = By.cssSelector("input[data-qa='signup-email']");
    private final By signUpButton = By.cssSelector("button[data-qa='signup-button']");
    private final By enterAccountInformation = By.xpath("//b[text()='Enter Account Information']");

    private final By mrRadioButton = By.id("id_gender1");
    private final By mrsRadioButton = By.id("id_gender2");

    private final By passwordField = By.id("password");

    private final By dayDate = By.id("days");
    private final By monthDate = By.id("months");
    private final By yearDate = By.id("years");

    private final By newsletterCheckbox = By.id("newsletter");
    private final By specialOffersCheckbox = By.id("optin");

    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyNameField = By.id("company");
    private final By addressField = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryField = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipCodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");

    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    private final By alreadyExistedUserError = By.xpath("//p[text()='Email Address already exist!']");
    private final By accountCreatedMessage = By.cssSelector("b[data-qa='account-created']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    // =========================
    // Model + Enum
    // =========================
    public enum Gender {
        MR,
        MRS
    }

    public static class User {
        private final String userName;
        private final String firstName;
        private final String lastName;
        private final String email;
        private final String password;
        private final String company;
        private final String address1;
        private final String address2;
        private final String country;
        private final String state;
        private final String city;
        private final String zipCode;
        private final String mobileNumber;
        private final String day;
        private final String month;
        private final String year;
        private final Gender gender;
        private final boolean subscribeToNewsletter;
        private final boolean receiveSpecialOffers;

        public User(
                String userName,
                String firstName,
                String lastName,
                String email,
                String password,
                String company,
                String address1,
                String address2,
                String country,
                String state,
                String city,
                String zipCode,
                String mobileNumber,
                String day,
                String month,
                String year,
                Gender gender,
                boolean subscribeToNewsletter,
                boolean receiveSpecialOffers
        ) {
            this.userName = Objects.requireNonNull(userName, "userName is required");
            this.firstName = Objects.requireNonNull(firstName, "firstName is required");
            this.lastName = Objects.requireNonNull(lastName, "lastName is required");
            this.email = Objects.requireNonNull(email, "email is required");
            this.password = Objects.requireNonNull(password, "password is required");
            this.company = Objects.requireNonNull(company, "company is required");
            this.address1 = Objects.requireNonNull(address1, "address1 is required");
            this.address2 = Objects.requireNonNull(address2, "address2 is required");
            this.country = Objects.requireNonNull(country, "country is required");
            this.state = Objects.requireNonNull(state, "state is required");
            this.city = Objects.requireNonNull(city, "city is required");
            this.zipCode = Objects.requireNonNull(zipCode, "zipCode is required");
            this.mobileNumber = Objects.requireNonNull(mobileNumber, "mobileNumber is required");
            this.day = Objects.requireNonNull(day, "day is required");
            this.month = Objects.requireNonNull(month, "month is required");
            this.year = Objects.requireNonNull(year, "year is required");
            this.gender = Objects.requireNonNull(gender, "gender is required");
            this.subscribeToNewsletter = subscribeToNewsletter;
            this.receiveSpecialOffers = receiveSpecialOffers;
        }

        public String getUserName() {
            return userName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getCompany() {
            return company;
        }

        public String getAddress1() {
            return address1;
        }

        public String getAddress2() {
            return address2;
        }

        public String getCountry() {
            return country;
        }

        public String getState() {
            return state;
        }

        public String getCity() {
            return city;
        }

        public String getZipCode() {
            return zipCode;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public String getDay() {
            return day;
        }

        public String getMonth() {
            return month;
        }

        public String getYear() {
            return year;
        }

        public Gender getGender() {
            return gender;
        }

        public boolean isSubscribeToNewsletter() {
            return subscribeToNewsletter;
        }

        public boolean isReceiveSpecialOffers() {
            return receiveSpecialOffers;
        }
    }

    // =========================
    // Helpers
    // =========================
    private void log(String message) {
        System.out.println("[RegisterPage] " + message);
    }

    private WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private boolean isVisible(By locator) {
        try {
            waitForVisibility(locator);
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    private void click(By locator) {
        waitForClickability(locator).click();
    }

    private void type(By locator, String value) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }

    private void selectByContainsVisibleText(By locator, String value) {
        Select selector = new Select(waitForVisibility(locator));
        selector.selectByContainsVisibleText(value);
    }

    private void setCheckbox(By locator, boolean shouldBeSelected) {
        WebElement checkbox = waitForClickability(locator);
        if (checkbox.isSelected() != shouldBeSelected) {
            checkbox.click();
        }
    }

    // =========================
    // Validations
    // =========================
    public boolean HomeCheck() {
        boolean visible = isVisible(homeCheck);
        log("Home visible: " + visible);
        return visible;
    }

    public boolean NewUserSignUpVisible() {
        boolean visible = isVisible(newUserSignUpVisible);
        log("New User Sign Up visible: " + visible);
        return visible;
    }

    public boolean setEnterAccountInformation() {
        boolean visible = isVisible(enterAccountInformation);
        log("Enter Account Information visible: " + visible);
        return visible;
    }

    public boolean registerWithExistedUser() {
        boolean visible = isVisible(alreadyExistedUserError);
        log("Existing user error visible: " + visible);
        return visible;
    }

    public boolean verifyAccountCreatedFun() {
        boolean visible = isVisible(accountCreatedMessage);
        log("Account created message visible: " + visible);
        return visible;
    }

    public boolean isAccountCreationSuccess() {
        return verifyAccountCreatedFun();
    }

    public boolean isExistingUserErrorVisible() {
        return registerWithExistedUser();
    }

    public boolean isSignUpFormVisible() {
        return NewUserSignUpVisible();
    }

    public boolean isAccountInformationFormVisible() {
        return setEnterAccountInformation();
    }

    // =========================
    // Actions - Entry / Navigation
    // =========================
    public void SingInAndSignUpButton() {
        click(signInAndSignUpButton);
        log("Clicked Sign In / Sign Up.");
    }

    public void clickOnContinueButton() {
        click(continueButton);
        log("Clicked Continue.");
    }

    // =========================
    // Actions - Sign Up
    // =========================
    public void setUserName(String userName) {
        type(userNameField, userName);
    }

    public void setEmailAddress(String emailAddress) {
        type(emailAddressField, emailAddress);
    }

    public void setSignUpButton() {
        click(signUpButton);
        log("Clicked Sign Up.");
    }

    public void fillSignUpCredentials(String userName, String emailAddress) {
        setUserName(userName);
        setEmailAddress(emailAddress);
    }

    // =========================
    // Actions - Account Information
    // =========================
    public void setMr() {
        selectGender(Gender.MR);
    }

    public void setMrs() {
        selectGender(Gender.MRS);
    }

    public void selectGender(Gender gender) {
        if (gender == Gender.MR) {
            click(mrRadioButton);
        } else {
            click(mrsRadioButton);
        }
    }

    public void setPassword(String pass) {
        type(passwordField, pass);
    }

    public void setDayDate(String day) {
        selectByContainsVisibleText(dayDate, day);
    }

    public void setMonthDate(String month) {
        selectByContainsVisibleText(monthDate, month);
    }

    public void setYearDate(String year) {
        selectByContainsVisibleText(yearDate, year);
    }

    public void setNewsLetter() {
        setCheckbox(newsletterCheckbox, true);
    }

    public void setSpecialOffers() {
        setCheckbox(specialOffersCheckbox, true);
    }

    public void fillAccountInformation(User user) {
        selectGender(user.getGender());
        setPassword(user.getPassword());
        setDayDate(user.getDay());
        setMonthDate(user.getMonth());
        setYearDate(user.getYear());
        setCheckbox(newsletterCheckbox, user.isSubscribeToNewsletter());
        setCheckbox(specialOffersCheckbox, user.isReceiveSpecialOffers());
    }

    // =========================
    // Actions - Address Information
    // =========================
    public void setFirstName(String firstName) {
        type(firstNameField, firstName);
    }

    public void setLastName(String lastName) {
        type(lastNameField, lastName);
    }

    // Backward-compatible alias
    public void setLastNmae(String lastName) {
        setLastName(lastName);
    }

    public void setCompanyName(String companyName) {
        type(companyNameField, companyName);
    }

    public void setAddressField(String addressText) {
        type(addressField, addressText);
    }

    public void setAddress2Field(String address2Text) {
        type(address2Field, address2Text);
    }

    public void setCountryField(String country) {
        selectByContainsVisibleText(countryField, country);
    }

    // Backward-compatible alias
    public void setContoryField(String country) {
        setCountryField(country);
    }

    public void setStateField(String state) {
        type(stateField, state);
    }

    public void setCityField(String city) {
        type(cityField, city);
    }

    public void setZipCode(String zipCode) {
        type(zipCodeField, zipCode);
    }

    public void setMobileNumber(String mobileNumber) {
        type(mobileNumberField, mobileNumber);
    }

    public void fillAddressInformation(User user) {
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setCompanyName(user.getCompany());
        setAddressField(user.getAddress1());
        setAddress2Field(user.getAddress2());
        setCountryField(user.getCountry());
        setStateField(user.getState());
        setCityField(user.getCity());
        setZipCode(user.getZipCode());
        setMobileNumber(user.getMobileNumber());
    }

    // =========================
    // Actions - Finalize Registration
    // =========================
    public void setCreateAccountButton() {
        click(createAccountButton);
        log("Clicked Create Account.");
    }

    public void registerNewUser(User user) {
        SingInAndSignUpButton();
        fillSignUpCredentials(user.getUserName(), user.getEmail());
        setSignUpButton();
        fillAccountInformation(user);
        fillAddressInformation(user);
        setCreateAccountButton();
    }
}