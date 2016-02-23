package com.pg.ws.rs.client.hello;

import java.net.HttpURLConnection;
import java.net.URL;

public class HelloRestClient {

	public static void main(String str[]) throws Exception{
		
		URL restURL = new URL("http://localhost:8080/WS_REST_Service/wsrest/hellorest");
		HttpURLConnection httpURLCon = (HttpURLConnection)restURL.openConnection();
		httpURLCon.setRequestMethod("GET");
		httpURLCon.setDoInput(true);
		System.out.println("ResponseCode: "+httpURLCon.getResponseCode());
		System.out.println("ResponseMessage: "+httpURLCon.getResponseMessage());
	}
	
	
}
