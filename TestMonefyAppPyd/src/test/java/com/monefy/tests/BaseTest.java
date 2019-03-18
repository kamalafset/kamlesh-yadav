package com.monefy.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.monefy.utility.ReadPropertiesFile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	

	AppiumDriver<WebElement> driver;
	public static HashMap<String, String> dicTestData = new  HashMap<String, String>();
	public static HashMap<String, String> dicConfig = new  HashMap<String, String>();

	//@ Reading data from test data file placed under resource
	//@BeforeMethod
	@BeforeClass
	public void beforeMethod() throws MalformedURLException
	{
		//@ launch android app 
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, dicConfig.get("platformVersion"));
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dicConfig.get("deviceName"));
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 360000);
		desiredCapabilities.setCapability("unicodeKeyboard", true);
		desiredCapabilities.setCapability("resetKeyboard", true);
		desiredCapabilities.setCapability("appPackage", dicConfig.get("appPackage"));
		desiredCapabilities.setCapability("appActivity", dicConfig.get("appActivity"));
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result, ITestContext test)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("the test has failed "+ result.getMethod().getMethodName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			System.out.println("the test has passed "+ result.getMethod().getMethodName());
		}
		else 
		{
			System.out.println("the test has skipped "+ result.getMethod().getMethodName());
		}
	}
	
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		//@ Read Data
		ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
		dicTestData =  readPropertiesFile.readPropertyFile("./src/test/resources/testData.properties");
		dicConfig =  readPropertiesFile.readPropertyFile("./src/test/resources/config.properties");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		dicTestData.clear();
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
	
}
