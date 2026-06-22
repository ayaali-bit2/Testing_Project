package TestPages;

import Pages.LoginPage;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LoginPageTest extends BaseTest {

    LoginPage obj;

    @Test
    public void inValidLogin() {
        obj = new LoginPage(driver);
        obj.HomeCheck();
        obj.SingInAndSignUpButton();
        obj.loginAs("ayaal@gmail.com", "12345679");
        obj.checkInValidLoginMessageVisability();
    }

    @Test
    public void loginShouldLoadHomeWithoutTimeoutErrorPage() {
        obj = new LoginPage(driver);
        obj.HomeCheck();
        obj.SingInAndSignUpButton();
        obj.loginAs("ayaali@gmail.com", "123456789");
        obj.checkUserNameBar();
    }
}