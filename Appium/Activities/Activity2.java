package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverURL, options);	
		driver.get("https://training-support.net");
		Thread.sleep(10);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
  @Test
  public void headingTest() throws InterruptedException {
	  String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Training Support\"]")).getText();
      System.out.println("Heading: " + pageHeading);
	  driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")).click();
	  Thread.sleep(20);
	  String pageTitle = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")).getText();
	  System.out.println("Heading : "+pageTitle);
  }
  
  @AfterClass
	public void tearDown() {
		driver.quit();
	}
}
