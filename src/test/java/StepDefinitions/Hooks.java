package StepDefinitions;

import com.singtel.selenium.config.Config;
import com.singtel.selenium.drivers.WebDriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    @Before
    public void setUp() {
        Config.initProperties();
        setDriver();
        launchURL();
    }
    public void setDriver(){
    driver= WebDriverManager.returnDriver(Config.browser);
    }
    public void launchURL(){
        driver.manage().timeouts().implicitlyWait(Config.longWait, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Config.longWait, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(Config.url);
    }


    @AfterStep
    public void addScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        } catch (WebDriverException noSupportScreenshot) {
            System.err.println(noSupportScreenshot.getMessage());
        }
    }
    @After
    public void quitDriver() {
        driver.quit();
    }
}