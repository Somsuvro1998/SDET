package generic_utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentImplementation implements ITestListener{
	ExtentReports report; //is used to set system configuration in the report
	ExtentTest test;   //is used to do test script level analysis

	public void onTestStart(ITestResult result)
	{
		test=report.createTest(result.getName());  //will return the name of the test method 
	}
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("<-------------I am Listening------------->");
		
		String screenshot=null;
		try{
			screenshot=WebDriver_Utility.takeScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshot);
	}
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}
	public void onStart(ITestContext context) //will be executed at the starting of the <test> tag in suite.xml file
	{
		Java_Utility jlib=new Java_Utility();
		int ranNo = jlib.getRandomNum();
		ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport/Report.html"+ranNo);  //it is used to set basic configurations to the report

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Testing");
        spark.config().setReportName("CRM Software Build 1.0"); //This is displayed in the report
        
        //Providing system configuration/information
        report=new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("Platform", "windows 11");
        report.setSystemInfo("executed by","Som");
        report.setSystemInfo("Reviewed by","Suvro");
	}
	public void onFinish(ITestContext context)  //will be executed at the end of <test> tag in suite.xml file
	{
		report.flush();
	}


}
