package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest1 {
	
@Test(groups="SmokeSuite")
	public  void createOrganizationTest() throws Throwable {
		File_Utility flib=new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		WebDriver driver;
		String BROWSER = flib.getKeyAndValueData("browser");
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("EDGE"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		wlib.maximizingwindow(driver);
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
		driver.get(URL);
		
		LoginPage login=new LoginPage(driver);
		login.LoginToApplication(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganization();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Java_Utility jlib=new Java_Utility();
		int ranNo = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String organization = elib.getDataFormatterData("Organization",2,2)+ranNo;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organization);
		driver.findElement(By.id("phone")).sendKeys("468654684");
		driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(3000);
		String orgval = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(orgval.contains(organization))
		{
			System.out.println("organization is created");
		}
		else
		{
			System.out.println("organization not created");
		}
		hp.clickOnSignOut(driver);
		
		
		
		
	}

}
