package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBlogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step1 - Launch Chrome Browser and open SimpliLearn Website
		
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		// maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//Enter the user name
				WebElement userName = driver.findElement(By.name("email"));
				userName.sendKeys("abc@xyz.com");
				
				//Enter the Password
				
				WebElement password = driver.findElement(By.name("pass"));
				password.sendKeys("Abc@12345");
				
				//Click on the Login Button
				WebElement loginBtn = driver.findElement(By.name("login"));
				loginBtn.click();

	}
}
