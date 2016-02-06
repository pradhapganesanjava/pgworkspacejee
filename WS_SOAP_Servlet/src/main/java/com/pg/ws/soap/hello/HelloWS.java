package com.pg.ws.soap.hello;
import javax.jws.WebService;

@WebService
public class HelloWS {

	public String sayHello(String name) {

		return "Helloooo " + name;

	}

}
