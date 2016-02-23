package com.pg.ws.rs.basic.annotation;


import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("singleton")
//@Produces({MediaType.TEXT_PLAIN,MediaType.TEXT_HTML,MediaType.APPLICATION_XML})
@Singleton
public class SingletonRest {

	public SingletonRest() {
		System.out.println("I am basic.annotation.SingletonRest initialized");
	}
	
	private int count;
	
	/*@GET
	public String landingMsg(){
		return "COUNT NUMBER OF HITS";
	}*/
	
	@GET
	//@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public String incrementCount(){
		count = count + 1;
		return "C COUNT NUMBER OF HITS: "+count;
	}
	
	//Default will be called for TEXT/HTML accepts. this method produce TEXT/HTML
	@GET
	public String defaultMth(){
		return "C Default method to produce...";
	}
	
	@Path("/{num1}/{num2}")
	@GET
	public String sum(@PathParam("num1") int number1, @PathParam("num2") int number2){
		return ""+(number1+number2);
	}
}
