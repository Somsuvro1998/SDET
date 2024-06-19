package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import POM.LoginPage;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest {

	public static void main(String[] args) throws Throwable {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();

File_Utility flib=new File_Utility();
String URL = flib.getKeyAndValueData("url");
String USERNAME = flib.getKeyAndValueData("username");
String PASSWORD = flib.getKeyAndValueData("password");
driver.get(URL);

//business logic
LoginPage login=new LoginPage(driver);
login.LoginToApplication(USERNAME, PASSWORD);

WebElement moreLink = driver.findElement(By.xpath("//a[text()='More']"));
Actions act=new Actions(driver);
act.moveToElement(moreLink).perform();
driver.findElement(By.linkText("Campaigns")).click();

driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();

Java_Utility jlib=new Java_Utility();
int ranNo = jlib.getRandomNum();

Excel_Utility elib=new Excel_Utility();
String campaign = elib.getDataFormatterData("Organization",0,0)+ranNo;
driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaign);

driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

//validation
String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
if(actData.contains(campaign))
{
	System.out.println("Campaign created");
}
else
{
	System.out.println("Campaign not created");
}

Thread.sleep(3000);

//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.linkText("Sign Out")).click();

WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
act.moveToElement(administrator).perform();
driver.findElement(By.linkText("Sign Out")).click();

driver.close();

	}

}
