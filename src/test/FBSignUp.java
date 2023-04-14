package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		// maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//click on create new account
		WebElement signUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signUp.click();
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First name']"));
		firstName.sendKeys("Rui");
		WebElement surName = driver.findElement(By.xpath("//input[@name='lastname']"));
		surName.sendKeys("Sha");
		WebElement mobNo = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		mobNo.sendKeys("123456789");
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		password.sendKeys("P@ssw0rd!");
		
		
		WebElement selectedDay = driver.findElement(By.xpath("//select[@title ='Day']/option[@selected='1']"));
		System.out.println("The selected day is: " +selectedDay.getText());
		
		WebElement day = driver.findElement(By.xpath("//select[@title ='Day']"));
		Select dday = new Select(day);
		dday.selectByVisibleText("15");
		
		WebElement month = driver.findElement(By.xpath("//select[@title ='Month']"));
		Select dmonth = new Select(month);
		dmonth.selectByValue("4");
		
		WebElement year = driver.findElement(By.xpath("//select[@title ='Year']"));
		Select dyear = new Select(year);
		dyear.selectByVisibleText("1997");
		
		List<WebElement> list = driver.findElements(By.xpath("//select[@title ='Month']/option"));
		for (WebElement Month: list) {
			System.out.println(Month.getText());
		}
		
		/*WebElement female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		female.click();*/
		
        String Gender = "Female";
		
		/*String dummyXpath = "//label[text()='placeholder']";
		String newXpath = dummyXpath.replace("placeholder", Gender);*/
		
		String newXpath = "//label[text()='" + Gender + "']";
		
		WebElement genderElem = driver.findElement(By.xpath(newXpath));
		genderElem.click();
		
			
		
		
		
		
		
		
		
		
		

	}

}
