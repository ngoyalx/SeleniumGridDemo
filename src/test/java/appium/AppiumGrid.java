package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
 
public class AppiumGrid {
 
    protected AndroidDriver driver;
    protected WebDriverWait wait;
 
    //before Test Annotation makes a java function to run every time before a TestNG test case
    @BeforeTest
    protected void createAppiumDriver() throws MalformedURLException, InterruptedException {
 
    //relative path to apk file
   /* final File classpathRoot = new File(System.getProperty("user.dir"));
    final File appDir = new File(classpathRoot, "src/test/resources/apps/");
    final File app = new File(appDir, "ApiDemos-debug.apk");*/
    //final File app = new File(appDir, "selendroid-test-app-0.17.0.apk");  //to test hybrid app
 
    //setting up desired capability
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browserName", "");   // 'chrome' for browser and remove 'app' cap
    caps.setCapability("platform", "ANDROID");
    caps.setCapability("platformVersion", "6.0");
    caps.setCapability("deviceName", "ANDROID");
    //caps.setCapability("app", app.getAbsolutePath());
    caps.setCapability("app","/Users/sheetalsingh/Documents/workspace/SeleniumGridDemo/src/test/resources/apps/ApiDemos-debug.apk");
    //initializing driver object
    driver = new AndroidDriver(new URL("http://0.0.0.0:4441/wd/hub"), caps);
 
    //initializing explicit wait object
    wait = new WebDriverWait(driver, 10);
    }
 
    //After Test Annotation makes a java function to run every time after a TestNG test case
    @AfterTest
    public void afterTest(){
 
    //quit the driver
    driver.quit();
    }
 
}