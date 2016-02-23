package com.pg.ws.client.doc.lit.bare;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import com.pg.ws.stub.doclitbare.DocLitBareServiceClass;
import com.pg.ws.stub.doclitbare.DocLitBareServiceClassService;




/*
 * 
 * wsimport file:src/main/resources/wsdl/DocLitBare/DocLitBareServiceClassService.wsdl -keep -s src/main/java -p com.pg.ws.stub.doclitbare -Xnocompile -verbose

com\pg\ws\stub\doclitwrap\DocLitWrapServiceClass.java
com\pg\ws\stub\doclitwrap\DocLitWrapServiceClassService.java
com\pg\ws\stub\doclitwrap\GetUserDetails.java
com\pg\ws\stub\doclitwrap\GetUserDetailsResponse.java
com\pg\ws\stub\doclitwrap\ObjectFactory.java
com\pg\ws\stub\doclitwrap\UserBo.java
com\pg\ws\stub\doclitwrap\package-info.java

 */
public class DocLitBareServiceClassClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DocLitBareServiceClassService sib = new DocLitBareServiceClassService();
		DocLitBareServiceClass sei = sib.getPort(DocLitBareServiceClass.class);
		/*GetUserDetails userDetail = new GetUserDetails();
		UserBo userBo = new UserBo();
		
		userDetail.setArg0(userBo);*/
		
		((BindingProvider) sei)
				.getRequestContext()
				.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
						"http://localhost:7777/doclitbaretest/DocLitBareServiceClassService");
		
		sei.getUserDetails(new Holder<Integer>(10),new Holder<String>("pradhap"),new Holder<Double>(10.0));
		
		

	}

}
