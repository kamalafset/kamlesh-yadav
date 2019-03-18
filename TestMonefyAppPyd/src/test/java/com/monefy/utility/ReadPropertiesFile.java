package com.monefy.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class ReadPropertiesFile {
	
	
	public HashMap<String, String> readPropertyFile(String fileName) throws IOException
	{
		HashMap<String, String> testDataDic = new  HashMap<String, String>();
		Properties properties = new Properties();
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		properties.load(fis);
		Set<Object> strKeyset= properties.keySet();
		for (Object object : strKeyset) {
			String value = properties.getProperty((String) object);
			testDataDic.put(object.toString(), value.toString());
		}
			
		return testDataDic;
	}
}
