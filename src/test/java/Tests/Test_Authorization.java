package Tests;

import Pages.MainNoAuthorizedPage;
import Utils.WaitHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utils.getProperty.getConfigProperty;

public class Test_Authorization {

    //private WebDriverManager webDriverManager;
    private WebDriver driver;
    private MainNoAuthorizedPage mainNoAuthorizedPage;


    public Test_Authorization(MainNoAuthorizedPage mainNoAuthorizedPage) {
        WaitHandler waitHandler = new WaitHandler(driver);
        MainNoAuthorizedPage mainNoAuthorizedPage1 = new MainNoAuthorizedPage(driver);
    }

    @BeforeTest
    public void SetUp ()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        mainNoAuthorizedPage = new MainNoAuthorizedPage(driver);

    }

    @Test
    public void LogInWithNegativeCases ()
    {
        mainNoAuthorizedPage.enterInvalidData();
        mainNoAuthorizedPage.signIn();
        Assert.assertEquals(getConfigProperty("warningMessageSignIn"),
                waitHandler.getText(warningIncorectPass) );


    }

    @Test
    public synchronized void LogInValidData ()  {
        mainNoAuthorizedPage.enterValidData();
        mainNoAuthorizedPage.signIn();
    }

    @AfterTest
    public synchronized void GetDown ()
    {
        driver.quit();
        driver = null;

    }
}
