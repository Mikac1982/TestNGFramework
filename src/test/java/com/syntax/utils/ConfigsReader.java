package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	public static Properties prop;
	//this method will open any file
	public static Properties readProperties(String filePath) {
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	//this method will get(retrieve)property key for any file
	public static String getProperty(String key) {
		return prop.getProperty(key);	
	}
}
