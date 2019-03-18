package com.monefy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class ExpensePage extends BasePage {

	public ExpensePage(AppiumDriver<WebElement> driver) {
		super(driver);
	}
	
	
	
	@FindBy(id = "com.monefy.app.lite:id/textViewNote")
	public WebElement edtAddNote;
	
	@FindBy(id = "com.monefy.app.lite:id/textViewChooseCategory")
	public WebElement btnChooseCategory;
	
	
	
	
	

}
