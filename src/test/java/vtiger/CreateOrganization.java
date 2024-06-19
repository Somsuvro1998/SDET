package vtiger;



		import java.util.Random;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.edge.EdgeDriver;

		import io.github.bonigarcia.wdm.WebDriverManager;

		public class CreateOrganization {

			public static void main(String[] args) throws Throwable {
				
				WebDriverManager.edgedriver().setup();
				WebDriver driver=new EdgeDriver();
				
				driver.get("http://localhost:8888/");
				
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Random Approach To avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		String OrgName = "TestYantra"+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		String PrdName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(PrdName.contains(OrgName))
		{
			System.out.println("Organization Created");
		}
		else
		{
			System.out.println("Organization not created");
		}

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
			}

		

		
	}


