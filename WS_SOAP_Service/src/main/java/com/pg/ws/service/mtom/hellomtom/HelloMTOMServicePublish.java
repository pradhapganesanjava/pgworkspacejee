package com.pg.ws.service.mtom.hellomtom;

import javax.xml.ws.Endpoint;

public class HelloMTOMServicePublish {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(" Endpoint publishing");
	Endpoint.publish("http://localhost:7785/soap_service/hellomtom", new HelloMTOMServiceImpl());	
		System.out.println("..Publish complete");
	}

}
