package StepDefinitions;

import com.singtel.pageObjects.TodoHomePage;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class MoveItemsToCompletedTab {

    TodoHomePage homepage = new TodoHomePage();

    @When("^user clicks on Completed button$")
    public void clicksCompleted_button() throws Throwable {
        homepage.gotoCompletedItems();
        Assert.assertTrue("Completed button is  not selected",homepage.btn_checkCompletedSelected());
    }

    @When("^user clicks on Active button$")
    public void clicksActive_button() throws Throwable {
        homepage.gotoActiveItems();
        Assert.assertTrue("Active button is not selected",homepage.btn_checkActiveSelected());

    }

    @When("^user clicks on All button$")
    public void clicksAll_button() throws Throwable {
        homepage.gotoAllItems();
        Assert.assertTrue("Completed button is not selected",homepage.btn_checkAllSelected());
    }
}
