package com.pg.ws.handler.calculator;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class CalculatorServiceMsgHandler implements SOAPHandler<SOAPMessageContext> {
	
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println(" msgHandler ");
		try{
		SOAPMessage soapMsg = context.getMessage();
		/*SOAPPart soapPart = soapMsg.getSOAPPart();
		SOAPBody soapBody = soapMsg.getSOAPBody();
		
			SOAPElement sElement = (SOAPElement)soapBody.getChildElements().next();
			System.out.println(" "+sElement.getTagName());*/
			if((Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
				System.out.println("\nRequest: ");
			}else{
				System.out.println("\nResponse: ");
			}
			soapMsg.writeTo(System.out);
		
		
		}catch(Exception e){
			System.out.println(" "+e);
		}
		return true;
	}
	
	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean handleFault(SOAPMessageContext context){
		return false;
	}
	
	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

}
