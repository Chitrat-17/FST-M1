package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1_GoogleTasks {

	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
		@Test(priority = 1)
		public void valid_login_test() {
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title"))).sendKeys("Complete Activity with Google Tasks");
			driver.findElement(AppiumBy.id("add_task_done")).click();
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title"))).sendKeys("Complete Activity with Google Keep");
			driver.findElement(AppiumBy.id("add_task_done")).click();
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title"))).sendKeys("Complete the second Activity Google Keep");
			driver.findElement(AppiumBy.id("add_task_done")).click();
			
			String text1 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.google.android.apps.tasks:id/task_data\"])[1]")).getText();
			String text2 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.google.android.apps.tasks:id/task_data\"])[2]")).getText();
			String text3 = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.google.android.apps.tasks:id/task_data\"])[3]")).getText();
			
			assertEquals(text1, "Complete Activity with Google Tasks");
			assertEquals(text1, "Complete Activity with Google Keep");
			assertEquals(text1, "Complete the second Activity Google Keep");
			
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}

}
