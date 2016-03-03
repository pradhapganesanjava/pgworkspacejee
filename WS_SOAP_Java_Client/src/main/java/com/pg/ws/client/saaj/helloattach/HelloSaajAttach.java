package com.pg.ws.client.saaj.helloattach;

import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;

public class HelloSaajAttach {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		SOAPConnectionFactory connFact = SOAPConnectionFactory.newInstance();
		SOAPConnection soapCon = connFact.createConnection();
		SOAPMessage soapMsgReq = creatSOAPMessageReq();
		
		addAttachmentPart(soapMsgReq);
		
		//java.net.URL url = new java.net.URL("http://localhost:7777/helloswaservice/HelloSwAServiceService");

		java.net.URL url = new java.net.URL("http://localhost:7777/helloswapayloadservice/HelloSwAPayloadServiceService");
							// http://localhost:5559/helloswapayloadservice/HelloSwAPayloadServiceService
		
		soapCon.call(soapMsgReq, url);
		
		soapCon.close();
		
	}

	private static void addAttachmentPart(SOAPMessage soapMsgReq) {
		AttachmentPart attachPart = soapMsgReq.createAttachmentPart();
		attachPart.setMimeHeader("Content-Type","application/xml");
		//attachPart.setContentType("text/plain");
		attachPart.setContent("content IS PART OF ATTACHMENT", "text/plain");
		attachPart.setContentId("test attach contentId");
		soapMsgReq.addAttachmentPart(attachPart);
		
	}

	private static SOAPMessage creatSOAPMessageReq() throws Exception{
		
		MessageFactory msgFact = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL);
		SOAPMessage soapMsg = msgFact.createMessage();
		SOAPBody soapBody = soapMsg.getSOAPPart().getEnvelope().getBody();
		String namespaceURI = "http://helloswa.attach.service.ws.pg.com";
		SOAPBodyElement bodyElm = soapBody.addBodyElement(new QName(namespaceURI,"invoke","swa"));
		SOAPElement bodyChildElm = bodyElm.addChildElement(new QName(namespaceURI, "test", "swa"));
		bodyChildElm.addTextNode("test swa");
		soapMsg.saveChanges();
		
		return soapMsg;
		
	}
}
