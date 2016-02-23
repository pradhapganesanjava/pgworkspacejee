package com.pg.ws.client.hellosecure;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import com.pg.ws.stub.hellosecure.HelloSecure;
import com.pg.ws.stub.hellosecure.HelloSecureService;

/*
 * 
 */

public class HelloSecureClient {

	public static void main(String str[]) throws Exception{
		HelloSecure_SOAP11();
		

		//helloSecure_SOAP12();
	
		
	}

	private static void helloSecure_SOAP12() {
		com.pg.ws.stub.hellosecure_soap12.HelloSecureService helloSecureSEI = new com.pg.ws.stub.hellosecure_soap12.HelloSecureService();
		com.pg.ws.stub.hellosecure_soap12.HelloSecure helloSecurePort = helloSecureSEI.getPort(com.pg.ws.stub.hellosecure_soap12.HelloSecure.class);
		
		Map<String, Object> reqCntxMap = ((BindingProvider)helloSecurePort).getRequestContext();
		
		reqCntxMap.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/WS_SOAP_Service/hellosecure");
		reqCntxMap.put(BindingProvider.USERNAME_PROPERTY,"admin");
		reqCntxMap.put(BindingProvider.PASSWORD_PROPERTY,"admin");
		
		Map<String, List<String>> reqHeadMap = new HashMap<String, List<String>>();
		reqHeadMap.put("Content-Type", Collections.singletonList("application/soap+xml"));
		reqHeadMap.put("Accept", Collections.singletonList("application/soap+xml"));
		reqHeadMap.put("userName", Collections.singletonList("admin"));
		reqHeadMap.put("password", Collections.singletonList("admin"));

		reqCntxMap.put(MessageContext.HTTP_REQUEST_HEADERS,reqHeadMap);
		reqCntxMap.put(MessageContext.HTTP_REQUEST_METHOD,"GET");

		System.out.println(" output " + helloSecurePort.getUserDetails("Pradhap"));
	}

	private static void HelloSecure_SOAP11()
			throws UnsupportedEncodingException {
		HelloSecureService helloSecureSEI = new HelloSecureService();
		HelloSecure helloSecurePort = helloSecureSEI.getPort(HelloSecure.class);
		
		Map<String, Object> reqCntxMap = ((BindingProvider)helloSecurePort).getRequestContext();
		
		reqCntxMap.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:7777/WS_SOAP_Service/hellosecure");
		/*reqCntxMap.put(BindingProvider.USERNAME_PROPERTY,new String("admin".getBytes(),"UTF-8"));
		reqCntxMap.put(BindingProvider.PASSWORD_PROPERTY,new String("admin".getBytes(),"UTF-8"));*/
		
		Map<String, List<String>> reqHeadMap = new HashMap<String, List<String>>();
		reqHeadMap.put("Content-Type", Collections.singletonList("text/xml"));
		reqHeadMap.put("Accept", Collections.singletonList("text/xml"));
		reqHeadMap.put("userName", Collections.singletonList("admin"));
		reqHeadMap.put("password", Collections.singletonList("admin"));

		reqCntxMap.put(MessageContext.HTTP_REQUEST_HEADERS,reqHeadMap);
		//reqCntxMap.put(MessageContext.HTTP_REQUEST_METHOD,"GET");

		System.out.println(" output " + helloSecurePort.getUserDetails("Pradhap"));
	}
	
}
