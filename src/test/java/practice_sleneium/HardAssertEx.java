package practice_sleneium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {

	@Test
	public void m1()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
		Assert.assertEquals(false,true); //will give AssertionError Exxception
		System.out.println("Step 5");
		System.out.println("Step 6");
	}
	
	@Test
	public void m2()
	{
		String ActData="Qspiders";
		String ExpData="jspiders";
		Assert.assertEquals(ActData, ExpData);
	}
}
