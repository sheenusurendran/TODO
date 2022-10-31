package StepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import com.singtel.pageObjects.TodoHomePage;

public class AddItemIntoList {
    @Given("user is on Todoslist screen")
    public void UserOnTodolistscreen() throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        homepage.navigateToHomePage();
    }

    @When("user enters an \"([^\"]*)\" and \"([^\"]*)\"in What needs to be done\\? and pressed Enter key$")
    public void EnterToDoItem(String todoitem1, String todoitem2) throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        homepage.enterYourTodoItem(todoitem1);
        homepage.enterYourTodoItem(todoitem2);
    }

    @Then("^user should be displayed with \"([^\"]*)\" and \"([^\"]*)\" in the Todo list$")
    public void DisplayToDoItem(String todoitem1, String todoitem2) throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        Assert.assertTrue("todoitem1 is not displayed", homepage.displayToDoItem(todoitem1));
        Assert.assertTrue("todoitem2 is not displayed", homepage.displayToDoItem(todoitem2));
    }

    @Then("^user should be displayed with the item left and \"([^\"]*)\"$")
    public void DisplayItemLeft_Count(String count) throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        Assert.assertTrue("item counts with text item lefts are not displayed", homepage.displayItemLeft_Count(count));
    }

    @Then("^user should be displayed with All, Active and Completed buttons as enabled$")
    public void VerifyAllLinks() throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        Assert.assertTrue("All , Active and Completed links are not displayed", homepage.displayAllLinks());
    }

    @Then("^user should be displayed with right Checkboxes \"([^\"]*)\"$")
    public void VerifyCheckboxes(String count) throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        Assert.assertTrue("Checkboxes are not displayed", homepage.displayAllCheckboxes(count));
    }
}
