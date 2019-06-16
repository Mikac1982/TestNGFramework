package com.syntax.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener{

	@Override
	//TestCases started and using result variable we can get name of test case that started
	//it looks to every test case you have
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started: "+result.getName());
		test=report.createTest(result.getName()); //createTest() returns one test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed: "+result.getName());
		test.pass("Test case passed: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed:"+result.getName());
		test.fail("Test failed:"+result.getName());

		String imagePath=CommonMethods.takeScreenshot(result.getName());
		try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
			test.info("Not able to attach screenshot");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped: "+result.getName());
		
	}
    //it looks on the name you provide in .xml file
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test stareted: "+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test finished: "+context.getName());	
		
	}
	
	//this one is different
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case failed: "+result.getName());
		
	}


	
}
