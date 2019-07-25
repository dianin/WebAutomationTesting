package Tests;

import Pages.MainNoAuthorizedPage;
import Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Test_Authorization {

    //private WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private MainNoAuthorizedPage mainNoAuthorizedPage;
    private MainPage mainPage;



    @BeforeMethod
    public void SetUp ()
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.get("https://github.com/login");
        mainNoAuthorizedPage = new MainNoAuthorizedPage(webDriver);
        mainPage = new MainPage(webDriver);

    }

    @Test
    public void LogInWithNegativeCasesPass ()
    {
        mainNoAuthorizedPage.enterInvalidDataPass();
        mainNoAuthorizedPage.signIn();
        mainNoAuthorizedPage.checkForWarningError();
    }

    @Test
    public void LogInWithNegativeCasesEmail ()
    {
        mainNoAuthorizedPage.enterInvalidDataEmail();
        mainNoAuthorizedPage.signIn();
        mainNoAuthorizedPage.checkForWarningError();
    }


    @Test
    public synchronized void LogInValidDataViaEmail ()  {
        mainNoAuthorizedPage.authorizedViaEmail();
        mainNoAuthorizedPage.signIn();
        mainPage.verifyPage();
    }

    @Test
    public synchronized void LogInValidDataViaUserName ()
    {
        mainNoAuthorizedPage.authorizedVidUserName();
        mainNoAuthorizedPage.signIn();
        mainPage.verifyPage();
    }


    @AfterMethod
    public synchronized void GetDown ()
    {
        webDriver.quit();
        webDriver = null;

    }
}
