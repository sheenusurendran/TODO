package StepDefinitions;

import com.singtel.pageObjects.TodoHomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ClearAllItem {

    TodoHomePage homepage = new TodoHomePage();

    @Then("^user should be displayed with Clear Completed option")
    public void checkDisplayforClearCompleted() throws Throwable {
        Assert.assertTrue("Clear Completed button is not displayed", homepage.displayClearCompleted());
    }

    @When("^user clicks on Clear Completed button$")
    public void clickClearCompleted() throws Throwable {
        homepage.removeAllItems();
    }

    @Then("^user should not be displayed with \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void checkforDeletedItem(String todoitem1, String todoitem2, String todoitem3) throws Throwable {
        Assert.assertTrue("First deleted item is displayed", homepage.isItemNotVisible(todoitem1));
        Assert.assertTrue("Second deleted item is displayed", homepage.isItemNotVisible(todoitem2));
        Assert.assertTrue("Third deleted item is displayed", homepage.isItemNotVisible(todoitem3));
    }
}
