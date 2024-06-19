package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(3000);
		//maximizing statement
		driver.manage().window().maximize();
		Thread.sleep(3000);
	    
		driver.findElement(By.xpath("//input[@data-ved='0ahUKEwjy_r-R6MuEAxV3rlYBHaSoDcMQ4dUDCBw']/parent::*/parent::*/parent::*/div[1]")).sendKeys("cars");
		
		driver.close();
		
		WebDriver driver1=new EdgeDriver();
		driver1.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		//finding hello sign in from search text bar using following
		driver1.findElement(By.xpath("//input[@aria-label='Search Amazon.in']//following::span[contains(text(),'Hello, sign in')]")).click();
		
	//selecting mobiles from menu div tag
		//driver1.findElement(By.xpath("//div[@id='nav-xshop']/descendant::a[contains(text(),'Mobiles')]"));
		
	}
}
