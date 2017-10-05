package Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by ashvimehta on 27/02/2017.
 */
public class LocalDriverSetup extends Common {
    public DesiredCapabilities caps ;
    public static final String USERNAME = "framework";
    public static final String ACCESS_KEY = testConfigs.readProperty("Saucelabs");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public WebDriver driver = null;

    public void setDesiredCapability(String jobName) {
        caps = new DesiredCapabilities();
        caps.setCapability("platform", System.getProperty("platform"));
        caps.setCapability("browserName", System.getProperty("browserName"));
        caps.setCapability("version", System.getProperty("version"));
        caps.setCapability("name", jobName);
    }


    public WebDriver getLocalWebDriver(String browserName) throws Exception {
         browserName= System.getProperty("browserName");
         if (browserName==null) {
             browserName="default";
        }
        //log.log_def_track("start of getFinalRemoteWebDriver in RemoteDriverSetup Class");
        switch(browserName) {
            case "firefox" : {
                System.setProperty("webdriver.gecko.driver", "C:\\AutomationProjects\\Drivers\\geckodriver.exe");
                driver= new FirefoxDriver();
                break;
            }
            // TODO: 04/10/2017  
            case "MicrosoftEdge" : {
                System.setProperty("webdriver.ie.driver", "C:\\AutomationProjects\\Drivers\\IEDriverServer.exe");
                driver= new InternetExplorerDriver();
                break;
            }

            case "iexplore" : {
                System.setProperty("webdriver.ie.driver", "C:\\AutomationProjects\\Drivers\\IEDriverServer.exe");
                driver= new InternetExplorerDriver();
                break;
            }

            case "default" :
                System.setProperty("webdriver.ie.driver", "C:\\AutomationProjects\\Drivers\\IEDriverServer.exe");
                driver= new InternetExplorerDriver();
                break;
        }
        return driver;
    }

}
