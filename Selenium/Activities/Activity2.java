package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/login-form/");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is : "+title);
		

		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.name("password")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		String message = driver.findElement(By.tagName("h1")).getText();
        System.out.println(message);
		
		driver.quit();
	}

}
