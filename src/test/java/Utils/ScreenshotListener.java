package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class ScreenshotListener extends TestListenerAdapter{

    WebDriver driver;

    private void takeScreenshotToFile (WebDriver driver, File file)
    {

        try  (FileOutputStream screenShotStream = new FileOutputStream(file)) {
            screenShotStream.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Can't write to " + file.getAbsolutePath());
        }
    }

    private boolean createFile (File file)
    {
        boolean createdFile = false;
        if (file.exists()) createdFile = true;
        File parentDirectory = new File(file.getParent());
         if (parentDirectory.exists()||parentDirectory.mkdirs())
         {
             try {
                 createdFile = file.createNewFile();
             } catch (IOException e) {
                 e.printStackTrace();
             }
 }


        return createdFile;
    }



    @Override
    public void onTestFailure(ITestResult iTestResult) {
     ITestContext context = iTestResult.getTestContext();
        WebDriver driver = (WebDriver)context.getAttribute("driver");

        Class clazz = iTestResult.getTestClass().getRealClass();
        Field field = null;
        try {
            field = clazz.getDeclaredField("driver");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        if (field!=null) field.setAccessible(true);

        String screenshotDirectory = System.setProperty("screenshotDirectory", "target/screenshots");
        String screenshtAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis() + "_" + iTestResult.getMethod().getMethodName() + ".png";
        File screenshot = new File(screenshtAbsolutePath);
        if (createFile(screenshot))
        {
            takeScreenshotToFile(driver, screenshot);
        }
    }
}
