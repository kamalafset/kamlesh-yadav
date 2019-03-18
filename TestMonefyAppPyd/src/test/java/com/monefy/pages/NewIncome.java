package com.monefy.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class NewIncome extends BasePage{

	public NewIncome(AppiumDriver<WebElement> driver) {
		super(driver);
	}


	@FindBy(id = "com.monefy.app.lite:id/amount_text")
	public WebElement edtIncomeTextBox;

	@FindBy(id = "com.monefy.app.lite:id/textViewChooseCategory")
	public WebElement btnChooseCategory;

	@FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Salary']")
	public WebElement selectSalaryAccount;

	@FindBy(id = "com.monefy.app.lite:id/buttonKeyboard2")
	public WebElement btn2;

	@FindBy(id = "com.monefy.app.lite:id/buttonKeyboard0")
	public WebElement btn0;
	
	@FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Deposits']")
	public WebElement selectSalaryDeposits;
	
	@FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Savings']")
	public WebElement selectSalarySavings;
	
	@FindBys({@FindBy(className = "android.widget.Button")})
	public List<WebElement> lstkeyButton;


}
