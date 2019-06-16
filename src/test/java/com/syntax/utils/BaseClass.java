package com.syntax.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

    public static WebDriver driver;
	
    public static ExtentHtmlReporter htmlReport;
    public static ExtentReports report; //it has method createTest();
    public static ExtentTest test; //logger(test) is extend test file
    
    
    @BeforeMethod(alwaysRun=true) 
    public static void setUp() {
        //we are bringing our property file:
    	//we are bringing filePath from Constants Class and READ it using readProperties method
    	ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);//src/test/resources/configs/credentials.properties
    	//we are getting value of property browser key->String browser
    	String browser=ConfigsReader.getProperty("browser");
    	
		if (browser.equalsIgnoreCase("chrome")) {
		        //for MAC
		    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");	
		        //for WINDOWS
		  //System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");	
		    driver=new ChromeDriver(); //initializing our variable that holds our browser-chrome
		    
		}else if (browser.equalsIgnoreCase("firefox")) {
		    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
		    driver=new FirefoxDriver();
		    
		}else if(browser.equals("IE")) {
			 System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer");
			 driver=new InternetExplorerDriver();
			
		}
		else {
			System.out.println("Browser given is wrong");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//we are getting URL from property file, ConfigsReader class read this file
		driver.get(ConfigsReader.getProperty("url"));
	}
	
    @AfterMethod(alwaysRun=true)
	public static void tearDown() {
		driver.quit();
	}
	
    @BeforeTest(alwaysRun=true)
    public void generateReport() {
    	
    	ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
    	//create an object of extentReport and htmlReporter
    	htmlReport=new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
    	report=new ExtentReports();
    	report.attachReporter(htmlReport);
    	
    	//provide some info(optional)
    	report.setSystemInfo("OS", Constants.OS_NAME);
    	report.setSystemInfo("Enviroment", "Test");
    	report.setSystemInfo("Browser", ConfigsReader.getProperty("browser"));
    	report.setSystemInfo("QA", Constants.USER_NAME);
    	
    }
    
    @AfterTest(alwaysRun=true)
    public void flushReport() {
    	report.flush();
    }
    
    
}
