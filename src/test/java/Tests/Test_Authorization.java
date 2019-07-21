package Tests;

import Pages.MainNoAuthorizedPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Authorization {

    //private WebDriverManager webDriverManager;
    private WebDriver driver;
    private MainNoAuthorizedPage mainNoAuthorizedPage;



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
    public synchronized void LogIn () throws InterruptedException {
        mainNoAuthorizedPage.correctFillLoginForm();
    }

    @Test
    public void LogInWithNegativeCases ()
    {

    }

    @AfterTest
    public synchronized void GetDown ()
    {
        driver.quit();
        driver = null;

    }
}
