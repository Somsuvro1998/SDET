package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebEle2 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(3000);
		WebElement radiobutton = driver.findElement(By.xpath("(//input[@class=\"_8esa\"])[2]"));
		radiobutton.click();
		if(radiobutton.isSelected())
		{
			System.out.println("radiobutton is selected");
		}
		else
		{
			System.out.println("radiobutton is not selected");
		}
		driver.close();
		
		
	}

}
