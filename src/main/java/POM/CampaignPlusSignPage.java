package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPlusSignPage {
	//initialization
	public CampaignPlusSignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement campaignPlusSign;
	
	//getter method
	public WebElement getCampaignPlusSign()
	{
		return campaignPlusSign;
	}
	
	//business logic
	public void clickOnCampaignPlusSign()
	{
		campaignPlusSign.click();
	}

}
