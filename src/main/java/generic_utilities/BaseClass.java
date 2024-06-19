package generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public File_Utility flib=new File_Utility();
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite","SanitySuite"})
	public void beforeSuite()
	{
		System.out.println("Database connection established");
	}
	@BeforeTest(groups={"SmokeSuite","RegressionSuite","SanitySuite"})
	public void beforeTest()
	{
		System.out.println("Parallel Execution starts");
	}
	@BeforeClass(groups={"SmokeSuite","RegressionSuite","SanitySuite"})
	public void beforeClass() throws Throwable
	{
		File_Utility flib=new File_Utility();
	String BROWSER = flib.getKeyAndValueData("browser");
	System.out.println("Launching Browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
	else
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	//driver=new EdgeDriver();
	
	sdriver=driver;	
}
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite","SanitySuite"})
public void beforeMethod() throws Throwable
{
		File_Utility flib=new File_Utility();
	String URL = flib.getKeyAndValueData("url");
	String USERNAME = flib.getKeyAndValueData("username");
	String PASSWORD = flib.getKeyAndValueData("password");
	driver.get(URL);
	Thread.sleep(3000);
	
	LoginPage lp=new LoginPage(driver);
	lp.LoginToApplication(USERNAME, PASSWORD);
	System.out.println("Login to Application");
}
	@AfterMethod(groups={"SmokeSuite","RegressionSuite","SanitySuite"})
	public void afterMethod()
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnSignOut(driver);
		System.out.println("Logging out of Application");
	}
	@AfterClass(groups={"SmokeSuite","RegressionSuite","SanitySuite"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("Closing Browser");
	}
	@AfterTest(groups={"SmokeSuite","RegressionSuite","SanitySuite"})
	public void afterTest()
	{
		System.out.println("Parallel Execution ends");
	}
	@AfterSuite(groups={"SmokeSuite","RegressionSuite","SanitySuite"})
	public void afterSuite()
	{
	System.out.println("Database Connection closed");	
	}
}
