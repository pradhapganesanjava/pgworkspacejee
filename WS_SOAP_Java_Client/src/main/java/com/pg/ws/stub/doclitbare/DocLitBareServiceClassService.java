
package com.pg.ws.stub.doclitbare;

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
@WebServiceClient(name = "DocLitBareServiceClassService", targetNamespace = "http://bare.lit.doc.service.ws.pg.com/", wsdlLocation = "file:/A:/projects/pgworkspacejee/WS_SOAP_Java_Client/src/main/resources/wsdl/DocLitBare/DocLitBareServiceClassService.wsdl")
public class DocLitBareServiceClassService
    extends Service
{

    private final static URL DOCLITBARESERVICECLASSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.pg.ws.stub.doclitbare.DocLitBareServiceClassService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.pg.ws.stub.doclitbare.DocLitBareServiceClassService.class.getResource(".");
            url = new URL(baseUrl, "file:/A:/projects/pgworkspacejee/WS_SOAP_Java_Client/src/main/resources/wsdl/DocLitBare/DocLitBareServiceClassService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/A:/projects/pgworkspacejee/WS_SOAP_Java_Client/src/main/resources/wsdl/DocLitBare/DocLitBareServiceClassService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        DOCLITBARESERVICECLASSSERVICE_WSDL_LOCATION = url;
    }

    public DocLitBareServiceClassService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DocLitBareServiceClassService() {
        super(DOCLITBARESERVICECLASSSERVICE_WSDL_LOCATION, new QName("http://bare.lit.doc.service.ws.pg.com/", "DocLitBareServiceClassService"));
    }

    /**
     * 
     * @return
     *     returns DocLitBareServiceClass
     */
    @WebEndpoint(name = "DocLitBareServiceClassPort")
    public DocLitBareServiceClass getDocLitBareServiceClassPort() {
        return super.getPort(new QName("http://bare.lit.doc.service.ws.pg.com/", "DocLitBareServiceClassPort"), DocLitBareServiceClass.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DocLitBareServiceClass
     */
    @WebEndpoint(name = "DocLitBareServiceClassPort")
    public DocLitBareServiceClass getDocLitBareServiceClassPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://bare.lit.doc.service.ws.pg.com/", "DocLitBareServiceClassPort"), DocLitBareServiceClass.class, features);
    }

}
