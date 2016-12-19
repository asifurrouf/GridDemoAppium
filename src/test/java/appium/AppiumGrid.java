package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;

public class AppiumGrid {

	protected AndroidDriver driver;
	protected WebDriverWait wait;

	@Parameters({ "platform", "version" })
	@BeforeTest
	protected void createAppiumDriver(String platform, String version)
			throws MalformedURLException, InterruptedException {

		// setting up desired capability
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "");
		caps.setCapability("platform", "ANDROID");
		caps.setCapability("deviceName", "ANDROID");

		if (platform.equalsIgnoreCase("mac")) {
			System.out.println("Mac Thread Name: " + Thread.currentThread().getId());
			caps.setCapability("app",
					"/Users/sheetalsingh/Documents/workspace/SeleniumGridDemo/src/test/resources/apps/ApiDemos-debug.apk");
			caps.setCapability("platformVersion", version);
		}

		if (platform.equalsIgnoreCase("window")) {
			System.out.println("Window Thread Name: " + Thread.currentThread().getId());
			caps.setCapability("app", "C:\\ApiDemos-debug.apk");
			caps.setCapability("platformVersion", version);
		}

		driver = new AndroidDriver(new URL("http://0.0.0.0:4444/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}