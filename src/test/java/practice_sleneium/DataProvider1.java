package practice_sleneium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
@Test(dataProvider="dataProviderExecute")
	public void getTickets(String src,String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest);
	}
	@DataProvider
	public Object[][] dataProviderExecute()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="Bangalore";
		obj[0][1]="Goa";
		
		obj[1][0]="Bangalore";
		obj[1][1]="Mumbai";
		return obj;
	}
	
	

}
