package com.pg.ws.client.hellomtom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.pg.ws.stub.hellomtom.HelloMTOMService;
import com.pg.ws.stub.hellomtom.HelloMTOMServiceImplService;

public class HelloMTOMServiceClient {

	/**
	 * 
	 * wsimport file:src/main/resources/wsdl/HelloMTOM/HelloMTOM_DOC_Bare.wsdl
	 * -keep -s src/main/java -p com.pg.ws.stub.hellomtom -Xnocompile -verbose
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		// dispatchInvoke();

		String imgFilePath = "A:\\projects\\pgworkspacejee\\WS_SOAP_Client\\src\\main\\resources\\imgs\\galaxy.jpg";

		HelloMTOMServiceImplService seiImpl = new HelloMTOMServiceImplService();
		HelloMTOMService sei = seiImpl.getPort(HelloMTOMService.class);
		BindingProvider seiBindProvider = ((BindingProvider)sei);
		seiBindProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8888/soap_service/hellomtom");
		SOAPBinding soapBinding = (SOAPBinding) seiBindProvider.getBinding();
		soapBinding.setMTOMEnabled(true);
		System.out.println("MTOM is enabled");
		byte[] imgByteArr = imgToByteArray(imgFilePath);
		sei.uploadImg(imgByteArr);
	}

	private static byte[] imgToByteArray(String imgFilePath) throws Exception {
		File imgFile = new File(imgFilePath);

		// Image imageToUpload = ImageIO.read(imgFile);
		FileInputStream fin = new FileInputStream(imgFile);

		ByteArrayOutputStream bytOutStream = new ByteArrayOutputStream();
		byte[] byteReadData = new byte[1024];
		int lenReadData = 0;
		while ((lenReadData = fin.read(byteReadData)) != -1) {
			bytOutStream.write(byteReadData, 0, lenReadData);
		}
		System.out.println("image converted to byte");
		return bytOutStream.toByteArray();
	}

	private static void dispatchInvoke() throws MalformedURLException {
		URL url = new URL("http://localhost:7783/soap_service/hellomtom?wsdl");
		String endpointAddress = "http://localhost:7783/soap_service/hellomtom";
		QName serviceQName = new QName(
				"http://hellomtom.mtom.service.ws.pg.com/",
				"HelloMTOMServiceImplService");
		QName portQName = new QName("http://hellomtom.mtom.service.ws.pg.com/",
				"HelloMTOMServiceImplPort");

		Service service = Service.create(serviceQName);
		service.addPort(portQName, SOAPBinding.SOAP11HTTP_MTOM_BINDING,
				endpointAddress);

		// Dispatch<SOAPMessage> dispatch = service.createDispatch(portQName,
		// SOAPMessage.class, Service.Mode.MESSAGE);
		Dispatch<Source> dispatch = service.createDispatch(portQName,
				Source.class, Service.Mode.PAYLOAD);

		/*
		 * SOAPMessage soapMessage = null; dispatch.invoke(soapMessage);
		 */
		String msg = null;

		dispatch.invoke(new StreamSource(msg));
	}

}
