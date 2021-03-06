
package com.pg.ws.stub.doclitbare.inout;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "DocLitBare_InOutParam_ServiceClassService", targetNamespace = "http://bare.lit.doc.service.ws.pg.com/", wsdlLocation = "file:/A:/projects/pgworkspacejee/WS_SOAP_Java_Client/src/main/resources/wsdl/DocLitBare/DocLitBare_InOutParam_ServiceClassService.wsdl")
public class DocLitBareInOutParamServiceClassService
    extends Service
{

    private final static URL DOCLITBAREINOUTPARAMSERVICECLASSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.pg.ws.stub.doclitbare.inout.DocLitBareInOutParamServiceClassService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.pg.ws.stub.doclitbare.inout.DocLitBareInOutParamServiceClassService.class.getResource(".");
            url = new URL(baseUrl, "file:/A:/projects/pgworkspacejee/WS_SOAP_Java_Client/src/main/resources/wsdl/DocLitBare/DocLitBare_InOutParam_ServiceClassService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/A:/projects/pgworkspacejee/WS_SOAP_Java_Client/src/main/resources/wsdl/DocLitBare/DocLitBare_InOutParam_ServiceClassService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        DOCLITBAREINOUTPARAMSERVICECLASSSERVICE_WSDL_LOCATION = url;
    }

    public DocLitBareInOutParamServiceClassService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DocLitBareInOutParamServiceClassService() {
        super(DOCLITBAREINOUTPARAMSERVICECLASSSERVICE_WSDL_LOCATION, new QName("http://bare.lit.doc.service.ws.pg.com/", "DocLitBare_InOutParam_ServiceClassService"));
    }

    /**
     * 
     * @return
     *     returns DocLitBareInOutParamServiceClass
     */
    @WebEndpoint(name = "DocLitBare_InOutParam_ServiceClassPort")
    public DocLitBareInOutParamServiceClass getDocLitBareInOutParamServiceClassPort() {
        return super.getPort(new QName("http://bare.lit.doc.service.ws.pg.com/", "DocLitBare_InOutParam_ServiceClassPort"), DocLitBareInOutParamServiceClass.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DocLitBareInOutParamServiceClass
     */
    @WebEndpoint(name = "DocLitBare_InOutParam_ServiceClassPort")
    public DocLitBareInOutParamServiceClass getDocLitBareInOutParamServiceClassPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://bare.lit.doc.service.ws.pg.com/", "DocLitBare_InOutParam_ServiceClassPort"), DocLitBareInOutParamServiceClass.class, features);
    }

}
