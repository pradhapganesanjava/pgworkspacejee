package com.pg.ws.service.attach.helloswa;

import java.util.Iterator;

import javax.annotation.Resource;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;

import com.pg.ws.service.util.EndpointPublisher;

@WebServiceProvider
@ServiceMode(Mode.PAYLOAD)
public class HelloSwAPayloadService implements Provider<Source> {

	@Resource
	WebServiceContext webSrvCntx;
	
	private final static String PORT_PUBLISH = "5559";
	
	@Override
	public Source invoke(Source request) {

		System.out.println("HelloSwAPayloadService Invoke is called");
		System.out.println("WebServiceContext "+webSrvCntx);
		
		TransformerFactory transFact = TransformerFactory.newInstance();
		

		return request;
	}

	private void updateHeader(SOAPMessage request) {
		try {

			SOAPFactory soapFactory = SOAPFactory.newInstance();
			Name headName = soapFactory.createName("version", "swa", "helloswa.attach.service.ws.pg.com");
			SOAPHeaderElement headElm = request.getSOAPHeader().addHeaderElement(headName);
			Name headAttrName = soapFactory.createName("nillable", "swa", "helloswa.attach.service.ws.pg.com");
			headElm.addAttribute(headAttrName, "false");
			Name headChildName1 = soapFactory.createName("ReleasedDate", "swa", "helloswa.attach.service.ws.pg.com");
			Name headChildName2 = soapFactory.createName("CurrentVersion", "swa", "helloswa.attach.service.ws.pg.com");
			headElm.addChildElement(headChildName1).addTextNode("1/1/2016");
			headElm.addChildElement(headChildName2).addTextNode("1.0");
			
			
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}

	private void printSOAPBodyRequest(SOAPMessage request) {
		try {
			
			Iterator<SOAPBodyElement > soapBodyElmIt = request.getSOAPBody().getChildElements();
			
			while(soapBodyElmIt.hasNext()){
				
				SOAPBodyElement soapBodyElm =  (SOAPBodyElement)soapBodyElmIt.next();
				
				System.out.println("soapBodyElm nodeName "+soapBodyElm.getNodeName());
				System.out.println("soapBodyElm TEXT "+soapBodyElm.getTextContent());
				System.out.println("soapBodyElm value "+soapBodyElm.getValue());
				
				Iterator<SOAPElement> soapElmIt = soapBodyElm.getChildElements();
				while(soapElmIt.hasNext()){
					SOAPElement soapElm = (SOAPElement)soapElmIt.next();
					System.out.println("nodeName "+soapElm.getNodeName());
					System.out.println("nodeType "+soapElm.getNodeType());
					System.out.println("nodeValue "+soapElm.getNodeValue());
					System.out.println("tagName "+soapElm.getTagName());
					System.out.println("value "+soapElm.getValue());
					System.out.println("textContent "+soapElm.getTextContent());
				}
			}
			
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}

	public static void main(String...str){
		EndpointPublisher.main(PORT_PUBLISH,"/helloswapayloadservice","com.pg.ws.service.attach.helloswa.HelloSwAPayloadService");
	}
	
}
