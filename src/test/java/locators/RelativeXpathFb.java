package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeXpathFb {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		 
		//xpath by Attribute
		//syntax:- //tagname[@Attributename='Attribute value']
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("username");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("password");
		
		//xpath by VisibleText
		//syntax:- //tagname[text()='VisibleText']
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		
		driver.navigate().back();
		
		//xpath by contains VisibleText
		//syntax:- //tagname[contains(text(),'Partially Visible Text')]
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		
		Thread.sleep(3000);
		
		//xpath by contains Atrribute
		//syntax:- //tagname[contains(@Attributename,'Partial Attribute value')]
		driver.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or')]")).sendKeys("username");
		
		driver.close();
	}

}
