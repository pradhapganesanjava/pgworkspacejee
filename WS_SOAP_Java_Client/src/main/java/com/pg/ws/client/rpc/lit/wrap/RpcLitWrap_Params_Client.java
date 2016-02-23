package com.pg.ws.client.rpc.lit.wrap;

import javax.xml.ws.BindingProvider;

import com.pg.ws.stub.rpclitwrap.RpcLitWrapParamsServiceClass;
import com.pg.ws.stub.rpclitwrap.RpcLitWrapParamsServiceClassService;
import com.pg.ws.stub.rpclitwrap.UserBo;

public class RpcLitWrap_Params_Client {

	/**
	 * 
	 * wsimport file:src/main/resources/wsdl/RpcLitWrap/RpcLitWrap_Params_ServiceClass.wsdl -keep -s src/main/java -p com.pg.ws.stub.rpclitwrap -Xnocompile -verbose

		com\pg\ws\stub\rpclitwrap\ObjectFactory.java
		com\pg\ws\stub\rpclitwrap\RpcLitWrapParamsServiceClass.java
		com\pg\ws\stub\rpclitwrap\RpcLitWrapParamsServiceClassService.java
		com\pg\ws\stub\rpclitwrap\UserBo.java
		com\pg\ws\stub\rpclitwrap\package-info.java

	 * @param args
	 */
	public static void main(String[] args) {

		RpcLitWrapParamsServiceClassService sib = new RpcLitWrapParamsServiceClassService();
		RpcLitWrapParamsServiceClass sei = sib.getPort(RpcLitWrapParamsServiceClass.class);
		
		BindingProvider bindingPro = ((BindingProvider) sei);
		bindingPro
				.getRequestContext()
				.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
						"http://localhost:7777/rpclitwrapparam/RpcLitWrap_Params_ServiceClassService");
		
		UserBo userBo = sei.createUser("Pradhap", 22, 10110.0);
		
		
	}

}
