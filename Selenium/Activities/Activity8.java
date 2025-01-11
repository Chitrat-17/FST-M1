package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/mouse-events");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		WebElement cargoLockElement = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		Actions builder = new Actions(driver);
		builder.click(cargoLockElement).build().perform();		
		
		WebElement cargoTomlElement = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		builder.moveToElement(cargoTomlElement).click().build().perform();
		
		WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
		System.out.println("Confirmation message is : "+result.getText());
		
		WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
		builder.doubleClick(src).build().perform();
		
		WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
		builder.contextClick(target).build().perform();
		
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		System.out.println("Confirmation message is : "+result.getText());
		
		driver.quit();
	}

}
