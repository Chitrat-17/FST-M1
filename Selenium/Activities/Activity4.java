package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/target-practice");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is : "+title);
		
		String thirdHeaderText  = driver.findElement(By.xpath("//h3[contains(text(),'#3')]")).getText();
		System.out.println("Text of Heading 3 is : "+thirdHeaderText);
		
		Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(),'#5')]")).getCssValue("color"));
		System.out.println("Color as RGB: " + fifthHeaderColor.asRgb());
        System.out.println("Color as hexcode: " + fifthHeaderColor.asHex());
        
        
        String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
		System.out.println("purpleButtonClass :"+purpleButtonClass);
		
		String slateButtonText  = driver.findElement(By.xpath("//button[contains(@class,'slate')]")).getText();
		System.out.println("slate_button_text is : "+slateButtonText );
		
		driver.quit();
	
	}

}
