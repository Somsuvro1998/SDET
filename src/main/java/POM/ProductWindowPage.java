package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriver_Utility;

public class ProductWindowPage {

	public ProductWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productPlusButton;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement productSearchField;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchButton;
	
	//getter methods
	public WebElement getProductPlusButton()
	{
		return productPlusButton;
	}
	public WebElement getProductSearchField()
	{
		return productSearchField;
	}
	public WebElement getSearchButton()
	{
		return searchButton; 
	}
	
	//Business logic
	public void clickOnPlusSign(WebDriver driver, WebDriver_Utility wlib)
	{
		productPlusButton.click();
		wlib.windowSwitching(driver,"Products&action");
	}
	public void enterProductName(String name)
	{
		productSearchField.sendKeys(name);
	}
	public void clickSearchButton()
	{
		searchButton.click();
	}
	public void selectProduct(WebDriver driver,String name,WebDriver_Utility wlib)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		wlib.windowSwitching(driver,"Campaigns&action");
		
	}
	
}
