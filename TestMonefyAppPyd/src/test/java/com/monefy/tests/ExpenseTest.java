package com.monefy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.monefy.pages.ExpensePage;
import com.monefy.pages.HomePage;
import com.monefy.pages.NewIncome;
import com.monefy.utility.DataProviderClass;
import com.monefy.utility.ReadPropertiesFile;
import com.monefy.utility.ReportClass;
import com.monefy.utility.RetryAnalyser;

public class ExpenseTest extends BaseTest {
	
	/***
	 *  this test method is going to select every expense categories and verify balance
	 *  It is going to pull different expense from test data file through data provider
	 *  This test is going to verify Income < Expense functionality
	 * @param 
	 */
	@Test(dataProvider="local", dataProviderClass=DataProviderClass.class, retryAnalyzer = RetryAnalyser.class)
	public void addExpenseDetailsAndVerifyIncomeLessthanExpense(String expenseCriteria)
	{
		System.out.println(expenseCriteria);
		//@ Get data from test data file under resource
		String  expenseValue = dicTestData.get("expenseValue");
		
		HomePage homePage = new HomePage(driver);
		NewIncome newIncome = new NewIncome(driver);
		ExpensePage expensePage = new ExpensePage(driver);
		
		//@ Get balance from home screen
		String previousBalance =  homePage.getBalance();
		
		//@ Click on expense
		homePage.waitForElement(homePage.eleExpense, 20).click();
		
		//@ enter Value
		homePage.enterKeyValues(expenseValue);
		
		//@ choose category
		expensePage.btnChooseCategory.click();
		
		//@ choose bill category
		homePage.selectAccountOrExpenseFromList(expenseCriteria);
		
		String expense = homePage.eleBalanceBox.getText().split(" ")[1].split("\\.")[0].replace(",", "").replace("$", "");
		
		//@ verify addition of expense
		ReportClass.assertEquals(expense.contains(String.valueOf(Integer.valueOf(expenseValue) + Integer.valueOf(previousBalance))) );
		//@ Verify negative balance if Income < Expense 
		ReportClass.assertEquals(expense.contains("-"));
	}
	
	
	
	
}
