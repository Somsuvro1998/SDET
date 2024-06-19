package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utilities.WebDriver_Utility;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[text()='Campaigns']")
    private WebElement campaignLink;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationLink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
     private WebElement administrationLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutButton;
	
	//getter methods
	public WebElement moreLInk()
	{
		return moreLink;
	}
	public WebElement campaignLink()
	{
		return campaignLink;
	}
	public WebElement organizationLink()
	{
		return organizationLink;
	}
	public WebElement productLink()
	{
		return productLink;
	}
	public WebElement administrationLink()
	{
		return administrationLink;
	}
	public WebElement signOutButton()
	{
		return signOutButton;
	}

	//business libraries
	public void clickOnMore()
	{
		moreLink.click();
	}
	public void clickOnCampaigns(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.mouseOverElement(driver, moreLink);
		campaignLink.click();	
	}
	public void clickOnOrganization()
	{
		organizationLink.click();
	}
	public void clickOnProduct()
	{
		productLink.click();
	}
	public void clickOnAdministration()
	{
		administrationLink.click();
	}
	public void clickOnSignOut(WebDriver driver)
	{
		WebDriver_Utility wlib=new 	WebDriver_Utility();
		wlib.mouseOverElement(driver, administrationLink);
		signOutButton.click();
	}
	
	
}
	
