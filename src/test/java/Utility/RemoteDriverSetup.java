package Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by ashvimehta on 27/02/2017.
 */
public class RemoteDriverSetup extends Common {
    public DesiredCapabilities caps ;
    public static final String USERNAME = "frameworknew";
    public static final String ACCESS_KEY = testConfigs.readProperty("Saucelabs");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


    public void setDesiredCapability(String jobName) {
        caps = new DesiredCapabilities();
        caps.setCapability("platform", System.getProperty("platform"));
        caps.setCapability("browserName", System.getProperty("browserName"));
        caps.setCapability("version", System.getProperty("version"));
        caps.setCapability("name", jobName);
    }


    public WebDriver getRemoteWebDriver(String jobName) throws Exception {
        //log.log_def_track("start of getFinalRemoteWebDriver in RemoteDriverSetup Class");
        setDesiredCapability(jobName);
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //log.log_def_track("Closure of getFinalRemoteWebDriver in RemoteDriverSetup Class");
        return driver;
    }

}
