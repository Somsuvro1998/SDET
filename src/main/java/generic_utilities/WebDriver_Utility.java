package generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
/**
 * 
 * @param driver
 */
public void maximizingwindow(WebDriver driver)
{
	driver.manage().window().maximize();
	}
/** 
 * 
 * @param driver
 */
public void minimizingwindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * 
 * @param driver
 */
public void implicit_wait(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
/**
 * 
 * @param driver
 * @param PartiallyVisibleText
 */
public void windowSwitching(WebDriver driver,String PartiallyVisibleText)
{
	Set<String> allwin = driver.getWindowHandles();
	Iterator<String> win = allwin.iterator();
	
	while(win.hasNext())
	{
		String winText = win.next();
		driver.switchTo().window(winText);
		String title = driver.getTitle();
		
		if(title.contains(PartiallyVisibleText))
		{
			break;
		}
	}
}
/**
 * 
 * @param driver
 */
public void alertAccept(WebDriver driver)
{
	Alert alt = driver.switchTo().alert();
	alt.accept(); //method of alert
}
/** 
 * 
 * @param driver
 */
public void alertDismiss(WebDriver driver)
{
	Alert alt = driver.switchTo().alert();
	alt.dismiss(); //method of alert
}
/**
 * 
 * @param driver
 * @param index
 */
public void switchToFrameBasedOnIndex(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}
/**
 * 
 * @param driver
 * @param Id_Name_Attribute
 */
public void switchToFrameBasedOnIdNameAttribute(WebDriver driver,String Id_Name_Attribute)
{
	driver.switchTo().frame(Id_Name_Attribute);
}
/**
 * 
 * @param driver
 * @param element
 */
public void mouseOverElement(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * 
 * @param driver
 * @param x
 * @param y
 */
public void moveByOffSet(WebDriver driver,int x,int y)
{
	Actions act=new Actions(driver);
	act.moveByOffset(x, y).click().perform();
}
/**
 * 
 * @param driver
 * @param element
 */

public void rightClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * 
 * @param element
 * @param index
 */
public void selectByIndex(WebElement element, int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
/**
 * 
 * @param element
 * @param text
 */
public void selectByVisibleText(WebElement element, String text)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
public void javaScriptExecutor(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView()",element);
}
public static String takeScreenShot(WebDriver driver,String screenShotName) throws Throwable
{
	TakesScreenshot takesScreenShot=(TakesScreenshot)driver;
	File src = takesScreenShot.getScreenshotAs(OutputType.FILE);
	File dst=new File("./ScreenShots/"+screenShotName+".png");
	FileUtils.copyFile(src, dst);
	return dst.getAbsolutePath();
			}

}
