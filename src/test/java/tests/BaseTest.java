package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CompanyPage;
import pages.LoginPage;
import pages.MainPage;
import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    CompanyPage companyPage;
    String user;
    String password;
    String wrongpassword;

    @Parameters({"browser"})
    @BeforeMethod
    @Step("Открытие сайта на странице авторизации")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--guest");
//            options.addArguments("headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        companyPage = new CompanyPage(driver);
        System.setProperty("BASE_URL", PropertyReader.getProperty("raduga.url"));
        user = PropertyReader.getProperty("raduga.user");
        password = PropertyReader.getProperty("raduga.password");
        wrongpassword = PropertyReader.getProperty("raduga.wrongpassword");
    }

    @Step("Закрытие браузера")
    @AfterMethod
    public void close() {
        driver.quit();
    }
}
