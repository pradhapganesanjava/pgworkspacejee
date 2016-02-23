package com.pg.ws.service.provider.hello;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.http.HTTPBinding;

import org.w3c.dom.Node;

@ServiceMode(Mode.PAYLOAD)
@BindingType(value = HTTPBinding.HTTP_BINDING)
@WebServiceProvider(serviceName = "HelloWSProviderService", targetNamespace = "http://pg.ws.provider")
public class HelloWSProvider implements Provider<Source> {
	@Override
	public Source invoke(Source request) {
		String uri = "http://pg.ws.provider";
		String prefix = "pg";

		// Converting Source to XML string
		String reqXmlStr = convertSourceToXmlStr(request);
		System.out.println("HelloWSProvider is called");
		try {
			MessageFactory msgFact = MessageFactory.newInstance();
			SOAPMessage soapMsg = msgFact.createMessage();
			SOAPPart soapPart = soapMsg.getSOAPPart();
			SOAPEnvelope soapEnv = soapPart.getEnvelope();
			SOAPHeader soapHead = soapEnv.getHeader();
			SOAPBody soapBody = soapEnv.getBody();

			SOAPHeaderElement headElem = soapHead.addHeaderElement(soapEnv
					.createName("head-sec", prefix, uri));
			headElem.addChildElement("version").addTextNode("1.0");

			SOAPBodyElement bodyElem = soapBody.addBodyElement(soapEnv
					.createName("result", prefix, uri));
			bodyElem.addChildElement("MSG").addTextNode("SUCCESS"+convertSourceToXmlStr(request));
			soapMsg.saveChanges();
			soapMsg.writeTo(System.out);

			ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
			soapMsg.writeTo(byteOS);

			return new StreamSource(byteOS.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * return new StreamSource("Hi... \nYour Request was: " + reqXmlStr +
		 * ".\n It will be processed.");
		 */
		return new StreamSource("exception");
	}

	// Converting Source to XML string
	private String convertSourceToXmlStr(Source request) {
		String reqXmlStr = null;
		try {
			final StringWriter reqXmlStrWriter = new StringWriter();
			final Transformer trans = TransformerFactory.newInstance()
					.newTransformer();
			trans.transform(request, new StreamResult(reqXmlStrWriter));
			reqXmlStr = reqXmlStrWriter.toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return reqXmlStr;
	}

	// Converting Source to DOM
	private Source convertSourceToDOM(Source request) {
		DOMResult dom = new DOMResult();
		try {
			Transformer trans = TransformerFactory.newInstance()
					.newTransformer();
			trans.transform(request, dom);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		Node node = dom.getNode();
		// do something with it ...
		DOMSource src = new DOMSource(node);
		return src;
	}
	// also javax.xml.transform.sax containing SAXResult and SAXSource
}
