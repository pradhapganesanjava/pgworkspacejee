package com.pg.ws.client.doc.lit.wrap;

import javax.xml.ws.BindingProvider;

import com.pg.ws.stub.doclitwrap.DocLitWrapParamsServiceClass;
import com.pg.ws.stub.doclitwrap.DocLitWrapParamsServiceClassService;
import com.pg.ws.stub.doclitwrap.UserBo;

public class DocLitWrap_Params_Client {

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		DocLitWrapParamsServiceClassService sib = new DocLitWrapParamsServiceClassService();
		DocLitWrapParamsServiceClass sei = sib
				.getPort(DocLitWrapParamsServiceClass.class);
		
		BindingProvider bindingPro = ((BindingProvider) sei);
		bindingPro
				.getRequestContext()
				.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
						"http://localhost:7777/doclitwrapparam/DocLitWrap_Params_ServiceClass");
		
		UserBo userBo = sei.createUser("pradhap", 30, 10000.0);

		System.out.println("userBo "+userBo.toString());

	}

}
