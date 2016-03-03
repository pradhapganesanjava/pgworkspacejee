
package com.pg.ws.stub.webmethod;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "WS_WebMethods", targetNamespace = "http://webmethod.service.ws.pg.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSWebMethods {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "publicMth", targetNamespace = "http://webmethod.service.ws.pg.com/", className = "com.pg.ws.stub.webmethod.PublicMth")
    @ResponseWrapper(localName = "publicMthResponse", targetNamespace = "http://webmethod.service.ws.pg.com/", className = "com.pg.ws.stub.webmethod.PublicMthResponse")
    public void publicMth();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "publicMthOverloaded", targetNamespace = "http://webmethod.service.ws.pg.com/", className = "com.pg.ws.stub.webmethod.PublicMthOverloaded")
    @ResponseWrapper(localName = "publicMthOverloadedResponse", targetNamespace = "http://webmethod.service.ws.pg.com/", className = "com.pg.ws.stub.webmethod.PublicMthOverloadedResponse")
    public void publicMthOverloaded(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
