package StepDefinitions;


import PageObjects.GuineaPigPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class GuineaPigSteps extends BaseStepDef {

		public String commentInputText;

	@Before
	public void setUp(Scenario scenario) throws Exception {
		//log.log_def_track("Start Before Hook of GuineaPigSteps");
		baseScenario=scenario;
		setDriver();
		initalize(finalDriver);
		//log.log_def_track("Closure Before Hook of GuineaPigSteps");

	}

	@Given("^I am on the Guinea Pig homepage$")
	public void user_is_on_guinea_pig_page() throws Exception {
		//log.log_def_track("Start Given of GuineaPigSteps");
		basePage.clickURL(testData.readProperty("TEST_URL"));
	}

	@When("^I click on the link$")
	public void user_click_on_the_link() throws Exception {
		guineaPigPage.followLink();
	}

	@When("^I submit a comment$")
	public void user_submit_comment() throws Exception {
		commentInputText = pageElements.readProperty("RANDOM_TEXT");
		guineaPigPage.submitComment(commentInputText);
	}

	@Then("^I should be on another page$")
	public void new_page_displayed() throws Exception {
		assertTrue(linkPage.validateLinkPage());
	}

	@Then("^I should see that comment displayed$")
	public void comment_displayed() throws Exception {
	//	assertThat(page.getSubmittedCommentText(), containsString(commentInputText));
		Assert.assertTrue(guineaPigPage.isCommentDisplayed());
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		try {
			terminateDriver();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}