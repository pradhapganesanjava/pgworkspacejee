package com.pg.ws.service.webserviceref.sei;

import javax.jws.WebMethod;
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
 * SEI		: WebService_Default_SEI
 * Endpoint	: WebService_Default_SEIImplService
 * Port		: WebService_Default_SEIImplPort
 * 
 */

//@WebService  //without endpointInterface, treating it as class level ws.
@WebService(endpointInterface="com.pg.ws.service.webserviceref.sei.WebService_Default_SEI")
public class WebService_Default_SEIImpl{
	@WebMethod
	public void oneWayMth(String name) {
		System.out.println("asdfadf");
	}

	public void oneWayMthTwo(String name) {
		System.out.println("asdfadf");
	}
	
	public void excludeOneWayMth(String name) {
	}
	
	@WebMethod(exclude=true)
	public static void main(String...str) {
		EndpointPublisher.main("6565", "/wsdefaultsei","com.pg.ws.service.webserviceref.sei.WebService_Default_SEIImpl");
	}
}

@WebService
interface WebService_Default_SEI {
	@WebMethod
	public void oneWayMth(String name);
	@WebMethod(exclude=true)
	public void excludeOneWayMth(String name);
}