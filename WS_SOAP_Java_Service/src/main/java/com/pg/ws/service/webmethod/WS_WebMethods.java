package com.pg.ws.service.webmethod;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.pg.ws.service.util.EndpointPublisher;

@WebService
public class WS_WebMethods {

	@WebMethod
	public void publicMth(){
		System.out.println("publicMth");
	}
	
	@WebMethod(operationName="publicMthOverloaded")
	@RequestWrapper(className="com.pg.ws.service.webmethod.Request")
	@ResponseWrapper(className="com.pg.ws.service.webmethod.Response")
	public void publicMth(String strName){
		System.out.println("WebMethod overloaded");
	}
	
	//RULE# WebMethod overloaded
	/*
	 * WARNING: Non unique body parts! In a port, as per BP 1.1 R2710 operations
	 * must have unique operation signature on the wire for successful dispatch.
	 * Methods [publicMth, publicMth] have the same request body block
	 * {http://webserviceref.service.ws.pg.com/}publicMth. Method dispatching
	 * may fail, runtime will try to dispatch using SOAPAction.
	 */
	/**
	 * @Client side
	 * [ERROR] duplicate "message" entity: "publicMth"
	 * 
	 * Fix: operationName="publicMthOverloaded" included
	 * similar 2 webmethods in one package.
	 */
	/*@WebMethod(operationName="publicMthOverloaded") 	
	public void publicMth(String strName){
		System.out.println("WebMethod overloaded");
	}*/

	
	//RULE# WebMethod on private method will be IGNORED.
	//this method will not be generated
	@WebMethod
	private void privateMth(){
		System.out.println("WebMethod on private method will be IGNORED.");
	}	
	
	//RULE# WebMethod - static, final - NOT ALLOWED - FAIL DEPLOYMENT
	/*@WebMethod
	public static final void publicMth(){
		System.out.println("Hi");
	}*/
	
	
	public static void main(String...str){
		EndpointPublisher.main("6565","/wswebmethod","com.pg.ws.service.webmethod.WS_WebMethods");
	}
}
