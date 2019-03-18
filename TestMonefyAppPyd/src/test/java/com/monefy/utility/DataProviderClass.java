package com.monefy.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class DataProviderClass {
	
	@org.testng.annotations.DataProvider(name="local")
	public static Object[][] localTestRun() throws FileNotFoundException {
		Scanner s = new Scanner(new File("./src/test/resources/expenseList"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
			list.add(s.next());
		}

		String[][] expenseList = new String[list.size()][1];
		//return browsers;
		for (int i=0;i<list.size();i++)
		{
			expenseList[i][0]=list.get(i);

		}

		return (expenseList);
	}
}
