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
 * SEI		: WebService_ServiceName_Class
 * Endpoint	: WebService_ServiceName_Class_Service
 * Port		: WebService_ServiceName_ClassPort
 * 
 */

@WebService (serviceName="WebService_ServiceName_Class_Service")
public class WebService_ServiceName_Class {

	@WebMethod
	public void publicMth(){
		System.out.println("Hi");
	}

	public static void main(String...str){
		EndpointPublisher.main("6565","/wsservicenameonclass","com.pg.ws.service.webserviceref.WebService_ServiceName_Class");
	}
}
