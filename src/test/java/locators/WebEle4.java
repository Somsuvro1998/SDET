package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebEle4 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
		//System.out.println(searchbar.getAriaRole());
		//System.out.println(searchbar.getDomAttribute("aria-label"));
		WebElement mobiles = driver.findElement(By.xpath("//a[text()='Mobiles']"));
//		System.out.println(mobiles.getDomProperty("textContent"));
//		System.out.println(mobiles.getDomProperty("tagName"));
		WebElement logo = driver.findElement(By.xpath("//a[@class='nav-logo-link nav-progressive-attribute']"));
        System.out.println(logo.getAccessibleName());
	}

}
