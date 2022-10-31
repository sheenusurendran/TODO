package com.singtel.selenium.Actions;

import com.singtel.selenium.config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.concurrent.TimeUnit;

public class GenericActions {
    FluentWait<WebDriver> wait;
    WebDriver driver;
    public void WaitUntilElementVisible(WebElement element, WebDriver dr) {
         this.driver=dr;
        wait = new FluentWait<>(driver);
        wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
        wait.withTimeout(Config.longWait, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void WaitUntilElementInVisible(By element,WebDriver dr) {
        this.driver=dr;
        wait = new FluentWait<>(driver);
        wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
        wait.withTimeout(Config.longWait, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
}
