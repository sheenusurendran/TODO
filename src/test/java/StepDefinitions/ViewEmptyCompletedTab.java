package StepDefinitions;

import com.singtel.pageObjects.TodoHomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ViewEmptyCompletedTab {

    TodoHomePage homepage = new TodoHomePage();

    @When("^user Clicks on Completed section$")
    public void user_Clicks_on_Active_section() throws Throwable {
        homepage.gotoCompletedItems();
    }

    @Then("^user should see not the previously entered \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_should_see_not_the_previously_entered_and(String todoitem1, String todoitem2) throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        Assert.assertTrue("Active item1 in completed tab", homepage.isItemNotVisible(todoitem1));
        Assert.assertTrue("Active item2 is displayed", homepage.isItemNotVisible(todoitem2));
    }
}
