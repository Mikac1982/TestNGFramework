package com.syntax.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass{


/**
 * @author Syntax 
 * This method will select a specified value from a drop down by visible text
 * @parameter Select element, String text
 */
	public static void selectValueDropDown(WebElement element, String text) {
		
		Select select=new Select(element);
		List<WebElement> options=select.getOptions();
		boolean isSelected=false;
		for (WebElement option:options) {
			String optionText=option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text); 
				System.out.println("Option with text "+text+" is selected");
				isSelected=true;
				break; //once we find the value we are looking for, we stop it; break;
			}
		}
		if(!isSelected) {
			System.out.println("Option with text "+text+" is NOT available");
		}
	}
	
/**
 * @autor Syntax
 * This method will select a specified value from a drop down by its index
 * @param Select element, int index
 */
	public static void selectValueDropDown(WebElement element, int index) { //method overloading
		
		Select select=new Select(element);
		List<WebElement> options=select.getOptions();
		
		if (options.size()>index) {
			select.selectByIndex(index);
		}else {
			System.out.println("Invalid index has been passed");
		}
		select.deselectByIndex(index);
		
	}

/**
 * This method will clear the text box and then send text
 * @param Select element, String value
 */
	
	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
/**
 * Method will accept alert
 * @throws NoAlertPresentException if alert is not present
 */
	public static void acceptAlert() {

		try {
		   Alert alert=driver.switchTo().alert();
		   alert.accept();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
/**
 * Method will dismiss alert
 * @throws NoAlertPresentException if alert is not present
 */	
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
/**
 * Method will get text of an alert
 * @throws NoAlertPresentException if alert is not present
 * @return String text
 */	
	public static String getAlertText() {
		
		try {
			Alert alert=driver.switchTo().alert();
			return alert.getText();
		}catch(NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}
	}
/**
 * Method that will switch control to the specify frame
 * @throws NoSuchFrameException if frame is not present
 * @param frame id or frame name
 */	
	public static void switchToFrame(String idOrName) {
		try {
		    driver.switchTo().frame(idOrName);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
/**
 * Method that will switch control to the specify frame
 * @param frame element
 */	
	public static void switchToFrame(WebElement element) { //method overloading
		try {
		    driver.switchTo().frame(element);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
/**
 * Method that will switch control to the specify frame
 * @param frame index
 */
	public static void switchToFrame(int index) { //method overloading
		try {
		    driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
/**
 * This method will click on specific element
 * @param element
 */
	public static void click(WebElement element) {			
		element.click();		
	}
	
/**
 * This method will select specific date in the calendar
 * @param List of WebElements, String expected value
 */
	public static void selectValueCalendar(List<WebElement> list, String value) {
		
		List<WebElement> rows=(List<WebElement>) list;
		
		for (WebElement row:rows) {
			String rowText=row.getText();
			if(rowText.contains(value)) {
				row.click();
			System.out.println(value+" is selected");	
			}
		}
	}
/**
 * This method will select specific radio button from the list of buttons	
 * @param list of radio buttons, String selectedValue
 */
   public static void selectValueRadioButton(List<WebElement> list, String selectedValue) {
		
		for (WebElement radio: list) {
			
			if(radio.isEnabled()) {
				String value=radio.getText();
				
				if(value.equals(selectedValue)) {
					radio.click();
					System.out.println(selectedValue+" is selected");
				}
			}
		}
	}
   public static void selectRadioBtn(List<WebElement> list, String expectedValue) {
       boolean isSelected=false;
       for (WebElement button : list) {
           String buttonText = button.getText();

           if (button.isDisplayed() && button.isEnabled() && buttonText.equals(expectedValue)) {
               button.click();
               System.out.println(expectedValue + " is selected");
               isSelected=true;
               break;
           }

       }
       if (!isSelected) {
           System.out.println("Expected value " + expectedValue + " is NOT selected");

       }
   }
/**
 * This method will select specific check box
 * @param list of check boxes, String value
 */
   public static void selectValueCheckBox(List<WebElement> list, String selectedValue) {
	
	  for(WebElement checkBox: list) {
		  if (checkBox.isEnabled()) {
			  
		     String value=checkBox.getText();
		        if(value.equals(selectedValue)) {
		        	if (!checkBox.isSelected()) {
			           checkBox.click();
			           break;
		        	}
		        System.out.println(selectedValue+" is selected");
		            
	            }
		  }
      }
   }
   
   /**
    * This method will select month from the calendar
    * @param Select element, String text
    */
   public static void selectMonth(WebElement element, String text) { 
	   selectValueDropDown(element, text);
   }
   
   /**
    * This method will select year from the calendar
    * @param Select element, String text
    */
   public static void selectYear(WebElement element, String text) {
	   selectValueDropDown(element, text);
   }
   
   /**
    * This method will select day from the calendar
    * @param List of Days, String days
    */
   public static void selectDay(List<WebElement> days, String day) {
	   
	  int monthSize=days.size();
	  for(int i=0; i<monthSize; i++) {
		  
		  if(days.get(i).getText().equals(day)) {
			  days.get(i).click();
		  }
	  } 
   }
   
   /**
    * Method that will wait for element to be visible
    * @param WebElement element, int time
    */
   public static void waitForElementBeVisible(WebElement element, int time) {
	   WebDriverWait wait=new WebDriverWait(driver,time);
	   wait.until(ExpectedConditions.visibilityOf(element)); 
   }
   /**
    * Method that will wait for element to be visible
    * @param By locator, int time
    */
   public static void waitForElementBeVisible(By locator, int time) {
	   WebDriverWait wait=new WebDriverWait(driver,time);
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)); 
   }
   
   /**
    * Method that will wait for element to be clickable
    * @param WebElement element, int time
    */
   public static void waitForElementBeClickable(WebElement element, int time) {
	   WebDriverWait wait=new WebDriverWait(driver,time);
	   wait.until(ExpectedConditions.elementToBeSelected(element)); 
   }
   /**
    * Method that will wait for element to be clickable
    * @param By locator, int time
    */
   public static void waitForElementBeClickable(By locator, int time) {
	   WebDriverWait wait=new WebDriverWait(driver,time);
	   wait.until(ExpectedConditions.elementToBeSelected(locator)); 
   }
   
   /**
    * Method that will take screen shoot 
    * @param String folderName, String FileName
    */
   public static void takeScreenshoot(String folderName, String FileName ) {
	   
	    TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE); //dynamic
		
		try {
			FileUtils.copyFile(src, new File("screenshots/"+folderName+"/"+FileName+".png")); //dynamic
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot was not taken");
		}
   }
   /**
    * Method that will perform scroll down 
    * @param int pixels
    */
   public static void scrollDown(int pixels) {
	   
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,"+pixels+")");
   }
   
   /**
    * Method that will perform scroll UP 
    * @param int pixels
    */
   public static void scrollUp(int pixels) {
	   
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,-"+pixels+")");
   }
   
   /**
    * Method that will perform click 
    * @param WebElement element
    */
   public static void jacaScriptClick(WebElement element) {
	   
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", element);
   }
   
   public static void selectList(WebElement element, String text) {
   List<WebElement> listLocations=element.findElements(By.tagName("li"));
   
   for (WebElement li: listLocations) {
   	
   	String liText=li.getAttribute("innerHTML").trim();  //returns a text
   

		if(liText.contains("HQ")){
			li.click();
			break;
		}
	}
   }
   
   
   
}
