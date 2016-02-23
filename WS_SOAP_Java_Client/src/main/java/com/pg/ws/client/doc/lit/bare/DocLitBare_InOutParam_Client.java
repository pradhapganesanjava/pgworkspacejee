package com.pg.ws.client.doc.lit.bare;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import com.pg.ws.stub.doclitbare.inout.DocLitBareInOutParamServiceClass;
import com.pg.ws.stub.doclitbare.inout.DocLitBareInOutParamServiceClassService;

/*
 * 
	wsimport file:src/main/resources/wsdl/DocLitBare/DocLitBare_InOutParam_ServiceClassService.wsdl -keep -s src/main/java -p com.pg.ws.stub.doclitbare.inout -Xnocompile -verbose

	com\pg\ws\stub\doclitbare\inout\DocLitBareInOutParamServiceClass.java
	com\pg\ws\stub\doclitbare\inout\DocLitBareInOutParamServiceClassService.java
	com\pg\ws\stub\doclitbare\inout\ObjectFactory.java
	com\pg\ws\stub\doclitbare\inout\UserBo.java
	com\pg\ws\stub\doclitbare\inout\package-info.java
	
 * 
 */
public class DocLitBare_InOutParam_Client {

	public static void main(String...str){
		DocLitBareInOutParamServiceClassService sib = new DocLitBareInOutParamServiceClassService();
		DocLitBareInOutParamServiceClass sei = sib.getPort(DocLitBareInOutParamServiceClass.class);
		
		((BindingProvider) sei)
				.getRequestContext()
				.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
						"http://localhost:7777/doclitbareinout/DocLitBare_InOutParam_ServiceClassService");
		
		Holder holdIntAge = new Holder<Integer>(22);
		Holder holdStrNam = new Holder<String>("Pradhap");
		
		sei.updateUserDetailsInOut(holdIntAge,holdStrNam);
		
		
	}
	
}
