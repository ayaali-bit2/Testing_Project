package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;
import utils.FailureScreenshotUtil;

public class Hook {

    public static WebDriver driver;
    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("--ignore-certificate-errors");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
    }

    @After
    public void captureFailure(Scenario scenario){
        if (scenario.isFailed()) {
            FailureScreenshotUtil.capture(driver, scenario.getName());
        }
    }

    @After
    public void quit(){
        driver.manage().deleteAllCookies();
        driver.quit();

    }
}
