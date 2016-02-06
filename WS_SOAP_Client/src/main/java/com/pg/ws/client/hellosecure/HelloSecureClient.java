package com.pg.ws.client.hellosecure;

import com.pg.ws.stub.hellosecure.HelloSecure;
import com.pg.ws.stub.hellosecure.HelloSecureService;

public class HelloSecureClient {

	public static void main(String str[]){
		HelloSecureService helloSecureSEI = new HelloSecureService();
		HelloSecure helloSecurePort = helloSecureSEI.getPort(HelloSecure.class);
		System.out.println(" output " + helloSecurePort.getUserDetails("Pradhap"));
	}
	
}
