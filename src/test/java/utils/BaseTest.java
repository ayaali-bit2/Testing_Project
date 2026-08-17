package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("--ignore-certificate-errors");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        //driver =  new ChromeDriver();
    }

    @BeforeMethod
    public void navigate(){
        driver.get(TestConfig.baseUrl());
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void removeIntialization(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void quitFromBrowser(){
        driver.quit();
    }


}
