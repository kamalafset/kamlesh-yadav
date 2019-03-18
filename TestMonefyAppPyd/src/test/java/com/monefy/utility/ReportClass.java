package com.monefy.utility;

import org.testng.Assert;

public class ReportClass {
	
	
	public static void assertEquals(String expected, String actual)
	{
		Assert.assertEquals(expected, actual);
	}
	

	public static void assertEquals(boolean condition)
	{
		Assert.assertTrue(condition);
	}
	
	
	public static void assertEquals(boolean condition, String message)
	{
		Assert.assertTrue(condition, message);
	}
	
}
