package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	@FindBy(name="user_name")
	 private WebElement userTextField;
	
	@FindBys({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement userPasswordField;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	 private WebElement submitButton;
	
	//getter methods
//	public WebElement getUserTextField()
//	{
//		return userTextField;	
//	}
//	
//	public WebElement getUserPasswordField()
//	{
//		return userPasswordField;
//	}
//	
//	public WebElement getSubmitButton()
//    {
//	return submitButton;
//	}
	
	//Business logic
	public void LoginToApplication(String username,String password)
	{
		userTextField.sendKeys(username);
		userPasswordField.sendKeys(password);
		submitButton.click();
	}
}
