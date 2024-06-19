package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	 public CreateProductPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }


	 @FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebElement getCreateProductName()
	{
		return productName;
	}
	
	public WebElement getSaveButton()
	{
		return saveButton;
	}

	public void ProductName(String Name)
	{
		productName.sendKeys(Name);	
	}
	public void clickOnSaveButton()
	{
		saveButton.click();;
	}
	
		
	}
	
