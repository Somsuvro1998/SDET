package vtiger;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct2 {

	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/index.php?action=Login&module=Users");
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();
Random ran=new Random();
int ranNum=ran.nextInt(1000);
String product="CRM"+ranNum;
driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(product);
driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

//verification
String prd = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
if(prd.contains(product))
{
	System.out.println("Product is created");
}
else
{
	System.out.println("product is not created");
}

//Adding product into a campaign
driver.findElement(By.xpath("//a[.='More']")).click();
driver.findElement(By.xpath("//a[.='Campaigns']")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

Set<String> win = driver.getWindowHandles();
Iterator<String> allwin = win.iterator();



while(allwin.hasNext())
{
	String winText = allwin.next();
	driver.switchTo().window(winText);
	String title = driver.getTitle();
	
	if(title.contains("Products&action"))
	{
		break;
	}
}
driver.findElement(By.name("search_text")).sendKeys(product);
driver.findElement(By.xpath("//input[@name='search']")).click();
driver.findElement(By.xpath("//a[.='"+product+"']")).click();

Set<String> win1 = driver.getWindowHandles();
Iterator<String> allwin1 = win1.iterator();

while(allwin1.hasNext())
{
	String winText1 = allwin1.next();
	driver.switchTo().window(winText1);
	String title1 = driver.getTitle();
	
	if(title1.contains("Campaigns&action"))
	{
		break;
	}
	}
String campaign="Mrketing"+ranNum;
driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaign);
driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
System.out.println("campaign with product created");
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[.='Sign Out']")).click();



	}

}

