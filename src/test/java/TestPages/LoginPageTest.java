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
//        obj.logIn("ayaali@gmail.com", "123456789");
//        obj.checkUserNameBar();
//        obj.deleteButton();
//        obj.checkIsDeleted();
//    }

    @Test
    public void inValidLogin(){
        obj = new LoginPage(driver);
        obj.HomeCheck();
        obj.SingInAndSignUpButton();
        obj.logIn("ayaal@gmail.com", "12345679");

//        obj.checkUserNameBar();
//        obj.deleteButton();
//        obj.checkIsDeleted();

        obj.checkInValidLoginMessageVisability();
    }
}
