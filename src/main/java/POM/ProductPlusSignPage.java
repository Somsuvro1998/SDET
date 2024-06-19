package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPlusSignPage {

	//initialization
	public ProductPlusSignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productPlus;

	//getterMethods
	public WebElement getProductPlus() {
		return productPlus;
	}
	

	//BusinessLogics
	/**
	 * THis method is used to click on Campaign(+)Sign
	 */
	public void clickProductPlus()
	{
		productPlus.click();
	}
}
