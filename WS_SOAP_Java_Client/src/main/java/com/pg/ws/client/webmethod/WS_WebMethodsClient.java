package com.pg.ws.client.webmethod;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import com.pg.ws.stub.webmethod.WSWebMethods;
import com.pg.ws.stub.webmethod.WSWebMethodsService;

public class WS_WebMethodsClient {

	/**
	 * [ERROR] duplicate "message" entity: "publicMth"
	 * wsimport file:src/main/resources/wsdl/WebMthOverload/WS_WebMethodsService.wsdl -keep -s src/main/java -p com.pg.ws.stub.webmethod -Xnocompile -verbose 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		proxyCall();
		
		//dispatchInvoke();
		
	}

	private static void proxyCall() throws Exception{
		URL wsdlDocumentLocation = new URL("http://localhost:6565/wswebmethod/WS_WebMethodsService?wsdl");
		QName serviceName = new QName("http://webmethod.service.ws.pg.com/","WS_WebMethodsService");
		//WSWebMethodsService sib = new WSWebMethodsService();
		WSWebMethodsService sib = new WSWebMethodsService(wsdlDocumentLocation,serviceName);
		WSWebMethods sei = sib.getWSWebMethodsPort();
		((BindingProvider) sei).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:7777/wswebmethod/WS_WebMethodsService");
		sei.publicMthOverloaded("HI Pradhap");
	}

	private static void dispatchInvoke() throws MalformedURLException {
		URL wsdlDocumentLocation = new URL("http://localhost:6565/wswebmethod/WS_WebMethodsService?wsdl");
		QName serviceName = new QName("http://webmethod.service.ws.pg.com/","WS_WebMethodsService");
		QName portName = new QName("http://webmethod.service.ws.pg.com/","WS_WebMethodsPort");
		
		Service service = Service.create(wsdlDocumentLocation, serviceName);
		//Service service = new Service(wsdlDocumentLocation, serviceName);
		Dispatch dispatch = service.createDispatch(portName, Source.class, Service.Mode.PAYLOAD);
		dispatch.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:7777/wswebmethod/WS_WebMethodsService");
		
		QName methodName = new QName("http://webmethod.service.ws.pg.com/","publicMth");
		System.out.println("qname "+methodName.toString());
		
		dispatch.invoke(null);
		//dispatch.invoke(new StreamSource("<ns2:publicMthOverloaded xmlns:ns2=\"http://webmethod.service.ws.pg.com/\">"));
	}

}
