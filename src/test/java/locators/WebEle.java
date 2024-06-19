package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebEle {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.facebook.com/");
WebElement loc = driver.findElement(By.xpath("//a[contains(text(),'Facebook Lite')]"));

Point location = loc.getLocation();
System.out.println("X axis="+location.getX()); //x axis coordinates
System.out.println("Y axis="+location.getY());  //y axis coordinates

Dimension size = loc.getSize();	
//System.out.println(size);
System.out.println("height="+size.getHeight());
System.out.println("Width="+size.getWidth());

System.out.println("Rectangle class getRect() method");
Rectangle data = loc.getRect();
System.out.println("X axis="+data.getX());
System.out.println("Y axis="+data.getY());
System.out.println("height="+data.getHeight());
System.out.println("Width="+data.getWidth());



WebElement logo = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
if(logo.isDisplayed())
{
	System.out.println("Logo displayed");
}
else
{
	System.out.println("Logo is not displayed");
}
WebElement email = driver.findElement(By.name("email"));
if(email.isEnabled())
{
	email.sendKeys("abcd");
	email.submit();
	
}
else
{
	System.out.println("not enabled");
}
driver.findElement(By.linkText("Create new account")).click();
driver.close();
	
	
	
	}

}
