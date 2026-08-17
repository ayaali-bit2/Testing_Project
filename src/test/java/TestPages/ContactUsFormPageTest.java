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

        obj.setNameContact("aya");
        obj.setEmailContact("ayaali@gmail.com");
        obj.setSubjectContact("bla bla");
        obj.setMessageContact("brjhbvejhvbejhbvjbvjhbvjhbjh");
        obj.setFileContact(utils.TestConfig.contactUploadFile());

        obj.clickSubmitButton();

        obj.alertFun();

        obj.verifySuccessMessage();
        obj.goHomeButtonFun();
        obj.HomeCheck();
    }


}
