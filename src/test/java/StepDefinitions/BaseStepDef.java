package StepDefinitions;




import PageObjects.*;
import Utility.Common;
import Utility.RemoteDriverSetup;
import Utility.SauceUtils;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;


public class BaseStepDef extends Common {
	public static WebDriver remoteDriver;
	Scenario baseScenario;
	public static WebDriver localDriver;
	public static WebDriver finalDriver;
	protected static BasePage basePage;
	protected static HomePage homePage;
	protected static ContactUsPage contactUsPage;
	protected static SummaryPage summaryPage;
    protected  static GuineaPigPage guineaPigPage;
    protected  static LinkPage linkPage;
	public String sessionId;
	public boolean sauceLabsFlag = testConfigs.getSauceLabsFlag();

	RemoteDriverSetup ds = new RemoteDriverSetup();

	public void setDriver() throws Exception{
		//log.log_def_track("Start setDriver of BaseSteps");
		if(sauceLabsFlag) {
			remoteDriver =ds.getFinalRemoteWebDriver(baseScenario.getName());
			sessionId = (((RemoteWebDriver) remoteDriver).getSessionId()).toString();
		} else {
			if (localDriver == null) {
				System.setProperty("webdriver.gecko.driver", "C:\\AutomationProjects\\Drivers\\geckodriver.exe");
				localDriver = new FirefoxDriver();

				localDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}

		if(remoteDriver==null) {
			finalDriver=localDriver;
		} else {
			finalDriver=remoteDriver;
		}
		//log.log_def_track("Closure of setDriver of BaseSteps");
	}


	public void terminateDriver() throws Exception {
		finalDriver.quit();
		finalDriver=null;
		if (sauceLabsFlag) {

			remoteDriver=null;
			System.out.println("SauceOnDemandSessionID=" + sessionId + "job-name=" + baseScenario.getName());
			SauceUtils.UpdateResults(RemoteDriverSetup.USERNAME, RemoteDriverSetup.ACCESS_KEY, !baseScenario.isFailed(), sessionId);

		} else {
			System.out.println("No special requirement for local driver closure");
			localDriver=null;

		}


	}

/*
	public void setDriver() throws Exception{
		//log.log_def_track("Start setDriver of BaseSteps");
		if( finalDriver == null) {
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");
			localDriver = new ChromeDriver();
			finalDriver = localDriver;
			finalDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if(finalDriver!=null && isSingleInstanceExecutionRequired()) {

		}



	}
	*/

/*
	public void terminateDriver() throws Exception {
		finalDriver.quit();
		finalDriver=null;

		}
		*/


	public void initalize(WebDriver driver) {

			basePage = new BasePage(driver);
		    homePage = new HomePage(driver);
			contactUsPage = new ContactUsPage(driver);
			summaryPage = new SummaryPage(driver);
            guineaPigPage = new GuineaPigPage(driver);
            linkPage = new LinkPage(driver);

			}

public boolean isSingleInstanceExecutionRequired() {
	if(testConfigs.readProperty("singleInstance").equals("YES"))
		return true;
	else
		return false;

	}
}

