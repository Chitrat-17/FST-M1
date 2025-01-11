package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);

		WebElement simpleButton = driver.findElement(By.id("simple"));
		simpleButton.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message is : "+alert.getText());
		alert.accept();
		
		System.out.println(driver.findElement(By.id("result")).getText());
		
		driver.quit();
	}

}
