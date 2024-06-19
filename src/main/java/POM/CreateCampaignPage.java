package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	//initialization
public CreateCampaignPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

//declaration
@FindBy(name="campaignname")
private WebElement campaignTextField;

@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveButton;

//getter methods
public WebElement campaignTextField()
{
	return campaignTextField;
}

public WebElement saveButton()
{
	return saveButton;
}

//business logic
public void campaignName(String name)
{
	campaignTextField.sendKeys(name);
}
public void clickOnSave()
{
	saveButton.click();
}


}
