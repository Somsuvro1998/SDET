package vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.CampaignPlusSignPage;
import POM.CreateCampaignPage;
import POM.CreateProductPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPlusSignPage;
import POM.ProductValidationPage;
import POM.ProductWindowPage;
import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(generic_utilities.ExtentImplementation.class)
public class CreateCampaignWithProductTest2 extends BaseClass {
@Test
	public void CreateCampaignWithProductTest1() throws Throwable {
/*WebDriver driver;
File_Utility flib=new File_Utility();
String BROWSER = flib.getKeyAndValueData("browser");
if(BROWSER.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(BROWSER.equalsIgnoreCase("edge"))
{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
}
else
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}*/



/*String USERNAME = flib.getKeyAndValueData("username");
String PASSWORD = flib.getKeyAndValueData("password");
String URL = flib.getKeyAndValueData("url");
driver.get(URL);

LoginPage login=new LoginPage(driver);
login.LoginToApplication(USERNAME, PASSWORD);

Thread.sleep(3000);*/
    

WebDriver_Utility wlib=new WebDriver_Utility();
wlib.maximizingwindow(driver);
HomePage hp=new HomePage(driver);
hp.clickOnProduct();

ProductPlusSignPage plus=new ProductPlusSignPage(driver);
plus.clickProductPlus();

CreateProductPage cp=new CreateProductPage(driver);
Java_Utility jlib=new Java_Utility();
int ranNo = jlib.getRandomNum();

Excel_Utility elib=new Excel_Utility();
String product = elib.getDataFormatterData("Organization",1,1)+ranNo;

cp.ProductName(product);
cp.clickOnSaveButton();

ProductValidationPage pv=new ProductValidationPage(driver);
String actData = pv.ProdValidate();
if(actData.contains(product))
{
	System.out.println("Product Created");
}
else
{
	System.out.println("Product not created");
}
hp.clickOnCampaigns(driver);;
CampaignPlusSignPage campplus=new CampaignPlusSignPage(driver);
campplus.clickOnCampaignPlusSign();
ProductWindowPage pw=new ProductWindowPage(driver);
pw.clickOnPlusSign(driver, wlib);
pw.enterProductName(product);
pw.clickSearchButton();
pw.selectProduct(driver,product, wlib);
CreateCampaignPage cc=new CreateCampaignPage(driver);
String campaign = elib.getDataFormatterData("Organization",0,0)+ranNo;
cc.campaignName(campaign);
cc.clickOnSave();
//hp.clickOnSignOut(driver);



	}

}
