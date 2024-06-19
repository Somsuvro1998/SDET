package vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.CampValidationPage;
import POM.CampaignPlusSignPage;
import POM.CreateCampaignPage;
import POM.HomePage;
import POM.LoginPage;
import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(generic_utilities.ExtentImplementation.class)
public class CreateCampaignTest2 extends BaseClass {
//@Test(retryAnalyzer=generic_utilities.RetryImplementation.class)
	@Test
	public void CreateCanpaignTest() throws Throwable {
/*WebDriver driver;
File_Utility flib=new File_Utility();
String BROWSER = flib.getKeyAndValueData("browser");
if(BROWSER.equalsIgnoreCase("Chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(BROWSER.equalsIgnoreCase("Edge"))
{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
}
else
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}*/
WebDriver_Utility wlib=new WebDriver_Utility();
wlib.implicit_wait(driver);
/*String URL=flib.getKeyAndValueData("url");
String USERNAME = flib.getKeyAndValueData("username");
String PASSWORD = flib.getKeyAndValueData("password");
driver.get(URL);
LoginPage login=new LoginPage(driver);
login.LoginToApplication(USERNAME, PASSWORD);*/

Thread.sleep(3000);


wlib.maximizingwindow(driver);
HomePage hp=new HomePage(driver);
hp.clickOnCampaigns(driver);

CampaignPlusSignPage plus=new CampaignPlusSignPage(driver);
plus.clickOnCampaignPlusSign();

CreateCampaignPage camp=new CreateCampaignPage(driver);
Java_Utility jlib=new Java_Utility();
int ranNo = jlib.getRandomNum();
Excel_Utility elib=new Excel_Utility();
String campname = elib.getDataFormatterData("Organization",0,0)+ranNo;
camp.campaignName(campname);
//Assert.assertEquals(false, true);
camp.clickOnSave();

CampValidationPage val=new CampValidationPage(driver);
String actData = val.campValidate();
//if(actData.contains(campname))
//{
//	System.out.println("Campaign created");
//}
//else
//{
//	System.out.println("Campaign not created");
//}

//Assert.assertEquals(actData,campname);
SoftAssert soft=new SoftAssert();
soft.assertEquals(actData, campname);
soft.assertAll();
//hp.clickOnSignOut(driver);
	

	}

}
