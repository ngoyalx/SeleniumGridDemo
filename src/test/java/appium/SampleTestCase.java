package appium;

import java.sql.Connection;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class SampleTestCase extends AppiumDriverBase {

	// Test Annotation changes any java function to TestNG test case
	@Test
	public void sampeTest() {

		// click on Accessibility link
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility")));
		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();

		// click on 'Accessibility Node Querying' link
		wait.until(
				ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility Node Querying")));
		driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();

		// back
		driver.navigate().back();

		// back
		driver.navigate().back();
	}

}
