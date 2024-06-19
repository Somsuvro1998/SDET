package practice_sleneium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftAssertEx {

	@Test (invocationCount=1,priority=2,dependsOnMethods="sa2()")
	public void sa() {
		System.out.println("First script");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(false, true);
		System.out.println("Step5");
		System.out.println("Step6");
		soft.assertAll();
		
		

	
		//OverAll the test script has failed but all the lines were executed
		//SoftAssert
	}
	
	@Test (invocationCount=2, priority=1, enabled=true)
	public void sa2()
	{
		System.out.println("Second script");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(true, true);
		System.out.println("Step5");
		System.out.println("Step6");
		soft.assertAll();
	}

}
