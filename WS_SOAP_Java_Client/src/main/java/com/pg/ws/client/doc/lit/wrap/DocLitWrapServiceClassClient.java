package com.pg.ws.client.doc.lit.wrap;

import com.pg.ws.stub.doclitwrap.DocLitWrapServiceClass;
import com.pg.ws.stub.doclitwrap.DocLitWrapServiceClassService;
import com.pg.ws.stub.doclitwrap.UserBo;


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
public class DocLitWrapServiceClassClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DocLitWrapServiceClassService sib = new DocLitWrapServiceClassService();
		DocLitWrapServiceClass sei = sib.getPort(DocLitWrapServiceClass.class);
		UserBo userBo = new UserBo();
		System.out.println(" "+sei.getUserDetails(userBo).toString());;
		
		

	}

}
