package com.monefy.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.monefy.pages.AccountsPage;
import com.monefy.pages.HomePage;
import com.monefy.pages.NewIncome;
import com.monefy.utility.ReadPropertiesFile;
import com.monefy.utility.ReportClass;
import com.monefy.utility.RetryAnalyser;

public class AccountTest extends BaseTest{


	/***
	 * This test is going to add a new account and verify new account added in dashboard account navigation
	 * @param 
	 */
	@Test(priority = 1, retryAnalyzer = RetryAnalyser.class)
	public void e2EAddAccounts()
	{
		//@ Get data from test data file under resource
		String  accountName = dicTestData.get("accountName");
		HomePage homePage = new HomePage(driver);
		NewIncome newIncome = new NewIncome(driver);
		AccountsPage accountsPage = new AccountsPage(driver);
	
		//@ Wait and Click on Settings
		homePage.waitForElement(homePage.eleSettings, 30).click();
		
		//@ Click on Accounts
		accountsPage.eleAccounts.click();
		
		//@ Click on pus image to add
		accountsPage.btnPlus.click();
		
		//@ Enter new Account name
		accountsPage.edtTextCategoryName.sendKeys(accountName);
		
		//@ Close keyboard and select any image
		accountsPage.imgAccountCategories.get(0).click();
		
		//@click on save button
		accountsPage.btnSave.click(); 
		
		//@ dismiss popup
		homePage.dismissPopUp();
		
		//@ click on accounts view 
		homePage.eleNavigation.click();
		
		//@ click to open account list from home page navigation 
		homePage.lstNavigationAccounts.click();
		
		//@ Select created account name
		boolean blnFlag = homePage.selectAccountOrExpenseFromList(accountName);
		ReportClass.assertEquals(blnFlag);
		
		//@ verify account name on homePage navigation bar screen
		ReportClass.assertEquals(accountName, homePage.eleToolbarAccountsNameView.getText());
	}
	
	
	/***
	 *  This test is going to add new income through salary Account with added new account
	 * @param 
	 */
	@Test(priority=2, retryAnalyzer = RetryAnalyser.class)
	public void addIncomeBySalary()
	{
		//@ Get data from test data file under resource
		String  income = dicTestData.get("salaryIncome");
		HomePage homePage = new HomePage(driver);
		NewIncome newIncome = new NewIncome(driver);
		
		//@ Get balance from home screen
		String previousBalance =  homePage.getBalance();

		WebElement eleHome = homePage.waitForElement( homePage.eleIncome, 30);
		eleHome.click();
		//@ Enter income
		homePage.enterKeyValues(income);	
		//@ click on Choose Category
		newIncome.btnChooseCategory.click();
		//@ Select Salary Account
		newIncome.selectSalaryAccount.click();
		//@ Verify added income in monify app
		String newBalance =  homePage.eleBalanceBox.getText().split(" ")[1].split("\\.")[0].replace(",", "").replace("$", "");			
		ReportClass.assertEquals(String.valueOf(Integer.valueOf(income) + Integer.valueOf(previousBalance)), newBalance.trim());
	}
	
	/***
	 *  This test is going to add new income through Deposits Account
	 * @param 
	 */
	@Test(priority = 3, retryAnalyzer = RetryAnalyser.class)
	public void addIncomeByDeposits()
	{
		//@ Get data from test data file under resource
		String  income = dicTestData.get("depositsIncome");
		HomePage homePage = new HomePage(driver);
		NewIncome newIncome = new NewIncome(driver);	
		
		//@ Get balance from home screen
		String previousBalance =  homePage.getBalance();
		WebElement eleHome = homePage.waitForElement( homePage.eleIncome, 30);
		eleHome.click();
		//@ Enter income
		homePage.enterKeyValues(income);	
		//@ click on Choose Category
		newIncome.btnChooseCategory.click();
		//@ Select Salary Account
		newIncome.selectSalaryDeposits.click();
		//@ Verify added income in monify app
		String newBalance =  homePage.eleBalanceBox.getText().split(" ")[1].split("\\.")[0].replace(",", "").replace("$", "");	
		ReportClass.assertEquals(String.valueOf(Integer.valueOf(income) + Integer.valueOf(previousBalance)), newBalance.trim());
	}
	
	
	/***
	 *  This test is going to add new income through Savings Account
	 * @param 
	 */
	@Test(priority = 4, retryAnalyzer = RetryAnalyser.class)
	public void addIncomeBySavings()
	{
		//@ Get data from test data file under resource
		String  income = dicTestData.get("savingIncome");
		HomePage homePage = new HomePage(driver);
		NewIncome newIncome = new NewIncome(driver);	
		
		//@ Get balance from home screen
		String previousBalance =  homePage.getBalance();
		WebElement eleHome = homePage.waitForElement( homePage.eleIncome, 30);
		eleHome.click();
		//@ Enter income
		homePage.enterKeyValues(income);	
		//@ click on Choose Category
		newIncome.btnChooseCategory.click();
		//@ Select Salary Account
		newIncome.selectSalarySavings.click();
		//@ Verify added income in monify app
		String newBalance =  homePage.eleBalanceBox.getText().split(" ")[1].split("\\.")[0].replace(",", "").replace("$", "");	
		ReportClass.assertEquals(String.valueOf(Integer.valueOf(income) + Integer.valueOf(previousBalance)), newBalance.trim());
	}
	
	
}
