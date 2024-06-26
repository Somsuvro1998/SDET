package generic_utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {
	public void onTestFailure(ITestResult result) {
		
		String testData = result.getMethod().getMethodName(); 
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			File dest=new File("./Screenshot/"+testData+".png");
			FileUtils.copyFile(src,dest);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
}
