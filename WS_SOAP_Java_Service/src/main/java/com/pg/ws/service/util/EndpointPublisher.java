package com.pg.ws.service.util;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.concurrent.Executors;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

public class EndpointPublisher {

	/**
	 * @param args
	 */
	public static void main(String...args) {

		if(!(args.length >=3)){
			System.out.println("INPUT MISSING");
			return;
		}
		String port = args[0];
		String root = args[1];
		String serviceName = args[2];
		
		try {
			HttpServer httpServer = HttpServer.create(new InetSocketAddress(
					new Integer(port).intValue()), 10);
			
			httpServer.setExecutor(Executors.newFixedThreadPool(10));
			httpServer.start();

			HttpContext httpContext = httpServer.createContext(root);
			Endpoint endpoint = Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING,
					Class.forName(serviceName).newInstance());
			endpoint.publish(httpContext);
			
			serviceName = extractServiceName(serviceName);
			
			System.out.println("Publish successfull:\n"+"http:\\\\localhost:"+port+root+"\\"+serviceName+"Service");
			
		} catch (Exception e) {
			System.out.println(" PUBLISH FAILED :( "+e.getMessage());
		}

	}

	private static String extractServiceName(String serviceName) {
		String[] serviceNameArr = serviceName.split("\\.");
		String justServiceName = ((serviceNameArr.length > 0)?serviceNameArr[serviceNameArr.length-1]:null);
		return justServiceName;
	}

}
