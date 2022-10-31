package StepDefinitions;

import com.singtel.pageObjects.TodoHomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class ViewItemActiveTab {

    @When("^user Clicks on Active section$")
    public void user_Clicks_on_Active_section() throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        homepage.gotoActiveItems();
    }

    @Then("^user should see the previously entered \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_should_see_the_previously_entered_and(String todoitem1, String todoitem2) throws Throwable {
        TodoHomePage homepage = new TodoHomePage();
        Assert.assertTrue("todoitem1 is not displayed", homepage.displayToDoItem(todoitem1));
        Assert.assertTrue("todoitem2 is not displayed", homepage.displayToDoItem(todoitem2));
    }

}
