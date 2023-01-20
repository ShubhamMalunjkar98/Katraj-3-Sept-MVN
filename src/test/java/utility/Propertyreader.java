package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertyreader {
	
	public static String readProperty(String key) throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.property";
		
		FileInputStream fis=new FileInputStream(path);
		
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
}
