package com.pg.ws.service.doc.lit.wrap.nores;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;


public class DocLitWrapNoResEndpoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		try {
			HttpServer httpServer = HttpServer.create(new InetSocketAddress(
					6004), 10);
			httpServer.setExecutor(Executors.newFixedThreadPool(10));
			httpServer.start();

			HttpContext httpContext = httpServer.createContext("/doclitwrapnores");
			Endpoint endpoint = Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING,
					new DocLitWrapNoResServiceClass());
			endpoint.publish(httpContext);
			
			System.out.println("http://localhost:6004/doclitwrapnores - successful");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
