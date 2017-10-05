package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopupPage extends BasePage {

    String secondWindowButtonLocator =pageElements.readProperty("MainWindow.newPopUp");
    String divStringExpectedValue=testData.readProperty("LinkPage.DivExpectedValue");

    public PopupPage(WebDriver driver) {
        super(driver);
        pageDriver=driver;
        //log.log_def_track(" completing in constructor of GuineaPigPage");
    }
    public WebDriver pageDriver;


    public void reachSecondWebsite() {
        //clickOnElement(getElement(""));
        List<WebElement> webElements= pageDriver.findElements(By.tagName("Button"));

       int size= webElements.size();

       for(int i=0;i<size;i++) {
           if(webElements.get(i).getText().equals("New Browser Window")) {
               webElements.get(i).sendKeys(Keys.ENTER);
           }
       }
    }
}
