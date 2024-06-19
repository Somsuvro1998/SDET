package practice_sleneium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utilities.Excel_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider2 {
	@Test(dataProvider="getData")
	public void dataProvider2(String orgname,String phno,String email) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys("orgname");
		driver.findElement(By.name("phone")).sendKeys("phno");
		driver.findElement(By.name("email1")).sendKeys("email");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(1000);
		driver.quit();

	}
		
//		@DataProvider
////		public Object[][] getData() throws Throwable 
////		{
////			Random ran=new Random();
////			int ranNo=ran.nextInt(1000);
////			Object[][] obj=new Object[3][3];
////			obj[0][0]="Org1"+ranNo;
////			obj[0][1]="8212245556";
////			obj[0][2]="abc@gmail.com";
////			
////			obj[1][0]="Org2"+ranNo;
////			obj[1][1]="57654645254";
////			obj[1][2]="jhg@gmail.com";
////			
////			obj[2][0]="Org3"+ranNo;
////			obj[2][1]="55454645254";
////			obj[2][2]="yug@gmail.com";
////
////			return obj;
////			
////		}	
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Excel_Utility elib=new Excel_Utility();
		Object[][] obj = elib.readMultipleData("Sheet1");
		return obj;
	}
	}


