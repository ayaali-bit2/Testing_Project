package TestPages;

import Pages.LogoutPage;
import org.testng.annotations.Test;
import utils.BaseTest;

public class LogoutPageTest extends BaseTest {


    LogoutPage obj;

    @Test
    public void logoutFun(){

        obj = new LogoutPage(driver);

        obj.HomeCheck();

        obj.SingInAndSignUpButton();

        obj.NewUserSignUpVisible();

        obj.logIn("ayaali@gmail.com", "123456789");
        obj.checkUserNameBar();

        obj.logOut();

        obj.NewUserSignUpVisible();

    }
}
