package com.pg.ws.rs.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hellorest")
public class HelloRest {
	
	@GET
	public String sayHi(String name){
		return "Hi sayHi..."+name;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHi_DefaultBrows(String name){
		return "Hi sayHi_DefaultBrows..."+name;
	}

}
