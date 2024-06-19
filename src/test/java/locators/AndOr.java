package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AndOr {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888");
		Thread.sleep(3000);
		//using AND Operator
		driver.findElement(By.xpath("//input[@type='text' and @name='user_name']")).sendKeys("admin");
		//using or operator
		driver.findElement(By.xpath("//input[@type='password' or @name='user_']")).sendKeys("admin");
		
		
	}

}
