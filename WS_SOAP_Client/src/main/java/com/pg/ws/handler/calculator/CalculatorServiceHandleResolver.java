package com.pg.ws.handler.calculator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class CalculatorServiceHandleResolver implements HandlerResolver{
	
	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
	
		List<Handler> handlers = new ArrayList<Handler>();
		handlers.add(new CalculatorServiceMsgHandler());
		handlers.add(new CalculatorServiceLogHandler());
		
		return handlers;
	}
	
	

}
