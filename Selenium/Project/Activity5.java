package projectActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
    }

    @Test
    public void method() {
    	
        WebElement username_field = driver.findElement(By.xpath("//input[contains(@name,'Username')]"));
        WebElement password_field = driver.findElement(By.xpath("//input[contains(@name,'Password')]"));
        WebElement login_button = driver.findElement(By.xpath("//input[@name='Submit']"));
        
        username_field.sendKeys("orange");
        password_field.sendKeys("orangepassword123");
        login_button.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement my_info = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
        my_info.click();
        WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Edit']")));
        edit.click();

        WebElement firstName_field = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']"));
        WebElement lastName_field = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']"));
        WebElement gender = driver.findElement(By.xpath("//input[@id='personal_optGender_2']"));
        WebElement nationality_dropdown = driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        Select select = new Select(nationality_dropdown);
        
        firstName_field.clear();
        firstName_field.sendKeys("Mary");
        lastName_field.clear();
        lastName_field.sendKeys("John");
        gender.click();
        select.selectByVisibleText("Indian");

        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    	
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
