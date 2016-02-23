package com.pg.ws.client.hellorest;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

public class HelloRest {

	public static void main(String... str) throws Exception {

		String endpointAddress = "http://localhost:8080/WS_REST_Service/wsrest/count";
		String serviceNameSpace = "count";
		String portNameSpace = "count";
		QName serviceQName = new QName(serviceNameSpace, "count");
		QName portQName = new QName(portNameSpace, "count");

		Service service = Service.create(serviceQName);
		service.addPort(portQName, HTTPBinding.HTTP_BINDING, endpointAddress);
		Dispatch<Source> dispatch = service.createDispatch(portQName,
				Source.class, Service.Mode.MESSAGE);
		dispatch.getRequestContext().put(MessageContext.HTTP_REQUEST_METHOD,
				"GET");
		Source resultSrc = dispatch.invoke(null);
		
		if (resultSrc instanceof StreamSource) {
			byte[] bufByte = new byte[1024];
			int length = 0;
			while( (length = ((StreamSource) resultSrc).getInputStream().read(bufByte))!=-1){
				System.out.println(" result : "+new String(bufByte));
			}
			
		}

	}

}
