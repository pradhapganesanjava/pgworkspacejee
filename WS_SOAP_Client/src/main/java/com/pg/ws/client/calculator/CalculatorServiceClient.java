package com.pg.ws.client.calculator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

import com.pg.ws.handler.calculator.CalculatorServiceHandleResolver;
import com.pg.ws.handler.calculator.CalculatorServiceLogHandler;
import com.pg.ws.handler.calculator.CalculatorServiceMsgHandler;
import com.pg.ws.stub.calculator.CalculatorService;
import com.pg.ws.stub.calculator.CalculatorServiceImplService;

public class CalculatorServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CalculatorServiceImplService calculatorSEI = new CalculatorServiceImplService();
		
		//handlersOnService(calculatorSEI);
		CalculatorService calculatorService = calculatorSEI.getPort(CalculatorService.class);
		
		List<Handler> handlers = new ArrayList<Handler>();
			handlers.add(new CalculatorServiceLogHandler());
			handlers.add(new CalculatorServiceMsgHandler());
		Binding proxyBinding = ((BindingProvider)calculatorService).getBinding();
		
		handlersOnBinding(handlers, proxyBinding);
		
		((BindingProvider)calculatorService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY
					, "http://tfitdevdt87442:7777/WS_SOAP_Service_Simple/CalculatorServiceImplService");
		
		System.out.println("client squareOf "+calculatorService.squareOf("100"));

	}

	private static void handlersOnBinding(List<Handler> handlers,
			Binding proxyBinding) {
		proxyBinding.setHandlerChain(handlers);
	}

	private static void handlersOnService(
			Service srvSEI) {
		srvSEI.setHandlerResolver(new CalculatorServiceHandleResolver());
	}

}
