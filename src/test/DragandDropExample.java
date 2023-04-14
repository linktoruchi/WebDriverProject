package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement From = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		
		WebElement To = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		
		Actions obj = new Actions(driver);
		/* obj.sendKeys(Keys.PAGE_DOWN)
		.sendKeys(Keys.CONTROL)
		.dragAndDrop(From,To)
		.build()
		.perform(); */
		
		//obj.dragAndDrop(From, To).build().perform();
		
		
		//for hover on the element
		obj.moveToElement(From).build().perform();
		Thread.sleep(2000);
		
		//for drag and drop
		obj.dragAndDrop(From, To).build().perform();
		
		
		
	}

}



