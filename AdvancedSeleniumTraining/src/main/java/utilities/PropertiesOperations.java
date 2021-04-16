package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations 
{
	static Properties prop=new Properties();
	
	public static String getPropertyValueByKey(String key)
	{
		//load data
		String propFilePath=System.getProperty("user.dir")+"/src/test/java/resources/config.properties";
		FileInputStream fis;
		
		try{
			fis=new FileInputStream(propFilePath);
			prop.load(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//read data
		String value=prop.getProperty(key);
		if(StringUtils.isEmpty(value))
		{
			try {		
				throw new Exception("Value is not specified for key: "+key + " in properties file.");
			}catch(Exception e) {}
		}
		
		return key;
		
	}
}
