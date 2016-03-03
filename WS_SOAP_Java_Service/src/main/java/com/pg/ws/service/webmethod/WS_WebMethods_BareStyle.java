package com.pg.ws.service.webmethod;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.pg.ws.service.util.EndpointPublisher;

@WebService
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public class WS_WebMethods_BareStyle {

	@WebMethod
	public void publicMth(){
		System.out.println("publicMth");
	}
	
	@WebMethod(operationName="publicMthOverloaded")
	public void publicMth(String strName){
		System.out.println("WebMethod overloaded");
	}
	
	public static void main(String...str){
		EndpointPublisher.main("6565","/wswebmethodbarestyle","com.pg.ws.service.webmethod.WS_WebMethods_BareStyle");
	}
}
