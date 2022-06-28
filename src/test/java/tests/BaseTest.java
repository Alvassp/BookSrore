package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected final static LoginPage loginPage = new LoginPage();

//    @BeforeTest(description = "Получение параметров тестового окружения")
//    @Parameters(/*value = "browser"*/)
    @Step("Navigate to https://demoqa.com/books")
    public void setUp(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Configuration.browser = "chrome";
                break;
            case "geckodriver":
                WebDriverManager.firefoxdriver().setup();
                Configuration.browser = "firefox";
                break;
        }
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
    }

    public void init() {
        setUp("chrome");
        open("https://demoqa.com/books");
    }

    @AfterSuite(alwaysRun = true)
    @Step("Close webdriver")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
