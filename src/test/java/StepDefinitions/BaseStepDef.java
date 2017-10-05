package StepDefinitions;




import PageObjects.*;
import Utility.Common;
import Utility.LocalDriverSetup;
import Utility.RemoteDriverSetup;
import Utility.SauceUtils;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
    protected static PopupPage popupPage;
	public String sessionId;
	public boolean sauceLabsFlag = testConfigs.getSauceLabsFlag();

	RemoteDriverSetup rds = new RemoteDriverSetup();
	LocalDriverSetup lds = new LocalDriverSetup();

	public void setDriver() throws Exception{
		//log.log_def_track("Start setDriver of BaseSteps");
		if(sauceLabsFlag) {
			remoteDriver =rds.getRemoteWebDriver(baseScenario.getName());
			sessionId = (((RemoteWebDriver) remoteDriver).getSessionId()).toString();
		} else {
			if (localDriver == null) {
				String browser= System.getProperty("browsername");
				localDriver = lds.getLocalWebDriver(browser);
				//System.out.println(System.getProperty("browsername"));

				localDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				localDriver.manage().window().maximize();
			}
		}

		if(sauceLabsFlag) {
			finalDriver=remoteDriver;
		} else {
			finalDriver=localDriver;
		}
		//log.log_def_track("Closure of setDriver of BaseSteps");
	}


	public void terminateDriver() throws Exception {
		finalDriver.quit();
		//finalDriver=null;
		if (sauceLabsFlag) {

			remoteDriver=null;
			System.out.println("SauceOnDemandSessionID=" + sessionId + "job-name=" + baseScenario.getName());
			if(sessionId!=null)
			SauceUtils.UpdateResults(RemoteDriverSetup.USERNAME, RemoteDriverSetup.ACCESS_KEY, !baseScenario.isFailed(), sessionId);

		} else {
			//System.out.println("No special requirement for local driver closure");
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


	public void initalizePages(WebDriver driver) {

			basePage = new BasePage(driver);
		    homePage = new HomePage(driver);
			contactUsPage = new ContactUsPage(driver);
			summaryPage = new SummaryPage(driver);
            guineaPigPage = new GuineaPigPage(driver);
            linkPage = new LinkPage(driver);
			popupPage = new PopupPage(driver);

			}

public boolean isSingleInstanceExecutionRequired() {
	if(testConfigs.readProperty("singleInstance").equals("YES"))
		return true;
	else
		return false;

	}
}

