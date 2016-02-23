package com.pg.ws.client.attach.helloswa;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class HelloSwAServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:5556/helloswaservice/HelloSwAServiceService");
		String endpointAddress = "http://localhost:5556/helloswaservice/HelloSwAServiceService";
		QName serviceQName = new QName("http://helloswa.attach.service.ws.pg.com","HelloSwAServiceService");
		QName portQName = new QName("http://helloswa.attach.service.ws.pg.com","HelloSwAServicePort");
		Service service = Service.create(serviceQName);
		service.addPort(portQName, SOAPBinding.SOAP11HTTP_BINDING,endpointAddress);
		
		//single thread model
		service.setExecutor(null);
		Dispatch dispatch = service.createDispatch(portQName, SOAPMessage.class, Service.Mode.MESSAGE);
		
		dispatch.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:7777/helloswaservice/HelloSwAServiceService");
		
		MessageFactory msgFact = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL);
		SOAPMessage soapMsg = msgFact.createMessage();
		SOAPBody soapBody = soapMsg.getSOAPPart().getEnvelope().getBody();
		String namespaceURI = "http://helloswa.attach.service.ws.pg.com";
		SOAPBodyElement bodyElm = soapBody.addBodyElement(new QName(namespaceURI,"invoke","swa"));
		SOAPElement bodyChildElm = bodyElm.addChildElement(new QName(namespaceURI, "test", "swa"));
		bodyChildElm.addTextNode("test swa");
		soapMsg.saveChanges();
		
		dispatch.invoke(soapMsg);
		

	}

}
