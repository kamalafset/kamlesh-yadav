package com.bestbuy.api.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.monefy.utility.ReadPropertiesFile;

public class BaseSetup {

	public HttpClient client;
	public HttpResponse response;
	public HttpGet request;
	public JSONParser JsonParser = new JSONParser();
	public static HashMap<String, String> dicApiTestData = new  HashMap<String, String>();
	
	@BeforeMethod
	public void setUp() {
		client = HttpClientBuilder.create().build();
	}

	public HttpClient getClient() {
		setUp();
		return client;
	}

	
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		//@ Read Data
		ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
		dicApiTestData =  readPropertiesFile.readPropertyFile("./src/test/resources/apiTestData.properties");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		dicApiTestData.clear();
	}
	
	
}
