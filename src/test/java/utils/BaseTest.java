package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    private static final String BASE_URL = System.getProperty("base.url", "https://automationexercise.com/");
    private static final String CHROME_OPTIONS = System.getProperty(
        "chrome.options",
        "--remote-allow-origins=*,--incognito,--ignore-certificate-errors"
    );

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        for (String arg : CHROME_OPTIONS.split(",")) {
            options.addArguments(arg);
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}