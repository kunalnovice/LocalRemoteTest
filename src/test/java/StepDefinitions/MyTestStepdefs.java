package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.junit.Assert;


public class MyTestStepdefs extends BaseStepDef {
    @Given("^I am on some Page$")
    public void iAmOnThPage() throws Throwable {
        basePage.openTestSite();
        throw new Exception();
    }
}
