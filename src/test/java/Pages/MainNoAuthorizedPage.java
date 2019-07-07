package Pages;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainNoAuthorizedPage {

    private WebDriver webDriver;

    public MainNoAuthorizedPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }
    //*[@id="user[login]"]
    //*[@id="user[login]"]
    @FindBy(xpath = "//*[@id=\"user[login]\"]")
    private WebElement loginForm;
    @FindBy(xpath = "//*[@id=\"user[email]\"]")
    private WebElement emailForm;
    @FindBy (xpath = "//*[@id=\"user[password]\"]")
    private WebElement passwordForm;



    public synchronized void  correctFillLoginForm () throws InterruptedException {
        wait(1000);
        loginForm.click();
        wait(1000);
        loginForm.sendKeys("testAccount456");
        wait(1000);
        emailForm.click();
        wait(1000);
        emailForm.sendKeys("test1.dianin@gmail.com");
        wait(1000);
        passwordForm.click();
        wait(1000);
        passwordForm.sendKeys("Apyz5EEoRT1f488h5Kp1");
    }
}
