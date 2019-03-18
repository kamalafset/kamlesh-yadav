package com.monefy.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.monefy.pages.ExpensePage;
import com.monefy.pages.HomePage;
import com.monefy.pages.NewIncome;
import com.monefy.utility.ReadPropertiesFile;
import com.monefy.utility.ReportClass;
import com.monefy.utility.RetryAnalyser;

public class EndToEndTest extends BaseTest{
	
	/***
	 *  This test is going to verify Income = Expense functionality
	 * @param 
	 */
	@Test(priority = 1, retryAnalyzer = RetryAnalyser.class)
	public void verifyIncomeEqualToExpense()
	{
		//@ Get data from test data file under resource
		String expenseCatgory = dicTestData.get("chooseExpenseCatgeory"); 
		String  income = dicTestData.get("salaryIncome");
		HomePage homePage = new HomePage(driver);
		NewIncome newIncome = new NewIncome(driver);
		ExpensePage expensePage = new ExpensePage(driver);
		
		WebElement eleHome = homePage.waitForElement( homePage.eleIncome, 30);
		eleHome.click();
		
		//@ Enter income
		homePage.enterKeyValues(income);
		
		//@ click on Choose Category
		newIncome.btnChooseCategory.click();
		
		//@ Select Salary Account
		newIncome.selectSalaryAccount.click();
		
		//@ Click on expense
		homePage.waitForElement(homePage.eleExpense, 20).click();
		
		//@ enter Value
		homePage.enterKeyValues(income);
		
		//@ choose category
		expensePage.btnChooseCategory.click();
		
		//@ choose bill category
		homePage.selectAccountOrExpenseFromList(expenseCatgory);
		
		String balance = homePage.getBalance();
		ReportClass.assertEquals(balance.equalsIgnoreCase("0"));
		
	}
	
	/***
	 *  This test is going to verify Income > Expense functionality
	 * @param 
	 */
	@Test(priority = 2, retryAnalyzer = RetryAnalyser.class)
	public void verifyIncomeGreaterThanExpense()
	{
		//@ Get data from test data file under resource
		String expenseCatgory = dicTestData.get("chooseExpenseCatgeory"); 
		String  income = dicTestData.get("salaryIncome");
		String  expenseValue = dicTestData.get("expenseValue");
		int actualBalance = Integer.valueOf(income) - Integer.valueOf(expenseValue);
		
		HomePage homePage = new HomePage(driver);
		NewIncome newIncome = new NewIncome(driver);
		ExpensePage expensePage = new ExpensePage(driver);
		
		WebElement eleHome = homePage.waitForElement( homePage.eleIncome, 30);
		eleHome.click();
		
		//@ Enter income
		homePage.enterKeyValues(income);
		
		//@ click on Choose Category
		newIncome.btnChooseCategory.click();
		
		//@ Select Salary Account
		newIncome.selectSalaryAccount.click();
		
		//@ Click on expense
		homePage.waitForElement(homePage.eleExpense, 20).click();
		
		//@ enter Value
		homePage.enterKeyValues(expenseValue);
		
		//@ choose category
		expensePage.btnChooseCategory.click();
		
		//@ choose bill category
		homePage.selectAccountOrExpenseFromList(expenseCatgory);
		
		String balance = homePage.getBalance();
		
		ReportClass.assertEquals(balance.equalsIgnoreCase(String.valueOf(actualBalance)));
		
	}

}
