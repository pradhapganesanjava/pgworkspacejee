package com.pg.ws.client.hellows;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import com.pg.ws.stub.hellows.HelloWS;
import com.pg.ws.stub.hellows.HelloWSService;

@WebServlet(name = "hellowsclient", loadOnStartup = 1, urlPatterns = "/hello")
public class HelloWSClientServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Init hellowsclient configured ");
		super.init(arg0);
	}
	//@WebServiceRef(value=HelloWSService.class,wsdlLocation="http://localhost:8080/WS_SOAP_Servlet/hello?wsdl")
	//@WebServiceRef(value=HelloWSService.class,wsdlLocation="WEB-INF/classes/wsdl/HelloWS/HelloWS.wsdl")
	@WebServiceRef(value=HelloWSService.class) //value MUST; type is optional
	HelloWS helloWSType_WSRefType;
	
	@WebServiceRef(type=HelloWS.class) //value MUST not; type is optional
	HelloWSService helloSEI_WSRefClass;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Hit the servlet doGet invoked");

		String stubWSStr = "N/A";
		String wsRefStr = "N/A";
		String wsRefTypeStr = "N/A"; 
		
		HelloWSService helloWS = new HelloWSService();
		HelloWS helloSEI = helloWS.getPort(HelloWS.class);
		stubWSStr = helloSEI.sayHello("PRADHAP");
		
		
		HelloWS helloSEI_WSRef = helloSEI_WSRefClass.getPort(HelloWS.class);
		wsRefStr  = helloSEI_WSRef.sayHello("WebServiceRef");
		
		wsRefTypeStr = helloWSType_WSRefType.sayHello("helloWSType_WSRefType");
		
		PrintWriter pw = resp.getWriter();
		pw.print("Hello hellowsclient");
		pw.print("Web service response.........>");
		pw.print("stubWSStr: "+stubWSStr+"\n");
		pw.print("wsRefStr: "+wsRefStr+"\n");
		pw.print("wsRefTypeStr 2: "+wsRefTypeStr+"\n");
		pw.print("<..........");
		pw.close();

	}

}
