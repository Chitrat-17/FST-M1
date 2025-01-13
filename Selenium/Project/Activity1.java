package projectActivities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

	 WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeClass() {
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("http://alchemy.hguy.co/orangehrm");
	    }
    
	    @Test
	    public void method() {
	    	String title = driver.getTitle();
	    	System.out.println("Title of the page : "+title);
	    	Assert.assertEquals(title, "OrangeHRM");
	    	System.out.println("Tile of the page is matching");
	    	
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	  
}
