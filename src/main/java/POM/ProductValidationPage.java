package POM;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ProductValidationPage {
		
		public ProductValidationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//span[@id='dtlview_Product Name']")
	    private WebElement validateProduct;
		
		//gettter method
			public WebElement getValidateProduct() {
				return validateProduct;
			}
			
			
			//Business Logic
			public String ProdValidate()
			{
				return validateProduct.getText(); //with .getText(), it will return a string, that is why we have deliberately given
				                                  //the return type as String
			}
	}



