package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		String title = driver.getTitle();
		System.out.println("Title of the page is :"+title);
		
		driver.findElement(By.xpath("//input[contains(@name,'full-name')]")).sendKeys("Harry Potter");
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("harry@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,'event-date')]")).sendKeys("2025-06-26");
		driver.findElement(By.xpath("//textarea[contains(@id, 'additional-details')]")).sendKeys("NA");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
		System.out.println("message is :"+message);
		
		driver.quit();
		
	}

}
