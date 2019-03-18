package com.monefy.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import io.appium.java_client.AppiumDriver;


public class HomePage extends BasePage {

	public HomePage(AppiumDriver<WebElement> driver) {
		super(driver);
	}
	
	public String getBalance()
	{
		waitForElement(eleBalanceBox, 30);
		return eleBalanceBox.getText().split(" ")[1].split("\\.")[0].replace(",", "").replace("$", "").replace("-", "");
	}
	
	public void enterKeyValues(String text) 
	{
		try {
			List<WebElement> listKeys =  lstkeyButton;
			for(int i = 0; i < text.length(); i++)
			{

				String eachChar = text.substring(i, i +1);

				for (WebElement webElementKey : listKeys) {
					String mobileText = webElementKey.getText();
					if(mobileText.equalsIgnoreCase(eachChar))
					{
						webElementKey.click();
						break;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("error "+ e.toString());
		}

	}

	
	//@ Select from list
	public boolean selectAccountOrExpenseFromList(String name)
	{
		boolean blnFlag = false; 
		List<WebElement> lstAccountsElement = lstSelectAccounts;
		for (WebElement eleAccount : lstAccountsElement) {
			if(eleAccount.getText().equalsIgnoreCase(name))
			{
				eleAccount.click();
				blnFlag = true;
				break;
			}
		}
		
		return blnFlag;
	}
	
	
	public void dismissPopUp()
	{
		if(elePopupSelectCategory.isDisplayed())
			elePopupSelectCategory.click();
		
		if(elePopUpTap.isDisplayed())
			 elePopUpTap.click();
	}
	
	@FindBy(id = "com.monefy.app.lite:id/income_button_title")
	public WebElement eleIncome;
	
	@FindBy(id = "com.monefy.app.lite:id/balance_amount")
	public WebElement eleBalanceBox;
	
	@FindBy(id = "com.monefy.app.lite:id/messageTextView")
	public WebElement eleBalanceTextView;
	
	@FindBy(id = "com.monefy.app.lite:id/expense_button_title")
	public WebElement eleExpense;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Settings']")
	public WebElement eleSettings;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation']")
	public WebElement eleNavigation;
	
	@FindBy(id = "com.monefy.app.lite:id/title")
	public WebElement lstNavigationAccounts;
	
	@FindBys({@FindBy(className = "android.widget.TextView")})
	public List<WebElement> lstSelectAccounts;
	
	@FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Monefy']//following-sibling::android.widget.TextView")
	public WebElement eleToolbarAccountsNameView;
	
	@FindBy(xpath = "//*[contains(@text,'Or tap the category')]")
	public WebElement elePopupSelectCategory;
	
	@FindBy(xpath = "//*[contains(@text,'Tap the')]")
	public WebElement elePopUpTap;
	
	@FindBys({@FindBy(className = "android.widget.Button")})
	public List<WebElement> lstkeyButton;
	
	@FindBy(id = "com.monefy.app.lite:id/snackbar_action")
	public WebElement btnCancel;
	

}
