package Pages;

import Utils.WaitHandler;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static Utils.getProperty.getConfigProperty;

public class MainNoAuthorizedPage {

    private WebDriver webDriver;
    private WaitHandler waitHandler;

    public MainNoAuthorizedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        waitHandler = new WaitHandler(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    private By loginForm = By.xpath("//*[@id=\"login_field\"]");
    private By passwordForm = By.xpath("//*[@id=\"password\"]");
    private By registration = By.xpath("//*[@id=\"w1\"]/li[3]/a");
    private By signInButton = By.xpath("//*[@class='btn btn-primary btn-block']");
    private By warningIncorectPass = By.id("js-flash-container");






    public synchronized void  enterValidData ()
    {
        waitHandler.input(loginForm, getConfigProperty("firstAccountEmail"));
        waitHandler.input(passwordForm,"firstAccountPass");
    }

    public synchronized void enterInvalidData ()
    {
        waitHandler.input(loginForm, getConfigProperty("firstAccountEmail"));
        waitHandler.input(passwordForm, getConfigProperty("invalidPassword"));
    }

    public synchronized void signIn ()
    {
        waitHandler.shotWaitAndClick(signInButton);
    }
}
