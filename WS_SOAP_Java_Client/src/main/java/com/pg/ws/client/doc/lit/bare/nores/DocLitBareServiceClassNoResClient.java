package com.pg.ws.client.doc.lit.bare.nores;

import com.pg.ws.stub.doclitbare.noresp.DocLitBareServiceClass;
import com.pg.ws.stub.doclitbare.noresp.DocLitBareServiceClassService;
import com.pg.ws.stub.doclitbare.noresp.UserBo;


/*
 * 
 * wsimport file:src/main/resources/wsdl/DocLitWrap/DocLitWrapServiceClassService.wsdl -keep -s src/main/java -p com.pg.ws.stub.doclitwrap -Xnocompile -verbose

com\pg\ws\stub\doclitwrap\DocLitWrapServiceClass.java
com\pg\ws\stub\doclitwrap\DocLitWrapServiceClassService.java
com\pg\ws\stub\doclitwrap\GetUserDetails.java
com\pg\ws\stub\doclitwrap\GetUserDetailsResponse.java
com\pg\ws\stub\doclitwrap\ObjectFactory.java
com\pg\ws\stub\doclitwrap\UserBo.java
com\pg\ws\stub\doclitwrap\package-info.java

 */
public class DocLitBareServiceClassNoResClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DocLitBareServiceClassService sib = new DocLitBareServiceClassService();
		DocLitBareServiceClass sei = sib.getPort(DocLitBareServiceClass.class);
		UserBo setUserDetailsNoResp = new UserBo();
		sei.setUserDetailsNoResp(setUserDetailsNoResp);
		System.out.println(" ");
		
		

	}

}
