package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/");

		// maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement newTab = driver.findElement(By.id("tabButton"));

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window is: " + parentWindow);
		newTab.click();

		Set<String> AllWin = driver.getWindowHandles();
		String childWin = "";

		for (String win : AllWin) {
			System.out.println("The window ID is: " + win);

			if (!win.equals(parentWindow)) {
				childWin = win;
			}
		}
		System.out.println("Child window is: " + childWin);

		// start working on next window
		driver.switchTo().window(childWin);
		
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in the child window is " + childHeader.getText());
		driver.close();

		driver.switchTo().window(parentWindow);
		WebElement newWindow = driver.findElement(By.id("windowButton"));
		newWindow.click();

		AllWin = driver.getWindowHandles();

		for (String win : AllWin) {
			System.out.println("The window ID is: " + win);
			if (!win.equals(parentWindow)) {
				childWin = win;
			}
		}
		System.out.println("Chuld window is: " + childWin);
		driver.switchTo().window(childWin);
		 childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in the child window is " + childHeader.getText());
		driver.quit();

	}

}
