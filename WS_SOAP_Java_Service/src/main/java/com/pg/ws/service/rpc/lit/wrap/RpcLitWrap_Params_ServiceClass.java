package com.pg.ws.service.rpc.lit.wrap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.pg.ws.service.doc.lit.wrap.UserBo;
import com.pg.ws.service.util.EndpointPublisher;

@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC,use=SOAPBinding.Use.LITERAL,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public class RpcLitWrap_Params_ServiceClass {

	/**
	 * @param args
	 */

	public UserBo createUser(String name, int age, Double salary){
		UserBo userBo = new UserBo(name,age,salary);
		System.out.println("UserBo object created SUCCESSFULLY...!!!");
		return userBo;
	}
	
	@WebMethod(exclude=true)
	public static void main(String...str){
		EndpointPublisher.main("6002","\rpclitwrapparam","com.pg.ws.service.rpc.lit.wrap.RpcLitWrap_Params_ServiceClass");
	}
}
