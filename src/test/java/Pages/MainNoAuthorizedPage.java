package Pages;

import Utils.WaitHandler;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainNoAuthorizedPage {

    private WebDriver webDriver;
    private WaitHandler waitHandler;

    public MainNoAuthorizedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        waitHandler = new WaitHandler(webDriver);
        PageFactory.initElements(webDriver, this);

    }
    //*[@id="user[login]"]
    //*[@id="user[login]"]
    /*@FindBy(xpath = "//*[@id=\"login_field\"]")
    private WebElement loginForm;*/
    /*@FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordForm;*/

    private By loginForm = By.xpath("//*[@id=\"login_field\"]");
    private By passwordForm = By.xpath("//*[@id=\"password\"]");
    private By registration = By.xpath("//*[@id=\"w1\"]/li[3]/a");





    public synchronized void  correctFillLoginForm () throws InterruptedException {
        wait(1111);
        System.out.println(waitHandler.elementDisplayed(loginForm));
        System.out.println(waitHandler.elementDisplayed(registration));
    }
}
