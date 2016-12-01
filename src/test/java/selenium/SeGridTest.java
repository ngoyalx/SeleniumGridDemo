package selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 *  To test Selenium Grid functionality with Mac/Windows m/c
 *	Simple plain Selenium web class, run this class using testng.xml
 *	create different mozilla, chrome node on window and mac machines
 */
public class SeGridTest {
	WebDriver driver = null;
	private StringBuffer verificationErrors = new StringBuffer();

	@Parameters({ "platform", "browser" })
	@BeforeTest(alwaysRun = true)
	public void setup(String platform, String browser) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		// Platforms
		if (platform.equalsIgnoreCase("Windows"))
			caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);

		if (platform.equalsIgnoreCase("MAC"))
			caps.setPlatform(org.openqa.selenium.Platform.MAC);

		// Browsers
		if (browser.equalsIgnoreCase("Internet Explorer"))
			caps = DesiredCapabilities.internetExplorer();

		if (browser.equalsIgnoreCase("Firefox"))
			caps = DesiredCapabilities.firefox();

		if (browser.equalsIgnoreCase("Chrome"))
			caps = DesiredCapabilities.chrome();

		if (browser.equalsIgnoreCase("Safari"))
			caps = DesiredCapabilities.safari();

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

		// Open the BMI Calculator Application
		driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");

	}

	@Test(description = "Test Bmi Calculator")
	public void testBmiCalculator() throws InterruptedException {
		WebElement height = driver.findElement(By.name("heightCMS"));
		height.sendKeys("181");

		WebElement weight = driver.findElement(By.name("weightKg"));
		weight.sendKeys("80");
		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();

		try {

			WebElement bmi = driver.findElement(By.name("bmi"));
			assertEquals(bmi.getAttribute("value"), "24.4");

			WebElement bmi_category = driver.findElement(By.name("bmi_category"));
			assertEquals(bmi_category.getAttribute("value"), "Normal");

		} catch (Error e) {

			// Capture and append Exceptions/Errors
			verificationErrors.append(e.toString());
		}
	}

	@AfterTest
	public void afterTest() {
		// Close the browser
		driver.quit();

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}
}