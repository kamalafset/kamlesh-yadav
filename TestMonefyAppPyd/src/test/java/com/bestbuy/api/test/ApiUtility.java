package com.bestbuy.api.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApiUtility {
	
	HttpClient client;
	HttpResponse response;
	HttpGet request;
	
	/**
	 * Get Status Code.
	 * 
	 * @param response
	 * @return
	 */
	public int getStatusCode(HttpResponse response) {
		return response.getStatusLine().getStatusCode();
	}
	
	/**
	 * Method takes URL and returns a HTTP GET response.
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public HttpResponse doGet(String url) throws IOException {

		client = HttpClientBuilder.create().build();
		request = new HttpGet(url);
		request.addHeader("User-Agent", "Mozilla/5.0");
		response = client.execute(request);
		return response;
	}

}
