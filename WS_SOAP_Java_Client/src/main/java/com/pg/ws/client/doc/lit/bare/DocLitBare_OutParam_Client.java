package com.pg.ws.client.doc.lit.bare;

import com.pg.ws.stub.doclitbare.out.DocLitBareOutParamServiceClass;
import com.pg.ws.stub.doclitbare.out.DocLitBareOutParamServiceClassService;
import com.pg.ws.stub.doclitbare.out.UserBo;

public class DocLitBare_OutParam_Client {

	/**

		wsimport file:src/main/resources/wsdl/DocLitBare/DocLitBare_OutParam_ServiceClassService.wsdl -keep -s src/main/java -p com.pg.ws.stub.doclitbare.out -verbose -Xnocompile 
	
		com\pg\ws\stub\doclitbare\out\DocLitBareOutParamServiceClass.java
		com\pg\ws\stub\doclitbare\out\DocLitBareOutParamServiceClassService.java
		com\pg\ws\stub\doclitbare\out\ObjectFactory.java
		com\pg\ws\stub\doclitbare\out\UserBo.java
		com\pg\ws\stub\doclitbare\out\package-info.java
 
	 * @param args
	 */
	public static void main(String[] args) {

		DocLitBareOutParamServiceClassService sib = new DocLitBareOutParamServiceClassService();
		DocLitBareOutParamServiceClass sei = sib.getPort(DocLitBareOutParamServiceClass.class);
		UserBo userBo =  sei.getTopUserDetailsOut();
		
	}

}
