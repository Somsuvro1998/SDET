package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebEle3 {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
		System.out.println(searchbar.getAttribute("class"));
		System.out.println(searchbar.getAttribute("src")); //no src attribute present so it returned null
		WebElement todaysdeals = driver.findElement(By.partialLinkText("Today's Deals"));
		System.out.println(todaysdeals.getAttribute("tabindex"));
		System.out.println(todaysdeals.getTagName());
		searchbar.sendKeys("iphone");
		searchbar.submit();
		String price = driver.findElement(By.xpath("(//span[text()='49,499'])[1]")).getText();
		System.out.println(price);
		
		driver.close();
		}

}
