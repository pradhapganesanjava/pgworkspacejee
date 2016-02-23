package com.pg.ws.service.doc.lit.bare;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;


public class DocLitBareServiceEndpoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		try {
			HttpServer httpServer = HttpServer.create(new InetSocketAddress(
					6003), 10);
			httpServer.setExecutor(Executors.newFixedThreadPool(10));
			httpServer.start();

			HttpContext httpContext = httpServer.createContext("/barenoresp");
			Endpoint endpoint = Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING,
					new DocLitBareServiceClass());
			endpoint.publish(httpContext);
			System.out.println("http://localhost:6003/barenoresp is created" );
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
