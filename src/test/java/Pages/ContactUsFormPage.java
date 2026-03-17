package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsFormPage extends BasePage {

    private final By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");
    private final By contactUsFormButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a");
    private final By getInTouchVisible = By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > h2");
    private final By nameContact = By.cssSelector("#contact-us-form > div:nth-child(2) > input");
    private final By emailContact = By.cssSelector("#contact-us-form > div:nth-child(3) > input");
    private final By subjectContact = By.cssSelector("#contact-us-form > div:nth-child(4) > input");
    private final By messageContact = By.cssSelector("#message");
    private final By fileContact = By.cssSelector("#contact-us-form > div:nth-child(6) > input");
    private final By submitButton = By.cssSelector("#contact-us-form > div:nth-child(7) > input");
    private final By successMessageContact = By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success");
    private final By homeButton = By.cssSelector("#form-section > a");

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    public void HomeCheck() {
        findElement(homeCheck);
        logger.info("Home section is visible");
    }

    public void contactUsFormButtonFun() {
        navigateToHref(contactUsFormButton, "navigate to contact us form");
    }

    public void checkGetInTouchVisible() {
        findElement(getInTouchVisible);
        logger.info("Get In Touch section is visible");
    }

    public void setNameContact(String name) {
        type(nameContact, name);
    }

    public void setEmailContact(String email) {
        type(emailContact, email);
    }

    public void setSubjectContact(String subject) {
        type(subjectContact, subject);
    }

    public void setMessageContact(String message) {
        type(messageContact, message);
    }

    public void setFileContact(String filePath) {
        type(fileContact, filePath);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public void alertFun() {
        acceptAlert();
    }

    public void verifySuccessMessage() {
        findElement(successMessageContact);
        logger.info("Contact form success message is visible");
    }

    public void goHomeButtonFun() {
        navigateToHref(homeButton, "navigate back to home");
    }
}
