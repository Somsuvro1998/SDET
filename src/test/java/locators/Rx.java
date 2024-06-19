package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rx {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("C:\\Users\\SOMSUVRO\\Desktop\\New folder (2)\\Rx.html");
		//to print A
		String A = driver.findElement(By.xpath("html/body/div[1]/input[1]")).getText();
		System.out.println(A);

	}

}
