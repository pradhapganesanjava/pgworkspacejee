package com.pg.ws.client.attach.helloswa;

import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
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

		//set AttachmentPart
		//imageAttachment(url, msgFact);

		//get AttachmentPart
		//accessingImageAttachment(msgFact);
		
		
		dispatch.invoke(soapMsg);
		

	}

	private static void accessingImageAttachment(MessageFactory msgFact)
			throws SOAPException {
		SOAPMessage message = msgFact.createMessage();
		java.util.Iterator iterator = message.getAttachments();
		while (iterator.hasNext()) {
		    AttachmentPart attachment = (AttachmentPart)iterator.next();
		    String id = attachment.getContentId();
		    String type = attachment.getContentType();
		    System.out.print("Attachment " + id + " has content type " + type);
		    if (type.equals("text/plain")) {
		        Object content = attachment.getContent();
		        System.out.println("Attachment contains:\n" + content);
		    }
		}
	}

	private static void imageAttachment(URL url, MessageFactory msgFact)
			throws SOAPException, MalformedURLException {
		SOAPMessage message = msgFact.createMessage();
		URL imgUrl = new URL("http://greatproducts.com/gizmos/img.jpg");
		DataHandler dataHandler = new DataHandler(url);
		AttachmentPart attachment = message.createAttachmentPart(dataHandler);
		attachment.setContentId("attached_image");

		message.addAttachmentPart(attachment);
	}

}
