package com.monefy.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AccountsPage extends BasePage {

	public AccountsPage(AppiumDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	@FindBy(id = "com.monefy.app.lite:id/accounts_textview")
	public WebElement eleAccounts;
	
	@FindBy(id = "com.monefy.app.lite:id/imageButtonAddCategory")
	public WebElement btnPlus;
	
	@FindBy(id = "com.monefy.app.lite:id/editTextCategoryName")
	public WebElement edtTextCategoryName;
	
	@FindBys({@FindBy(className = "android.widget.ImageView")})
	public List<WebElement> imgAccountCategories;
	
	@FindBy(id = "com.monefy.app.lite:id/save")
	public WebElement btnSave;
	
	
	
	

}
