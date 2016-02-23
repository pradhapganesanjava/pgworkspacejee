package com.pg.ws.client.helloprovider;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

public class HelloWsProviderClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			//fromJavaRanch();
			//usingNmspURLBoth();			
			

			URL url = new URL("http://pg.ws.provider");
			String nameSpaceURI = "http://pg.ws.provider";
			
			String endPoint = "http://localhost:7780/WS_SOAP_Service/hellowsprovider";
			
			//QName serviceName = new QName("HelloWSProviderService",url.toString());
			QName serviceName = new QName(nameSpaceURI,"HelloWSProviderService");
			
			//QName portName = new QName("HelloWSProviderServicePort",url.toString());
			QName portName = new QName(nameSpaceURI,"HelloWSProviderServicePort");
			
			Service service = Service.create(serviceName);
				System.out.println("service instance created");
				
			service.addPort(portName, HTTPBinding.HTTP_BINDING, endPoint);
				System.out.println("port added");
				
			Dispatch<Source> dispatch = service.createDispatch(portName, Source.class,Service.Mode.PAYLOAD);
				System.out.println("dispatch created");
			
				/*((BindingProvider)dispatch.getBinding()).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPoint);
				dispatch.getRequestContext().put(MessageContext.HTTP_REQUEST_METHOD, "GET");*/
				
			Source result = dispatch.invoke(new StreamSource("Pradhap Here"));
				System.out.println("Successfully invoked provider ws");
				System.out.println("result "+result.toString());
					
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	private static void usingNmspURLBoth() throws MalformedURLException {
		String nmsp = "http://pg.ws.provider";
					
		URL endPoint = new URL("http://localhost:7779/WS_SOAP_Service/hellowsprovider");
		
		QName serviceName = new QName("HelloWSProviderService",nmsp);
		QName portName = new QName("HelloWSProviderServicePort",nmsp);
		
		Service service = Service.create(endPoint,serviceName);
			System.out.println("service instance created");
		service.addPort(portName, HTTPBinding.HTTP_BINDING, nmsp);
			System.out.println("port added");
		Dispatch<Source> dispatch = service.createDispatch(portName, Source.class,Service.Mode.PAYLOAD);
			System.out.println("dispatch created");
		Source result = dispatch.invoke(new StreamSource("Pradhap Here"));
			System.out.println("Successfully invoked provider ws");
			System.out.println("result "+result.toString());
	}

	private static void fromJavaRanch() throws MalformedURLException {
		URL url = new URL("http://pg.ws.provider");
		
		String endPoint = "http://localhost:7779/WS_SOAP_Service/hellowsprovider";
		
		QName serviceName = new QName("HelloWSProviderService",url.toString());
		QName portName = new QName("HelloWSProviderServicePort",url.toString());
		
		Service service = Service.create(serviceName);
			System.out.println("service instance created");
		service.addPort(portName, HTTPBinding.HTTP_BINDING, endPoint);
			System.out.println("port added");

		Dispatch<Source> dispatch = service.createDispatch(portName, Source.class,Service.Mode.PAYLOAD);
			System.out.println("dispatch created");
		Source result = dispatch.invoke(new StreamSource("Pradhap Here"));
			System.out.println("Successfully invoked provider ws");
			System.out.println("result "+result.toString());
	}
}
