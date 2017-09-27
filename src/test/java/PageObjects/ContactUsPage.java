package PageObjects;

import SeleniumWrapper.SeleniumLib;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ContactUsPage extends BasePage {


    public ContactUsPage(WebDriver driver) {
        super(driver);
        pageDriver=driver;

    }
    public WebDriver pageDriver;

    public static final Logger LOGGER = LoggerFactory.getLogger(ContactUsPage.class);

    String verificationString= testData.readProperty("ContactUSPage.VerificationString");

    String expectedMessageLocator=  pageElements.readProperty("ContactUsPage.Message");
    String NameLocator=  pageElements.readProperty("ContactUSPage.NameLocator");
    String EmailLocator=  pageElements.readProperty("ContactUSPage.EmailLocator");
    String MessageLocator=  pageElements.readProperty("ContactUSPage.MessageLocator");
    String SubmitMessageLocator = pageElements.readProperty("ContactUsPage.SubmitMessageLocator");




    public boolean isPageLoaded() {
        return seleniumLib.isTextContainedInElement(seleniumLib.getElement(expectedMessageLocator),verificationString);
    }

    public void submitDefaultForm(List<List<String>> data) {
        enterText(getElement(NameLocator),data.get(0).get(1));
        //seleniumLib.enterText((seleniumLib.getElement(NameLocator)),data.get(0).get(1));
        seleniumLib.enterText((seleniumLib.getElement(EmailLocator)),data.get(1).get(1));
        seleniumLib.enterText((seleniumLib.getElement(MessageLocator)),data.get(2).get(1));

        clickOnElement(getElement(SubmitMessageLocator));

    }
}
