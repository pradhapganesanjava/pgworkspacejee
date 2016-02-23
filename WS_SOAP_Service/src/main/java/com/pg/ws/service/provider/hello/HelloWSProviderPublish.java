package com.pg.ws.service.provider.hello;

import javax.xml.ws.Endpoint;

public class HelloWSProviderPublish {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("going to publish");
		Endpoint endPoint = Endpoint.publish(
				"http://localhost:7780/WS_SOAP_Service/hellowsprovider",
				new HelloWSProvider());
		System.out.println("publish complete.");
	}

}
