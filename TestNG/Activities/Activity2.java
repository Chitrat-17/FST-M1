package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
	}
	@Test
	public void method1() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Selenium: Target Practice");
	}
	@Test
	public void method2() {
		WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
	}
	@Test(enabled = false)
	public void method3() {
		System.out.println("3");
	}
	@Test
	public void method4() {
		throw new SkipException("skip exeption thrown");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	

}
