package TestPages;

import Pages.LoginPage;
import Pages.RegisterPage;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LoginPageTest extends BaseTest {

    LoginPage obj;

//    @Test
//    public void validLogin(){
//        obj = new LoginPage(driver);
//        obj.HomeCheck();
//        obj.SingInAndSignUpButton();
//        obj.setEmailAddressField("ayaali@gmail.com");
//        obj.setPasswordField("123456789");
//        obj.setSignUpButton();
//        obj.checkUserNameBar();
//        obj.deleteButton();
//        obj.checkIsDeleted();
//    }

    @Test
    public void inValidLogin(){
        obj = new LoginPage(driver);
        obj.HomeCheck();
        obj.SingInAndSignUpButton();
        obj.setEmailAddressField(utils.TestConfig.invalidEmail());
        obj.setPasswordField(utils.TestConfig.invalidPassword());
        obj.setSignUpButton();

//        obj.checkUserNameBar();
//        obj.deleteButton();
//        obj.checkIsDeleted();

        obj.checkInValidLoginMessageVisability();
    }
}
