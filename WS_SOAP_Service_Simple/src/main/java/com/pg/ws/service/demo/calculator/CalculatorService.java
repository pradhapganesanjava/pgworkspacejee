package com.pg.ws.service.demo.calculator;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.soap.Addressing;

@WebService
@Addressing
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CalculatorService {

	public String squareOf(String input);
	public String squareRootOf(String input);
	public String convertToHex(String input);
	public String convertToBinary(String input);
	
}
