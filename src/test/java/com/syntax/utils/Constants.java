package com.syntax.utils;

public class Constants {

	//we store FILE PATH in one CONSTANT variable; no one is changing it!
	public static final String CREDENTIALS_FILEPATH="src/test/resources/configs/credentials.properties";
	
	public static final String XL_FILEPATH="src/test/resources/testdata/OrangeHrmData.xlsx";
	
//	public static final String XL_FILEPATH2="src/test/resources/testdata/AddLocations.xlsx";
	
    public static final String REPORT_FILEPATH= "target/report/orangeHrm.html";
    
    public static final String OS_NAME=System.getProperty("os.name"); //which operator do u have(windows/apple)
    
    public static final String USER_NAME =System.getProperty("user.name");
	
}
