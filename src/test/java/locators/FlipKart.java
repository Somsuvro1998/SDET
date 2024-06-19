package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		Thread.sleep(3000);
		//Another syntax of writing xpath by VisibleText 
		//*[.='VisibleText']
		driver.findElement(By.xpath("(//*[.='Mobiles'])[5]")).click();
		Thread.sleep(3000);
		//driver.switchTo().
		//Another way of writing xpath expression, directly copying from the DOM
		driver.findElement(By.xpath("//img[@src=\"//static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/flipkart-plus_8d85f4.png\"]")).click();
	    Thread.sleep(3000);
     WebElement header = driver.findElement(By.xpath("//h1[@class=\"_3vKRL2\"]"));
     if(header.isDisplayed())
     {
    	 System.out.println("Script is working");
     }
     else
     {
    	 System.out.println("Script has problems");
     }
	    driver.close();
	
	}

}
