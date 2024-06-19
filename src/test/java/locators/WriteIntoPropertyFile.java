package locators;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WriteIntoPropertyFile {
public static void main(String[] args) throws Throwable {
	
	Properties pro=new Properties();
	pro.setProperty("url", "https://www.saucedemo.com/v1/");
	pro.setProperty("username","standard_user");
	pro.setProperty("password","secret_sauce");
	FileOutputStream fos=new FileOutputStream("./src/test/resources/Som.properties");
	pro.store(fos,"SomData");
	System.out.println("data written succesfully");
		
}
}
