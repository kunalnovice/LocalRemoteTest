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
    String yourCommentsSpan = pageElements.readProperty("GuineaPigPage.yourCommentsSpan");
    String commentsTextAreaInput = pageElements.readProperty("GuineaPigPage.commentsTextAreaInput");
    String submitButton = pageElements.readProperty("GuineaPigPage.submitButton");





    public void followLink() {

        seleniumLib.getElement(theActiveLink).click();
    }

    public void submitComment(String text) {
        seleniumLib.getElement(commentsTextAreaInput).sendKeys(text);
        seleniumLib.getElement(submitButton).click();

        seleniumLib.waitForTextPresentInElement(seleniumLib.getElement(yourCommentsSpan),text);

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
    return seleniumLib.isTextContainedInElement(seleniumLib.getElement(yourCommentsSpan),pageElements.readProperty("RANDOM_TEXT"));
    }
}
