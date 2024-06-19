package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Facebook {
	@Test
public static void main(String[] args) throws Throwable {
	
	WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
	driver.get("https://www.facebook.com/");
	Thread.sleep(3000);
	//maximizing statement
	driver.manage().window().maximize();
	Thread.sleep(3000);

    driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
    Thread.sleep(3000);
    
     //clicking on signup from registration form using child
    driver.findElement(By.xpath("//div[@id='reg_form_box']/child::div[11]/button")).click();	
    
    //from singup button to first name using parent
    driver.findElement(By.xpath("//button[@name='websubmit']/parent::*/parent::*/child::div[1]/div[1]/div[1]/div")).click();
    
    //Selecting password from mobile number or email field using following
    driver.findElement(By.xpath("//input[@name='reg_email__']/following::input[2]")).sendKeys("Hello");
    
    //Selecting mobile number from password using preceding 
    driver.findElement(By.xpath("//input[@id='password_step_input']/preceding::input[2]")).sendKeys("556565656");
    
    //Selecting surname from female radio button
    driver.findElement(By.xpath("//input[@id='u_t_4_Vq']/ancestor::div[2]/div[1]/div/div[2]/div")).sendKeys("A");
    

}
}
