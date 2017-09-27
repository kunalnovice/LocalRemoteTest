package PageObjects;

import org.openqa.selenium.WebDriver;

public class LinkPage extends BasePage {

    String divStringValueLocator =pageElements.readProperty("LinkPage.DivString");
    String divStringExpectedValue=testData.readProperty("LinkPage.DivExpectedValue");

    public LinkPage(WebDriver driver) {
        super(driver);
        pageDriver=driver;
        //log.log_def_track(" completing in constructor of GuineaPigPage");
    }
    public WebDriver pageDriver;



    public boolean validateLinkPage() {
        return seleniumLib.isTextContainedInElement(getElement(divStringValueLocator),divStringExpectedValue);
    }
}
