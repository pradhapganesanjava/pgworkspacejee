package com.pg.ws.client;

import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceRef;

import com.pg.ws.stub.doclitbare.DocLitBareServiceClass;
import com.pg.ws.stub.doclitbare.DocLitBareServiceClassService;

/**
 * Hello world!
 *
 */
public class App 
{
	
	@WebServiceRef(wsdlLocation="http://localhost:6668/doclitbaretest/DocLitBareServiceClassService?wsdl")
	static DocLitBareServiceClassService sib;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        DocLitBareServiceClass sei = sib.getPort(DocLitBareServiceClass.class);
        sei.getUserDetails(new Holder<Integer>(0), new Holder<String>("pradhap"), new Holder<Double>(10.1));
        System.out.println("success ");
    }
}
