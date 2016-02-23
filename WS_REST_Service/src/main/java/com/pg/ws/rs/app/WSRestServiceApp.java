package com.pg.ws.rs.app;

import java.util.Set;

import javax.imageio.spi.RegisterableService;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;

import com.pg.ws.rs.basic.annotation.SingletonRest;


@ApplicationPath("wsrest")
public class WSRestServiceApp extends Application{

	public WSRestServiceApp() {
		System.out.println("WSRestServiceApp I am initialized");
		//packages("com.pg.ws.rs");
		//register(SingletonRest.class);
	}
	
	//Certain classes to include to be accessible under the resource.
	@Override
	public Set<Class<?>> getClasses() {
		return super.getClasses();
	}
	
}
