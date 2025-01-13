package projectActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
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
    	WebElement logo_element = driver.findElement(By.xpath("//img[contains(@src,'login/logo')]"));
    	String url_header_image = logo_element.getDomAttribute("src");
    	System.out.println("URL of header image is : "+url_header_image);
    	
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
      

}
