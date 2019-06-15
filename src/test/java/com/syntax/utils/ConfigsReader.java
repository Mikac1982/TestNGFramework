package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	//this variable holds data from credentials.properties file
	public static Properties prop;
	
	//this method will OPEN any file(read only one)
	public static void readProperties(String filePath) { //src/test/resources/configs/credentials.properties
		
		try {
			//file is getting loaded here
			FileInputStream fis=new FileInputStream(filePath);
			//variable gets initialized->create object of Properties class, variable prop is getting initialized
			prop=new Properties();
			//variable holds all data, entire file. it's loaded!
			prop.load(fis); //prop is getting loaded with values(data: browser, url...) from properties file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	return prop;
	}
	
	//this method will get(retrieve) key for any property file
	//(retrieve as many times we want)
	public static String getProperty(String key) {
		//once variable prop is loaded, we can get value of key : chrome, https://.., Admin..
		//we can search for key only when variable is loaded with data
		//if we don't use readProperties method, it will be empty --> null
		return prop.getProperty(key);	
	}
}
