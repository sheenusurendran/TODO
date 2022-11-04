package com.singtel.pageObjects;
import StepDefinitions.Hooks;
import com.singtel.selenium.Actions.GenericActions;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TodoHomePage  {
    public WebDriver driver=Hooks.driver;
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    GenericActions genericActions =new GenericActions();
     static final Logger logger =LogManager.getLogger(TodoHomePage.class);
    public TodoHomePage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    protected void WaitUntilElementInVisible(String item) {
        genericActions.WaitUntilElementInVisible(By.xpath("//label[contains(text(),'" + item + "')]"),driver);
    }

    @FindBy(xpath = "//ul[@class='todo-list']")
    @CacheLookup
    private WebElement list_todo;

    @FindBy(xpath = "//input[(@type='checkbox') and @class='toggle']")
    @CacheLookup
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//input[@placeholder='What needs to be done?']")
    @CacheLookup
    private WebElement txt_searchInput;

    @FindBy(xpath = "//span[@class='todo-count']")
    @CacheLookup
    private WebElement lb_todocount;

    @FindBy(xpath = "//a[@href='#/active'][text()='Active']")
    @CacheLookup
    private WebElement lnk_Active;

    @FindBy(xpath = "//a[@href='#/completed'][text()='Completed']")
    @CacheLookup
    private WebElement lnk_Completed;

    @FindBy(xpath = "//a[@href='#/all'][text()='All']")
    @CacheLookup
    private WebElement lnk_All;

    @FindBy(xpath = "//button[@class='destroy']")
    @CacheLookup
    private List<WebElement> btn_destroy;

    @FindBy(xpath = "//button[@class='clear-completed']")
    @CacheLookup
    private WebElement btn_clearcompleted;

    @FindBy(xpath = "//label[contains(text(),'Mark all as complete')]")
    @CacheLookup
    private WebElement btn_selectAll;

    @FindBy(xpath = "//a[@href='#/all'][text()='All'][@class='selected']")
    @CacheLookup
    private WebElement lnk_selectedAll;

    @FindBy(xpath = "//a[@href='#/active'][text()='Active'][@class='selected']")
    @CacheLookup
    private WebElement lnk_selectedActive;

    @FindBy(xpath = "//a[@href='#/completed'][text()='Completed'][@class='selected']")
    @CacheLookup
    private WebElement lnk_selectedCompleted;


    public void navigateToHomePage() throws Exception {
       genericActions.WaitUntilElementVisible(txt_searchInput,driver);
        Assert.assertTrue("MVC user is not navigated to To do home page",txt_searchInput.isDisplayed());
    }

    public void enterYourTodoItem(String item) {
       Assert.assertTrue("Search text box is not displayed",txt_searchInput.isDisplayed());
        txt_searchInput.click();
        txt_searchInput.clear();
        txt_searchInput.sendKeys(item);
        txt_searchInput.sendKeys(Keys.ENTER);
        logger.info("user entered the to do item" +item);
    }

    public WebElement getDynamicElementforItem(String item) {
        return list_todo.findElement(By.xpath("//label[contains(text(),'" + item + "')]"));
    }

    public Boolean isItemNotVisible(String item) {
        WaitUntilElementInVisible(item);
        return list_todo.findElements(By.xpath("//label[contains(text(),'" + item + "')]")).size() == 0;
    }

    public WebElement getDynamicElementforCount(String count) {
        return lb_todocount.findElement(By.xpath("//strong[contains(text(),'" + count + "')]"));
    }

    public boolean displayToDoItem(String item) {
        list_todo.findElement(By.xpath("//label[contains(text(),'" + item + "')]"));
        return getDynamicElementforItem(item).isDisplayed();
    }

    public boolean displayItemLeft_Count(String count) {
        lb_todocount.findElement(By.xpath("//strong[contains(text(),'" + count + "')]"));
        //jse.executeScript("arguments[0].scrollIntoView()", lbl_itemleft);
        return getDynamicElementforCount(count).isDisplayed();
    }

    public boolean displayAllLinks() {
        return lnk_All.isDisplayed() && lnk_Active.isDisplayed() && lnk_Completed.isDisplayed();
    }

    public boolean displayAllCheckboxes(String checkBoxCount) {
        int size = checkboxes.size();
        return size == Integer.parseInt(checkBoxCount);
    }

    public void gotoActiveItems() {
        lnk_Active.click();
    }

    public void gotoAllItems() {
        lnk_All.click();
    }

    public void gotoCompletedItems() {
        lnk_Completed.click();
    }

    public void selectSingleItem() {
        checkboxes.get(0).click();
    }

    public boolean displayClearCompleted() {
        return btn_clearcompleted.isDisplayed();
    }

    public boolean displayDeleteCrossButton() throws InterruptedException {
        Actions builder = new Actions(driver);
        builder.contextClick(btn_destroy.get(0));
        return btn_destroy.get(0).isEnabled();
    }

    public void clearItem() {
        btn_destroy.get(0);
    }

    public void selectAllItems() {
        btn_selectAll.click();
    }

    public void removeAllItems() {
        btn_clearcompleted.click();
        logger.info("user clicked on Completed tab");
    }

    public void ScrolltoCrossButtonToDelete() throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView();", btn_destroy.get(0));
        jse.executeScript("arguments[0].click();", btn_destroy.get(0));
    }

    public boolean btn_checkActiveSelected() {
        jse.executeScript("arguments[0].scrollIntoView();", lnk_selectedActive);
        return lnk_selectedActive.isDisplayed();
    }

    public boolean btn_checkAllSelected() {
        jse.executeScript("arguments[0].scrollIntoView();", lnk_selectedAll);
        return lnk_selectedAll.isDisplayed();
    }

    public boolean btn_checkCompletedSelected() {
        jse.executeScript("arguments[0].scrollIntoView();", lnk_selectedCompleted);
        return lnk_selectedCompleted.isDisplayed();
    }
}

