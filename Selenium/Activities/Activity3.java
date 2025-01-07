package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/login-form/");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is : "+title);
		

		driver.findElement(By.xpath("//input[@name ='username']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@id ='password']")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
        System.out.println(message);
		
		driver.quit();
	}

}
