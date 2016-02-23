package com.pg.ws.service.doc.lit.wrap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.pg.ws.service.util.EndpointPublisher;

@WebService
public class DocLitWrap_Params_ServiceClass {

	public UserBo createUser(String name, int age, Double salary){
		UserBo userBo = new UserBo(name,age,salary);
		System.out.println("UserBo object created SUCCESSFULLY...!!!");
		return userBo;
	}
	
	@WebMethod(exclude=true)
	public static void main(String...str){
		EndpointPublisher.main("6001","/doclitwrapparam","com.pg.ws.service.doc.lit.wrap.DocLitWrap_Params_ServiceClass");
	}
}
