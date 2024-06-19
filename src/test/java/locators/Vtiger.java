package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger {

	public static void main(String[] args) throws Throwable {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get(" http://localhost:8888");
WebElement username = driver.findElement(By.name("user_name"));
username.sendKeys("user1");
Thread.sleep(10000);
username.clear();
//username.submit();
WebElement submit = driver.findElement(By.id("submitButton"));
submit.click();

	}

}
