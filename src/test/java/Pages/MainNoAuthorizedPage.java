package Pages;

import Utils.WaitHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static Utils.getProperty.getConfigProperty;

public class MainNoAuthorizedPage {

    private WebDriver driver;
    private WaitHandler waitHandler;

    public MainNoAuthorizedPage(WebDriver driver) {
        this.driver = driver;
        waitHandler = new WaitHandler(driver);
        PageFactory.initElements(driver, this);

    }

    private By loginForm = By.xpath("//*[@id=\"login_field\"]");
    private By passwordForm = By.xpath("//*[@id=\"password\"]");
    private By registration = By.xpath("//*[@id=\"w1\"]/li[3]/a");
    private By signInButton = By.xpath("//*[@class='btn btn-primary btn-block']");
    private By warningIncorectPass = By.id("js-flash-container");






    public synchronized void authorizedViaEmail()
    {
        waitHandler.input(loginForm, getConfigProperty("firstAccountEmail"));
        waitHandler.input(passwordForm,getConfigProperty("firstAccountPass"));
    }

    public synchronized void authorizedVidUserName ()
    {
        waitHandler.input(loginForm, getConfigProperty("firstAccountUserName"));
        waitHandler.input(passwordForm,getConfigProperty("firstAccountPass"));
    }

    public synchronized void enterInvalidDataPass()
    {
        waitHandler.input(loginForm, getConfigProperty("firstAccountEmail"));
        waitHandler.input(passwordForm, getConfigProperty("invalidPassword"));
    }

    public synchronized void enterInvalidDataEmail ()
    {
        waitHandler.input(loginForm, getConfigProperty("invalidEmail"));
        waitHandler.input(passwordForm,"firstAccountPass");
    }

    public synchronized void checkForWarningError ()
    {
        Assert.assertEquals(getConfigProperty("warningMessageSignIn"),
                waitHandler.getText(warningIncorectPass) );
    }

    public synchronized MainPage signIn ()
    {
        waitHandler.shotWaitAndClick(signInButton);
        return new MainPage(driver);
    }


}
