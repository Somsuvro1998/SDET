package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	/**
	 * @author SOMSUVRO
	 * @param key
	 * @return
	 * @throws Throwable
	 */
public String getKeyAndValueData(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream("./src/test/resources/CData.properties");
    Properties pro=new Properties();
    pro.load(fis);
    String value = pro.getProperty(key);
    return value;
	
}
}

