package vtiger;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		
		String product="CRM"+ranNum;
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(product);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String prd = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		if(prd.contains(product))
		{
			System.out.println("Product Created");
		}
		else
		{
			System.out.println("Product not created");
		}
		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='"+product+"']/preceding::td/input)[31]")).click();
		//driver.findElement(By.xpath("//a[text()='"+product+"']/../preceding-sibling::td/input")); //if product is located in ascending or any other order
		driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
		//validation
//List<WebElement> prdlist = driver.findElements(By.xpath("//a[@title='Products']"));		
//Boolean flag=true;
//for(WebElement prd1:prdlist)
//{
//	
//}
		
		//validation
		List<WebElement> prdlist = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		boolean flag=false;
		for(WebElement prdval:prdlist)
		{
			String actData = prdval.getText();
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
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();	
	}
}
