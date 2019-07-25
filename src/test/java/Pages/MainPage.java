package Pages;

import Utils.WaitHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static Utils.getProperty.getConfigProperty;

public class MainPage {

    private WebDriver webDriver;

    private WaitHandler waitHandler;

    private By dropdownCaret = By.xpath("(//*[@class='Header-link']//*[@class='dropdown-caret'])[2]");
    private By signedInAs = By.xpath("//*[@role='menuitem' and @href='/" +getConfigProperty("firstAccountUserName") +"']");
    //private By userNameFromDropDown = By.xpath("//*[@role='menuitem']//*[@class='css-truncate-target']");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        waitHandler = new WaitHandler(webDriver);

    }

    public synchronized void verifyPage ()  {
        String string = "Signed in as " + getConfigProperty("firstAccountUserName");
        waitHandler.shortWaitForLoad(dropdownCaret);
        waitHandler.shotWaitAndClick(dropdownCaret);
        waitHandler.getText(signedInAs);
        Assert.assertEquals(waitHandler.getText(signedInAs), string);
    }
}
