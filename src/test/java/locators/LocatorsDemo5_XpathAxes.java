package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo5_XpathAxes {

	public static void main(String[] args) {
		

		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		//self
		String selfnode = driver.findElement(By.xpath("//a[contains(text(),'RailTel Corporation')]/self::a")).getText();
		System.out.println(selfnode);
		
		//parent
		String parent = driver.findElement(By.xpath("//a[contains(text(),'RailTel Corporation')]/parent::td")).getText();
		System.out.println(parent);
		
		//Child of ancestor node of self node because the self node doesn't have any child
		 List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'RailTel Corporation')]/ancestor::tr/child::td"));
		System.out.println("Number of children:"+childs.size());
		
		//Ancestor
		String Ancestor = driver.findElement(By.xpath("//a[contains(text(),'RailTel Corporation')]/ancestor::tr")).getText();
		System.out.println(Ancestor);
		
		//Descendant
		List<WebElement> descendant = driver.findElements(By.xpath("//a[contains(text(),'RailTel Corporation')]/ancestor::tr/descendant::*"));
		System.out.println("Number of Descendants:"+descendant.size());
		
		
		//Following of ancestor of selfnode
		List<WebElement> following = driver.findElements(By.xpath("//a[contains(text(),'RailTel Corporation')]/ancestor::tr/following::tr"));
		System.out.println("Number of following nodes of ancestor:"+following.size());
		
		//following-sibling of the ancester of the self node
		List<WebElement> followingsibling = driver.findElements(By.xpath("//a[contains(text(),'RailTel Corporation')]/ancestor::tr/following-sibling::tr"));
		System.out.println("Number of follwong siblings:"+followingsibling.size());
		
		
		//printing all from the table
//		String names = driver.findElement(By.xpath("//a[contains(text(),'RailTel Corporation')]/ancestor::tbody")).getText();
//		System.out.println(names);
		
		//Preceding 
		List<WebElement> preceding = driver.findElements(By.xpath("//a[contains(text(),'RailTel Corporation')]/ancestor::tr/preceding::tr"));
		System.out.println("Number of preceding nodes:"+preceding.size());
		
		//preceding sibling
		List<WebElement> precedingsibling = driver.findElements(By.xpath("//a[contains(text(),'RailTel Corporation')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Number of preceding siblings:"+precedingsibling.size());
		
		//clicking of facebook signupbutton
		
		
		
		driver.close();	}

}
