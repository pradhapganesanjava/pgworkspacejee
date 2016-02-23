package com.pg.ws.service.demo.calculator;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(endpointInterface = "com.pg.ws.service.demo.calculator.CalculatorService")
public class CalculatorServiceImpl {

	public String squareOf(String input) {
		System.out.println("squareOf: " + input);
		Double dbl = new Double(input);
		dbl = dbl * dbl;
		return dbl.toString();

	}

	public String squareRootOf(String input) {
		System.out.println("squareRootOf: " + input);
		Double dbl = new Double(input);
		dbl = Math.sqrt(dbl);
		return dbl.toString();
	}

	public String convertToHex(String input) {
		System.out.println("convertToHex: " + input);
		return Double.toHexString(new Double(input));
	}

	public String convertToBinary(String input) {
		System.out.println("convertToBinary: " + input);
		Double dbl = new Double(input);
		int intVal = new Integer(String.format("%1.0f", dbl)).intValue();

		return Integer.toBinaryString(intVal);
	}

}
