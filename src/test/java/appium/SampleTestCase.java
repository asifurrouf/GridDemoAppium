package appium;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;

public class SampleTestCase extends AppiumGrid {

	@Test
	public void sampeTest() {

		// to slow down execution
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
