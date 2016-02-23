package com.pg.ws.client.hellosecure;

import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.soap.SOAPBinding;

public class HelloSecureDispatchClient {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {

		URL urlWsdl = new URL("http://localhost:7777/WS_SOAP_Service/hellosecure");
		String urlStr = "http://localhost:7777/WS_SOAP_Service/hellosecure";
		
		QName serviceQName = new QName("http://hellosecure.secure.service.ws.pg.com/", "HelloSecureService");
		QName portQName = new QName("http://hellosecure.secure.service.ws.pg.com/", "HelloSecurePort");
		
		Service service = Service.create(serviceQName);
		service.addPort(portQName, SOAPBinding.SOAP12HTTP_BINDING, urlStr);
		Dispatch<SOAPMessage> dispatch = service.createDispatch(portQName, SOAPMessage.class, Service.Mode.MESSAGE);
		Map<String, Object> reqCntx = dispatch.getRequestContext();
		reqCntx.put(MessageContext.HTTP_REQUEST_METHOD,"GET");
		//reqCntx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "admin");
		reqCntx.put(BindingProvider.USERNAME_PROPERTY, "admin");
		reqCntx.put(BindingProvider.PASSWORD_PROPERTY, "admin");
		
		MessageFactory msgFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
		SOAPMessage soapMsg = msgFactory.createMessage();
		SOAPPart soapPart = soapMsg.getSOAPPart();
		SOAPEnvelope soapEnv =  soapPart.getEnvelope();
		SOAPHeader soapHead = soapEnv.getHeader();
		SOAPBody soapBody = soapEnv.getBody();
		SOAPElement soapBodyElm = soapBody.addChildElement("getUserDetails","ns2","http://hellosecure.secure.service.ws.pg.com/");
		soapBodyElm.addChildElement("arg0").addTextNode("Pradhap");
		soapMsg.saveChanges();
		
		
		dispatch.invoke(soapMsg);
		
		//dispatch.invoke(XMLFileUtil.readFileToStream("A:/projects/pgworkspacejee/WS_SOAP_Client/src/main/resources/soap/HelloSecure/HelloSecure_Req.xml"));
		
		
		

	}

}
