package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class PopUpStepdefs extends BaseStepDef {
    @Given("^I open second website$")
    public void iOpenSecondWebsite() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        popupPage.clickURL("http://toolsqa.com/automation-practice-switch-windows/");
        Thread.sleep(2000);
        popupPage.reachSecondWebsite();
        Thread.sleep(2000);

    }
    @Before
    public void setUp(Scenario scenario) throws Exception {

        baseScenario=scenario;

        initalizePages(finalDriver);


    }
    @After
    public void tearDown(Scenario scenario) throws Exception {
        try {System.out.println("in PopUpStepDefs");
            terminateDriver();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
