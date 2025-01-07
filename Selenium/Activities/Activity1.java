package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is : "+title);
		
		driver.findElement(By.linkText("About Us")).click();
		
		String new_title = driver.getTitle();
		System.out.println("New Title of the page is : "+new_title);
		
		driver.quit();
	}

}
