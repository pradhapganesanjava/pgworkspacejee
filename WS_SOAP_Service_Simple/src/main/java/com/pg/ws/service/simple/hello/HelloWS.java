package com.pg.ws.service.simple.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWS {

	@WebMethod
	public void sayHi(){
		System.out.println("HI...");
	}
}
