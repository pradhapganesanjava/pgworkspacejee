package com.pg.ws.handler.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.w3c.dom.Node;

public class CalculatorServiceLogHandler implements
		LogicalHandler<LogicalMessageContext> {

	@Override
	public boolean handleMessage(LogicalMessageContext context) {
		System.out.println("LogicalHandler CalculatorServiceLogHandler");

		LogicalMessage logicalMsg = context.getMessage();
		/*Source src = logicalMsg.getPayload();
		DOMSource domSrc = (DOMSource) src;
		Node node = domSrc.getNode();
		System.out.println("text "+node.getTextContent());
		System.out.println("node name "+node.getNodeName());*/

		String readLine = null;
		/*try {
			while ((readLine = bufRead.readLine()) != null) {
				System.out.println("readline "+readLine);
			}
		} catch (Exception e) {
			System.out.println(e);
		}*/

		return true;
	}

	@Override
	public boolean handleFault(LogicalMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {
	}

}
