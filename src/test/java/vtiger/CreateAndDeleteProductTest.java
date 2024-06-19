package vtiger;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndDeleteProductTest {

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
	driver.findElement(By.xpath("(//a[.='Products'])[1]")).click();
	driver.findElement(By.xpath("(//a[.='"+product+"']/preceding::td/input)[31]")).click();
	driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
	wlib.alertAccept(driver);
	
	//Validation
	List<WebElement> prdlist = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
	boolean flag=false;
	for(WebElement prd:prdlist)
	{
		String actData = prd.getText();
		if(actData.contains(product))
		{
			flag=true;
			break;
		}
	}
	
	if(flag)
	{
		System.out.println("Product deleted");
	}
	else
	{
		System.out.println("Product not deleted");
	}
	  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	  driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	  wlib.alertAccept(driver);
	  driver.close();
	}
	

}
