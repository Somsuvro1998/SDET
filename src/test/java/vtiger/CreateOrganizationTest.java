package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		File_Utility flib=new File_Utility();
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Java_Utility jlib=new Java_Utility();
		int ranno = jlib.getRandomNum();
		Excel_Utility elib=new Excel_Utility();
		 String org = elib.getDataFormatterData("Organization",0,0)+ranno;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		Thread.sleep(3000);
		String orgval = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(orgval.contains(org))
		{
			System.out.println("Product is created");
		}
		else
		{
			System.out.println("product not created");
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
