package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		String title = driver.getTitle();
		System.out.println("Title of the page is :"+title);
		
		WebElement textField = driver.findElement(By.xpath("//input[@id='textInput']"));
		System.out.println("Is text field enabled : "+textField.isEnabled());
		
		driver.findElement(By.xpath("//button[@id='textInputButton']")).click();
		System.out.println("Is text field enabled : "+textField.isEnabled());
		
		textField.sendKeys("Example text");
	    System.out.println(textField.getDomProperty("value"));
		
		driver.quit();
		
	}

}
