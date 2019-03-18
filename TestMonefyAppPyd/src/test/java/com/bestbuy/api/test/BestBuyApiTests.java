package com.bestbuy.api.test;

import java.io.IOException;

import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.monefy.utility.DataProviderApiClass;
import com.monefy.utility.ReportClass;

public class BestBuyApiTests extends BaseSetup {

	ApiUtility apiUtility = new ApiUtility();
	
	/***
	 * This test is going to verify success status code for all api
	 * @param 
	 */
	@Test(dataProvider="apiLocal", dataProviderClass=DataProviderApiClass.class)
	public void verifySucessSatusCode(String endPoint) throws IOException, ParseException
	{
		System.out.println("end Point name:- "+ endPoint);
		String url = dicApiTestData.get("endPointURL") + endPoint;
		response = apiUtility.doGet(url);
		int statusCode = apiUtility.getStatusCode(response);
		ReportClass.assertEquals(statusCode == 200);
	}

	/***
	 * This test is going to verify total product count is greater than zero
	 * @param 
	 */
	@Test(dataProvider="apiLocal", dataProviderClass=DataProviderApiClass.class)
	public void verifyTotalProductCount(String endPoint) throws IOException, ParseException
	{
		//@ skipping validation as following do not have 'Total'
		if(endPoint.equalsIgnoreCase("healthcheck") || endPoint.equalsIgnoreCase("version"))
		{
			throw new SkipException("Skipping test   "+ endPoint);
		}
		String Url = dicApiTestData.get("endPointURL") + endPoint;
		response = apiUtility.doGet(Url);
		ReportClass.assertEquals(200 == apiUtility.getStatusCode(response));
		String strResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		Object obj = JsonParser.parse(strResponse);
		JSONObject json = (org.json.simple.JSONObject) obj;
		String totalCount = String.valueOf(json.get("total"));
		ReportClass.assertEquals(Integer.parseInt(totalCount) > 0);
	}

	/***
	 * This test is going to verify limit is equal to Size of data in response
	 * @param 
	 */
	@Test(dataProvider="apiLocal", dataProviderClass=DataProviderApiClass.class)
	public void verifyLimitEqualToSizeOfData (String endPoint) throws IOException, ParseException
	{
		//@ skipping validation as following do not have 'limit'
		if(endPoint.equalsIgnoreCase("healthcheck") || endPoint.equalsIgnoreCase("version"))
		{
			throw new SkipException("Skipping test   "+ endPoint);
		}
		String Url = dicApiTestData.get("endPointURL") + endPoint;
		response = apiUtility.doGet(Url);
		int statusCode = apiUtility.getStatusCode(response);
		ReportClass.assertEquals(statusCode == 200);
		String strResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		Object obj = JsonParser.parse(strResponse);
		JSONObject json = (org.json.simple.JSONObject) obj;
		String limit = String.valueOf(json.get("limit"));
		//@ Json array
		JSONArray arrName = (JSONArray) json.get("data");
		int arrSize = arrName.size();
		ReportClass.assertEquals(arrSize == Integer.parseInt(limit));
	}

	/***
	 * This test is going to verify api version
	 * @param 
	 */
	@Test
	public void verifyVerionApi() throws IOException, ParseException
	{
		String Url = dicApiTestData.get("endPointURL") + "version";
		response = apiUtility.doGet(Url);
		ReportClass.assertEquals(apiUtility.getStatusCode(response) == 200);
		String strResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		Object obj = JsonParser.parse(strResponse);
		JSONObject json = (org.json.simple.JSONObject) obj;
		String version = String.valueOf(json.get("version"));
		//@ Verify Version
		ReportClass.assertEquals(dicApiTestData.get("version"), version);
	}
	
	/***
	 * This test is going to verify HealthCheckup uptime > 0 and product > 0, Stores > 0, Categories > 0
	 * @param 
	 */
	@Test
	public void verifyHealthCheckupApi() throws IOException, ParseException
	{
		String docName, docValue = "";
		String Url = dicApiTestData.get("endPointURL") + "healthcheck";
		response = apiUtility.doGet(Url);
		ReportClass.assertEquals(apiUtility.getStatusCode(response) == 200);
		String strResponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		Object obj = JsonParser.parse(strResponse);
		JSONObject json = (org.json.simple.JSONObject) obj;
		String uptime = String.valueOf(json.get("uptime"));
		//@ Verify uptime > 0
		ReportClass.assertEquals( Double.valueOf(uptime)  > 0);
		String documents = String.valueOf(json.get("documents"));
		String[] arrDocument = documents.split(",");
		for (String strDoc : arrDocument) {
			strDoc = strDoc.replace("{", "").replace("}","").replace("\"","");
			docName = strDoc.split(":")[0];
			docValue = strDoc.split(":")[1];		
			ReportClass.assertEquals(Integer.parseInt(docValue) > 0, " document Name " + docName);
		}
	}




}
