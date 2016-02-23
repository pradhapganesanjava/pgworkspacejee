package com.pg.ws.service.attach.helloswa;

import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

import com.pg.ws.service.util.EndpointPublisher;

@WebServiceProvider
@ServiceMode(Mode.MESSAGE)
public class HelloSwAService implements Provider<SOAPMessage> {
	
	@Override
	public SOAPMessage invoke(SOAPMessage request) {

		System.out.println("HelloSwA Invoke is called");
		
		while(request.getAttachments().hasNext()){
			AttachmentPart attPart = (AttachmentPart)request.getAttachments().next();
			System.out.println(" get attachment contentId "+ attPart.getContentId());
		}

		return request;
	}

	public static void main(String...str){
		EndpointPublisher.main("5556","/helloswaservice","com.pg.ws.service.attach.helloswa.HelloSwAService");
	}
	
}
