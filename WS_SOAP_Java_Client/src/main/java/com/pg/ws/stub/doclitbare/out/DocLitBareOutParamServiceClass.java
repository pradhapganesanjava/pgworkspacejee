
package com.pg.ws.stub.doclitbare.out;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "DocLitBare_OutParam_ServiceClass", targetNamespace = "http://bare.lit.doc.service.ws.pg.com/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DocLitBareOutParamServiceClass {


    /**
     * 
     * @return
     *     returns com.pg.ws.stub.doclitbare.out.UserBo
     */
    @WebMethod
    @WebResult(name = "getTopUserDetailsOutResponse", targetNamespace = "http://bare.lit.doc.service.ws.pg.com/", partName = "getTopUserDetailsOutResponse")
    public UserBo getTopUserDetailsOut();

}
