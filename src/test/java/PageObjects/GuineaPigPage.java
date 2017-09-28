package PageObjects;

import org.openqa.selenium.WebDriver;

public class GuineaPigPage extends BasePage {


    public GuineaPigPage(WebDriver driver) {
        super(driver);
        pageDriver=driver;
        //log.log_def_track(" completing in constructor of GuineaPigPage");
    }
    public WebDriver pageDriver;

    String theActiveLink =pageElements.readProperty("GuineaPigPage.link");
    String comments = pageElements.readProperty("GuineaPigPage.Comments");
    String email = pageElements.readProperty("GuineaPigPage.Email");
    String submitButton = pageElements.readProperty("GuineaPigPage.submitButton");
    String yourComments = pageElements.readProperty("GuineaPigPage.YourComments");
    String enteredComments= testData.readProperty("GuineaPigPage.EnteredComments");





    public void followLink() {

        seleniumLib.getElement(theActiveLink).click();
    }

    public void submitForm() {
        String text="abc@def.com";
        enterText(getElement(email),text);
        enterText(getElement(comments),enteredComments);
        //seleniumLib.getElement(commentsTextAreaInput).sendKeys(text);
        //seleniumLib.getElement(submitButton).click();

        //seleniumLib.waitForTextPresentInElement(seleniumLib.getElement(commentsTextAreaInput),text);
        seleniumLib.getElement(submitButton).click();

        // Race condition for time to populate yourCommentsSpan
       // WebDriverWait wait = new WebDriverWait(this.driver, 15);
       // wait.until(ExpectedConditions.textToBePresentInElement(yourCommentsSpan, text));
    }

   // public String getSubmittedCommentText() {
       // return this.yourCommentsSpan.getText();
 //   }

    public boolean isOnPage() {
        String title = "I am a page title - Sauce Labs";
        return true;
    }

    public boolean isCommentDisplayed() {
        seleniumLib.waitForElementVisible(getElement(yourComments));
    return seleniumLib.isTextContainedInElement(getElement(yourComments),enteredComments);
    }

    public boolean isPageLoaded() {
        return seleniumLib.waitForElementVisible(getElement(comments));
    }


}
