package co.edurekatraining;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTestSoftAssertion {
	
	//create reference variable for WebDriver
	WebDriver driver;
	
	@BeforeMethod
	public void initialiseBrowser()
	{
		//setup the path for the browser
		System.setProperty("webdriver.gecko.driver", "..\\SeleniumAutomation\\Drivers\\geckodriver.exe");
		
		//Launching the light and empty browser
		driver = new FirefoxDriver();
		
		//Launching the facebook.com on browser
		driver.get("https://www.facebook.com/");
		
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Maximize the window
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void facebookTest() throws InterruptedException
	{
		//capture the email WebElement
		WebElement email = driver.findElement(By.id("email"));
		
		//Sending values to email field
		email.sendKeys("abc@gmail.com");
		
		//Add Java wait 
		Thread.sleep(9000);
		
		//Verifying password field is enabled
		WebElement password = driver.findElement(By.id("pass"));
		
		Assert.assertEquals(true, email.isEnabled());
		System.out.println("Password field is enabled");
		
		password.sendKeys("mumbai@123");
		
		Thread.sleep(5000);
		
		//Click on login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@name ='login']"));
		
		loginButton.click();
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
  
}
