package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsFormPage {

    WebDriver driver;

    public ContactUsFormPage(WebDriver driver) {
        this.driver = driver;
    }

    By homeCheck = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > h2");

    By contactUsFormButton = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a");

    By getInTouchVisible = By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > h2");

    By nameContact = By.cssSelector("#contact-us-form > div:nth-child(2) > input");
    By emailContact = By.cssSelector("#contact-us-form > div:nth-child(3) > input");
    By subjectContact = By.cssSelector("#contact-us-form > div:nth-child(4) > input");
    By messageContact = By.cssSelector("#message");
    By fileContact = By.cssSelector("#contact-us-form > div:nth-child(6) > input");

    By submitButton = By.cssSelector("#contact-us-form > div:nth-child(7) > input");

    By successMessageContact = By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success");

    By homeButton = By.cssSelector("#form-section > a");

    public void HomeCheck() {
        System.out.println(driver.findElement(homeCheck).isDisplayed());
    }

    public void contactUsFormButtonFun() {
        WebElement textField = driver.findElement(contactUsFormButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }

    public void checkGetInTouchVisible(){
        System.out.println(driver.findElement(getInTouchVisible).isDisplayed());
    }

    public void setNameContact(String name) {
        driver.findElement(nameContact).sendKeys(name);
    }

    public void setEmailContact(String email) {
        driver.findElement(emailContact).sendKeys(email);
    }

    public void setSubjectContact(String subject) {
        driver.findElement(subjectContact).sendKeys(subject);
    }

    public void setMessageContact(String message) {
        driver.findElement(messageContact).sendKeys(message);
    }

    public void setFileContact(String filePath) {
        driver.findElement(fileContact).sendKeys(filePath);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void alertFun(){
        driver.switchTo().alert().accept();
    }

    public void verifySuccessMessage(){
        System.out.println(driver.findElement(successMessageContact).isDisplayed());
    }

    public void goHomeButtonFun() {
        WebElement textField = driver.findElement(homeButton);
        String value2 = textField.getAttribute("href");
        driver.navigate().to(value2);
    }
}
