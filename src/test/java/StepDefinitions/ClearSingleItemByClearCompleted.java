package StepDefinitions;

import com.singtel.pageObjects.TodoHomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ClearSingleItemByClearCompleted {
    TodoHomePage homepage = new TodoHomePage();

    public ClearSingleItemByClearCompleted() throws Exception {
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String arg1) throws Throwable {
        homepage.selectSingleItem();
    }

    @Then("^user should be displayed with the Cross button to delete$")
    public void user_should_be_displayed_with_the_Cross_button_to_delete() throws Throwable {
        Assert.assertTrue("Cross button to deleted is not displayed", homepage.displayClearCompleted());
    }

    @Then("^user should be displayed with Clear Completed")
    public void user_should_be_displayed_with_Clear_Completed_option() throws Throwable {
        Assert.assertTrue("Clear Completed button is not displayed", homepage.displayDeleteCrossButton());
    }

    @Then("^user should be displayed with \"([^\"]*)\" with item left$")
    public void user_should_be_displayed_with_with_item_left(String count) throws Throwable {
        Assert.assertTrue("No of item displayed is not correct", homepage.displayItemLeft_Count(count));
    }

    @Then("^user should be displayed with \"([^\"]*)\"$")
    public void displayRemaningItems(String todoitem2) throws Throwable {
        Assert.assertTrue("Todoitem 2 is not displayed", homepage.displayToDoItem(todoitem2));
    }
}
