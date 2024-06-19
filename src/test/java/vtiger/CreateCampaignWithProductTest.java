package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.maximizingwindow(driver);
		
		File_Utility flib=new File_Utility();
	String USERNAME = flib.getKeyAndValueData("username");
	String PASSWORD = flib.getKeyAndValueData("password");
	String URL = flib.getKeyAndValueData("url");
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	Java_Utility jlib=new Java_Utility();
	int ranNo = jlib.getRandomNum();
	
	Excel_Utility elib=new Excel_Utility();
	String product = elib.getDataFormatterData("Organization", 1, 1)+ranNo;
	driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(product);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	String prdval = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	if(prdval.contains(product))
	{
		System.out.println("Product created");
	}
	else
	{
		System.out.println("Product not created");
	}
	driver.findElement(By.xpath("//a[.='More']")).click();
	driver.findElement(By.xpath("//a[.='Campaigns']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	
	wlib.windowSwitching(driver,"Products&action");
	driver.findElement(By.name("search_text")).sendKeys(product);
	driver.findElement(By.xpath("//input[@name='search']")).click();
	driver.findElement(By.xpath("//a[.='"+product+"']")).click();
	
	wlib.windowSwitching(driver,"Campaigns&action");
	
    String campaign = elib.getDataFormatterData("Organization",0,0)+ranNo;
    driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaign);
    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
    System.out.println("campaign with product created");
    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	
	
	
		
	}

}
