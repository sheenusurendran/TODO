package com.singtel.selenium.drivers;

import com.singtel.selenium.config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverManager {
    static final Logger logger = LogManager.getLogger(WebDriverManager.class);
    public static WebDriver returnDriver(String browser) {
        WebDriver driver = null;
        ChromeOptions options;

        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    logger.info("Execution will be done in chrome browser");
                    System.setProperty(Config.chromeDriver,Config.currentDirectory + Config.fs + "resources" + Config.fs +"driver"+Config.fs+ Config.browser );
                    options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    driver =new ChromeDriver(options);
                    driver.manage().deleteAllCookies();
                    break;
                case "firefox":
                    logger.info("Execution will be done in edge browser");
                    System.setProperty(Config.chromeDriver,Config.currentDirectory + Config.fs + "resources" + Config.fs +"driver"+Config.fs+ Config.browser );
                    //driver =new FirefoxDriver();
                    break;
            }
        }catch (RuntimeException e){
           e.getMessage();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
