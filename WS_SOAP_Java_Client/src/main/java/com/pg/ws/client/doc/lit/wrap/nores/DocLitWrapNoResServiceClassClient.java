package com.pg.ws.client.doc.lit.wrap.nores;

import com.pg.ws.stub.doclitwrap.nores.DocLitWrapNoResServiceClass;
import com.pg.ws.stub.doclitwrap.nores.DocLitWrapNoResServiceClassService;
import com.pg.ws.stub.doclitwrap.nores.UserBo;

public class DocLitWrapNoResServiceClassClient {

	/**
	 * 
	 * wsimport file:src/main/resources/wsdl/DocLitWrap/nores/DocLitWrapNoResServiceClassService.wsdl -keep -s src/main/java -p com.pg.ws.stub.doclitwrap.nores -Xnocompile -verbose
	 * 

		com\pg\ws\stub\doclitwrap\nores\DocLitWrapNoResServiceClass.java
		com\pg\ws\stub\doclitwrap\nores\DocLitWrapNoResServiceClassService.java
		com\pg\ws\stub\doclitwrap\nores\ObjectFactory.java
		com\pg\ws\stub\doclitwrap\nores\SetUserDetails.java
		com\pg\ws\stub\doclitwrap\nores\SetUserDetailsResponse.java
		com\pg\ws\stub\doclitwrap\nores\UserBo.java
		com\pg\ws\stub\doclitwrap\nores\package-info.java

	 * @param args
	 */
	public static void main(String[] args) {

		DocLitWrapNoResServiceClassService sib = new DocLitWrapNoResServiceClassService();
		DocLitWrapNoResServiceClass sei = sib.getPort(DocLitWrapNoResServiceClass.class);
		UserBo arg0 = new UserBo();
		sei.setUserDetails(arg0);
	}

}
