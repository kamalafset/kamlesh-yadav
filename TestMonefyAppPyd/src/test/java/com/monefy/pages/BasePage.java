package com.monefy.pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	
	
	 AppiumDriver<WebElement> driver;
	
	public BasePage(AppiumDriver<WebElement> driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@ wait for element to pop up
	public WebElement waitForElement(WebElement element, int iWait)
	{
		WebDriverWait wait = new WebDriverWait(driver, iWait);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void jSClick(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
}
