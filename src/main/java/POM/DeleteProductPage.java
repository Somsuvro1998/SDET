package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriver_Utility;

public class DeleteProductPage {
	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productList;
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	private WebElement deleteButton;
	
	//getter methods
	public WebElement getProductList()
	{
		return productList;
	}
	public WebElement getDeleteButton()
	{
		return deleteButton;
	}
	//Business logic
	public void clickProductList()
	{
		productList.click();
	}
	public void clickDeleteButton()
	{
		deleteButton.click();
	}
	public void deleteProduct(WebDriver driver, String name,WebDriver_Utility wlib)
	{
		driver.findElement(By.xpath("(//a[text()='"+name+"'])[2]/../preceding-sibling::td/input")).click();
		deleteButton.click();
		wlib.alertAccept(driver);
	}
	
	//validation
	public void validation(WebDriver driver,String productname)
	{
		
	 List<WebElement> prdlist = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
	 boolean flag=false;
	 for(WebElement prdval:prdlist)
	 {
		 String actData = prdval.getText();
		 if(actData.contains(productname))
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

}
}
