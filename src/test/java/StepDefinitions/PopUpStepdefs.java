package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class PopUpStepdefs extends BaseStepDef {
    @Given("^I open second website$")
    public void iOpenSecondWebsite() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        popupPage.clickURL("http://toolsqa.com/automation-practice-switch-windows/");
        Thread.sleep(10000);
        popupPage.reachSecondWebsite();
        Thread.sleep(10000);

    }
}
