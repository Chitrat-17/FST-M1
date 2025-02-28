package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity(".ui.ConversationListActivity");

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
	}
	
	@Test
	public void test() {
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Start new conversation"))).click();
		driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("18282832912");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
		driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
		String messageTextSent = driver.findElement(AppiumBy.id("message_text")).getText();
	    Assert.assertEquals(messageTextSent, "Hello from Appium");
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
