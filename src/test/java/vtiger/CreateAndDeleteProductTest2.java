package vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.CreateProductPage;
import POM.DeleteProductPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPlusSignPage;
import POM.ProductValidationPage;
import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_Utility;
import generic_utilities.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(generic_utilities.ExtentImplementation.class)
public class CreateAndDeleteProductTest2 extends BaseClass {

@Test
	public void CreateAndDeleteProductTest() throws Throwable {
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

WebDriver_Utility wlib=new WebDriver_Utility();
wlib.maximizingwindow(driver);

/*String USERNAME = flib.getKeyAndValueData("username");
String PASSWORD = flib.getKeyAndValueData("password");
String URL = flib.getKeyAndValueData("url");
driver.get(URL);
LoginPage login=new LoginPage(driver);
login.LoginToApplication(USERNAME, PASSWORD);*/

Thread.sleep(3000);


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
//if(actData.contains(product))
//{
//	System.out.println("Product Created");
//}
//else
//{
//	System.out.println("Product not created");
//}
Assert.assertEquals(actData,product);
//Deleting product
DeleteProductPage dp=new DeleteProductPage(driver);
dp.clickProductList();
Thread.sleep(3000);
driver.findElement(By.xpath("(//a[text()='"+product+"']/preceding::td/input)[41]")).click();
dp.clickDeleteButton();
wlib.alertAccept(driver);
//dp.deleteProduct(driver,product,wlib);
dp.validation(driver, product);
//hp.clickOnSignOut(driver);







	}

}
