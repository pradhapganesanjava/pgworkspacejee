package com.pg.util.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;

public class XMLFileUtil{

	public static InputStream getResourceAsStream(String fullPath) throws Exception{
		return XMLFileUtil.class.getClassLoader().getResourceAsStream(fullPath);
	}
	
	public static String getResourceAsString(String fullPath) throws Exception{
		ClassLoader currentClassLoader = new XMLFileUtil().getClass().getClassLoader();
		//currentClassLoader.getResource(name)
		InputStream inStream = currentClassLoader.getResourceAsStream(fullPath);
		BufferedReader bufRead = new BufferedReader(new InputStreamReader(inStream,"UTF-8"));
		
		StringBuffer strBuf = new StringBuffer();
		String readString = null;
		String readLine = null;
		while( (readLine = bufRead.readLine())!=null){
			strBuf.append(readLine);
		}
		readString = strBuf.toString();
		return readString;
	}

	public static String readFileToString(String fullPath) throws Exception {
		File file = new File(fullPath);
		BufferedReader bufRead = new BufferedReader(new FileReader(file));
		StringBuffer strBuf = new StringBuffer();
		String readString = null;
		String readLine = null;
		while ((readLine = bufRead.readLine()) != null) {
			strBuf.append(readLine);
		}
		readString = strBuf.toString();
		return readString;

	}

	public static InputStream readFileToStream(String fullPath) throws Exception {
		File file = new File(fullPath);
		FileInputStream finStream = new FileInputStream(file);
		return finStream;
	}
	
	public static DOMSource fileToDomSrc(String path) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		Document document = builder.parse("file:///music/order/soap.xml");
		DOMSource domSource = new DOMSource(document);
		return domSource;
	}
	
	public static void main(String... str) throws Exception{
		String fullpath = "A:/projects/pgworkspacejee/WS_SOAP_Client/src/main/resources/soap/HelloSecure/HelloSecure_Req.xml";
		String path = "/HelloSecure_Req.xml";
		
		readFileToString(fullpath);
		
		/*ClassLoader currentClassLoader = new XMLFileUtil().getClass().getClassLoader();
		ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();
		URL url1 = currentClassLoader.getResource("/HelloSecure_Req.xml");
		URL url2 = currentClassLoader.getResource("HelloSecure_Req.xml");
		URL url3 = currentClassLoader.getResource("./HelloSecure_Req.xml");
		URL url4 = currentClassLoader.getResource("/WS_SOAP_Client/src/main/resources/soap/HelloSecure/HelloSecure_Req.xml");
		URL url5 = currentClassLoader.getResource("WS_SOAP_Client/src/main/resources/soap/HelloSecure/HelloSecure_Req.xml");
		URL url6 = currentClassLoader.getResource("/src/main/resources/soap/HelloSecure/HelloSecure_Req.xml");
		URL url7 = currentClassLoader.getResource("src/main/resources/soap/HelloSecure/HelloSecure_Req.xml");
		

		URL thUrl1 = threadClassLoader.getResource("/HelloSecure_Req.xml");
		URL thurl2 = threadClassLoader.getResource("HelloSecure_Req.xml");
		URL thurl3 = threadClassLoader.getResource("./HelloSecure_Req.xml");*/
		
		System.out.println("output "+getResourceAsString(path));
	}
}
