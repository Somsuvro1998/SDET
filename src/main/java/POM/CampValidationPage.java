package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampValidationPage {
	//initialization (making the elements of the page ready for the actions which will be performed on them)
	public CampValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement campValidation;
	
	//getter method
	public WebElement getCampValidation()
	{
		return campValidation;
	}
	//business logic
	public String campValidate()
	{
		return campValidation.getText();
	}

}
