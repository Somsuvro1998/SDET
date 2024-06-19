package vtiger;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
//To avoid Duplicate
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
		String product="CRM"+ranNum;
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(product);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String prd = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		if(prd.contains(product))
		{
			System.out.println("Product Created");
		}
		else
		{
			System.out.println("Product not created");
		}
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
         
		Set<String> allwin = driver.getWindowHandles();
		
		Iterator<String> win = allwin.iterator();
		while(win.hasNext())
		{
			String winText = win.next();
			driver.switchTo().window(winText);
			String title1 = driver.getTitle();
			if(title1.contains("Products&action"))
			{
				break;
			}
		}
driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(product);
driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

//dynamic xpath
driver.findElement(By.xpath("//a[text()='"+product+"']")).click();

Set<String> allwin1 = driver.getWindowHandles();
Iterator<String> win1 = allwin1.iterator();
while(win1.hasNext())
{
	String winText1 = win1.next();
	driver.switchTo().window(winText1);
	String title2 = driver.getTitle();
	if(title2.contains("Campaigns&action"))
	{
		break;
	}
}
String campaign="Marketing"+ranNum;
driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaign);
driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
System.out.println("Campaign with Product is created");
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
