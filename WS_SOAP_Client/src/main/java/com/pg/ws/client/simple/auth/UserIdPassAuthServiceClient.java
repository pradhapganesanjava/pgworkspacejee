package com.pg.ws.client.simple.auth;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import com.pg.ws.stub.simpleauth.UserAuth;
import com.pg.ws.stub.simpleauth.UserBO;
import com.pg.ws.stub.simpleauth.UserIdPassAuthService;

public class UserIdPassAuthServiceClient {

	/**
	 * 
	 * wsimport file:src/main/resources/wsdl/simpleauth/UserAuth.wsdl -s
	 * src/main/java -p com.pg.ws.stub.simpleauth -keep -Xnocompile -verbose
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserAuth userAuthSIB = new UserAuth();
		UserIdPassAuthService userAuthSEI = userAuthSIB.getPort(UserIdPassAuthService.class);
		
		BindingProvider bindProvider = ((BindingProvider)userAuthSEI);
		
		bindProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://tfitdevdt87442:7777/WS_SOAP_Service_Simple/UserAuth");
		System.out.println(" endpoint ref "+ bindProvider.getEndpointReference());
		
		Map reqMap = (Map)((BindingProvider)userAuthSEI).getRequestContext();
		reqMap.put(BindingProvider.USERNAME_PROPERTY, "admin");
		reqMap.put(BindingProvider.PASSWORD_PROPERTY, "admin");
		
		UserBO userBo = new UserBO();
		userBo.setUserId("admin");
		userBo.setPassword("admin");
		String result = userAuthSEI.isAuthorizedUser(userBo, "access_acc");
		
		System.out.println("result "+result);
		

	}
}
