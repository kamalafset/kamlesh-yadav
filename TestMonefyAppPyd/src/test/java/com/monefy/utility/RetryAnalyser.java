package com.monefy.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	private int retryCount = 0;
	//Specify Max Retry Count.
	private int maxRetryCount = 1;
	/**
	 * Check the Retry Count.
	 * Currently configured for 1
	 */
	public boolean retry(ITestResult result) {

		if(retryCount < maxRetryCount) 
		{	
			retryCount++; 
			return true; 
		} 
		return false; 
	}  


}
