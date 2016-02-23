package com.pg.ws.client.calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Binding;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

import com.pg.ws.handler.calculator.CalculatorServiceHandleResolver;
import com.pg.ws.handler.calculator.CalculatorServiceLogHandler;
import com.pg.ws.handler.calculator.CalculatorServiceMsgHandler;

public class CalculatorServiceDispatchClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		URL url = new URL("http://tfitdevdt87442:7777/WS_SOAP_Service_Simple/CalculatorServiceImplService?wsdl");
		
		QName serviceQName = new QName("http://calculator.demo.service.ws.pg.com/","CalculatorServiceImplService");
		QName portQName = new QName("http://calculator.demo.service.ws.pg.com/","CalculatorServiceImplPort");
		
		Service service = Service.create(url,serviceQName);
		
		//handlerOnService(service);
		
		Dispatch<SOAPMessage> dispatch = service.createDispatch(portQName, SOAPMessage.class, Service.Mode.MESSAGE);
		Binding binding = dispatch.getBinding();
		
		//handlerOnBinding(binding);
		
		SOAPMessage soapMsg = createSOAPReq();
				
		SOAPMessage soapMsgReturn = dispatch.invoke(soapMsg);
		
		/*System.out.println("\nResponse: ");
		soapMsgReturn.writeTo(System.out);*/
		
		//soapMsgExtract(dispatch,soapMsgReturn);
		
	}

	private static void handlerOnBinding(Binding binding) {
		List<Handler> chain = new ArrayList<Handler>();
		chain.add(new CalculatorServiceLogHandler());
		chain.add(new CalculatorServiceMsgHandler());
		binding.setHandlerChain(chain);
	}

	private static SOAPMessage createSOAPReq() throws SOAPException {
		MessageFactory msgFactory = MessageFactory.newInstance();
		SOAPMessage soapMsg = msgFactory.createMessage();
		SOAPPart soapPart = soapMsg.getSOAPPart();
		SOAPEnvelope soapEnv =  soapPart.getEnvelope();

		SOAPBody soapBody = soapEnv.getBody();
		SOAPElement soapBodyElm = soapBody.addChildElement(new QName("http://calculator.demo.service.ws.pg.com/","squareOf")).addTextNode("12");
		soapMsg.saveChanges();
		return soapMsg;
	}

	private static void handlerOnService(Service service) {
		service.setHandlerResolver(new CalculatorServiceHandleResolver());
	}

	private static void soapMsgExtract(Dispatch<SOAPMessage> dispatch,SOAPMessage soapMsgReturn)
			throws SOAPException {
		
		
		while(soapMsgReturn.getSOAPPart().getEnvelope().getBody().getChildElements().hasNext()){
			SOAPElement soapElm = (SOAPElement)soapMsgReturn.getSOAPPart().getEnvelope().getBody().getChildElements().next();
			
			System.out.println("nodeName: "+soapElm.getNodeName());
			System.out.println("nodeValue "+soapElm.getNodeValue());
			break;
		}
	}

}
