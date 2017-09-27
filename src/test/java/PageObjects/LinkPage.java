package PageObjects;

import org.openqa.selenium.WebDriver;

public class LinkPage extends BasePage {


    public LinkPage(WebDriver driver) {
        super(driver);
        pageDriver=driver;
        //log.log_def_track(" completing in constructor of GuineaPigPage");
    }
    public WebDriver pageDriver;

String div = pageElements.readProperty("LinkPage.Div");
    public boolean validateLinkPage() {
        return seleniumLib.isTextContainedInElement(seleniumLib.getElement(div),pageElements.readProperty("LinkPage.ACTUAL_TEXT"));
    }
}
