package org.learnautomation.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider()
	{
		try {
			File src= new File(System.getProperty("user.dir")+"/Config/ProjectConfig.properties");
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public String getValue(String key1)
	{
		return pro.getProperty(key1);
	}
	
	public String geturl( )
	{
		return pro.getProperty("url");
	}
	
	public String getbrowser( )
	{
		return pro.getProperty("browser");
	}
}
