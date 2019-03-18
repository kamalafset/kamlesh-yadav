package com.monefy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class CategoryPage extends BasePage {

	
	
	public CategoryPage(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	@FindBy(id = "com.monefy.app.lite:id/categories_textview")
	public WebElement eleCategories;
	
}
