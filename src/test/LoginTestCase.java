package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// step1 - Launch Chrome Browser and open SimpliLearn Website

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		// step2: maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// step3: Click on he Login Link on top right corner
		System.out.println("The title of the page is " + driver.getTitle());

		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		String location = loginLink.getAttribute("href");
		System.out.println("The link will take you to " + location);
		loginLink.click();

		// WebElement Title = driver.findElement(By.tagName("title"));
		// System.out.println("Title of the page is: " +Title.getText());

		// step4: Enter the user name
		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("abc@xyz.com");

		// step5: Enter the Password

		WebElement password = driver.findElement(By.name("user_pwd"));
		password.sendKeys("Abc@12345");

		// Step:6 Click on remember me check box
		WebElement chkBox = driver.findElement(By.className("rememberMe"));
		chkBox.click();

		// Step7 Click on the Login Button
		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();

		// Step8: validate the Login was unsuccessful

		WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
		String expErrorMsg = "The email or password you have entered is invalid.";
		if (error.isDisplayed() && errorMsg.equals(expErrorMsg)) {
			System.out.println("TC Passed");
		} else {
			System.out.println("TC failed");
		}
		// System.out.println("the error message is " +errorMsg);

		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of Links are:" + AllLinks.size());

		for (WebElement links : AllLinks) {
			System.out.println(links.getAttribute("href"));

		}

		// step9: Close the Browser
		driver.close();

	}

}
