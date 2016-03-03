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
 * SEI		: WebService_SeiName_SEI_UPDATED
 * Endpoint	: WebService_SeiName_SEIImplService
 * Port		: WebService_SeiName_SEIImplPort
 * 
 */

//@WebService  //without endpointInterface, treating it as class level ws.
@WebService(endpointInterface="com.pg.ws.service.webserviceref.sei.WebService_SeiName_SEI")
public class WebService_SeiName_SEIImpl implements WebService_SeiName_SEI{
	
	public void oneWayMth(String name) {
		System.out.println("asdfadf");
	}

	@WebMethod(exclude=true)
	public static void main(String...str) {
		EndpointPublisher.main("6565", "/wsseiname","com.pg.ws.service.webserviceref.sei.WebService_SeiName_SEIImpl");
	}
}

@WebService(name="WebService_SeiName_SEI_UPDATED")
interface WebService_SeiName_SEI {
	public void oneWayMth(String name);
}