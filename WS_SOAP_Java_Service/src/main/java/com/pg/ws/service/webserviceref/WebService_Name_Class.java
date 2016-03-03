package com.pg.ws.service.webserviceref;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.pg.ws.service.util.EndpointPublisher;

/*
 * ENDPOINT
 * 	serviceName = endpoint (service)
 * 	<service>Service
 * 
 * 
 * SEI
 *  <service>
 *  name = SEI (portType)
 * 
 * PORT
 * <name>Port = port 
 * <service>Port = port
 * 
 */

/**
 * SEI		: WebService_Name_Class_SEI
 * Endpoint	: WebService_Name_ClassService
 * Port		: WebService_Name_Class_SEIPort
 * 
 */

@WebService (name="WebService_Name_Class_SEI")
public class WebService_Name_Class {

	@WebMethod
	public void publicMth(){
		System.out.println("Hi");
	}

	public static void main(String...str){
		EndpointPublisher.main("6565","/wsnameonclass","com.pg.ws.service.webserviceref.WebService_Name_Class");
	}
}
