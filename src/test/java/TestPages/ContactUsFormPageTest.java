package TestPages;

import Pages.ContactUsFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ContactUsFormPageTest extends BaseTest {

    ContactUsFormPage obj;

    @Test
    public void checkContactForm(){

        obj = new ContactUsFormPage(driver);

        obj.HomeCheck();
        obj.contactUsFormButtonFun();

        obj.checkGetInTouchVisible();

        obj.setNameContact(utils.TestConfig.contactValue("name"));
        obj.setEmailContact(utils.TestConfig.contactValue("email"));
        obj.setSubjectContact(utils.TestConfig.contactValue("subject"));
        obj.setMessageContact(utils.TestConfig.contactValue("message"));
        obj.setFileContact(utils.TestConfig.contactUploadFile());

        obj.clickSubmitButton();

        obj.alertFun();

        obj.verifySuccessMessage();
        obj.goHomeButtonFun();
        obj.HomeCheck();
    }


}
