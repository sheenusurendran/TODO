package StepDefinitions;

import com.singtel.pageObjects.TodoHomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ClearSingleItemByCrossButton {

    TodoHomePage homepage = new TodoHomePage();

    @When("^user enters an \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" in What needs to be done\\? and pressed Enter key$")
    public void enterItems(String todoitem1, String todoitem2, String todoitem3) throws Throwable {
        homepage.enterYourTodoItem(todoitem1);
        homepage.enterYourTodoItem(todoitem2);
        homepage.enterYourTodoItem(todoitem3);
    }

    @When("^user clicks on Select All option$")
    public void selectAllItems() throws Throwable {
        homepage.selectAllItems();
    }

    @Then("^user should be displayed with the Cross button to delete on the right$")
    public void checkForCrossButton() throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        Assert.assertTrue("Cross button is not displayed", homepage.displayDeleteCrossButton());
    }

    @When("^user clicks on Cross button against the first item$")
    public void clickforCrossButton() throws Throwable {
        homepage.ScrolltoCrossButtonToDelete();
    }

    @Then("^user should be displayed with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void displayRemaningItems(String todoitem2, String todoitem3) throws Throwable {
        Assert.assertTrue("todoitem2 is not displayed", homepage.displayToDoItem(todoitem2));
        Assert.assertTrue("todoitem3 is not displayed", homepage.displayToDoItem(todoitem3));
    }

    @Then("^user should not be displayed with \"([^\"]*)\"$")
    public void checkforDeletedItem(String todoitem1) throws Throwable {
        Assert.assertTrue("Deleted item is displayed", homepage.isItemNotVisible(todoitem1));
    }

}
