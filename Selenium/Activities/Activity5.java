package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is : "+title);
		
		WebElement  checkbox = driver.findElement(By.id("checkbox"));
		System.out.println("Is checkbox displayed : "+checkbox.isDisplayed());
		
		driver.findElement(By.xpath("//button[contains(text(),'Toggle Checkbox')]")).click();
		
		System.out.println("Is checkbox displayed : "+checkbox.isDisplayed());
		
		driver.quit();
		
	}

}
