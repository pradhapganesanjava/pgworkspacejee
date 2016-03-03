
package com.pg.ws.stub.webmethod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pg.ws.stub.webmethod package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PublicMth_QNAME = new QName("http://webmethod.service.ws.pg.com/", "publicMth");
    private final static QName _PublicMthOverloaded_QNAME = new QName("http://webmethod.service.ws.pg.com/", "publicMthOverloaded");
    private final static QName _PublicMthResponse_QNAME = new QName("http://webmethod.service.ws.pg.com/", "publicMthResponse");
    private final static QName _PublicMthOverloadedResponse_QNAME = new QName("http://webmethod.service.ws.pg.com/", "publicMthOverloadedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pg.ws.stub.webmethod
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PublicMthOverloaded }
     * 
     */
    public PublicMthOverloaded createPublicMthOverloaded() {
        return new PublicMthOverloaded();
    }

    /**
     * Create an instance of {@link PublicMthOverloadedResponse }
     * 
     */
    public PublicMthOverloadedResponse createPublicMthOverloadedResponse() {
        return new PublicMthOverloadedResponse();
    }

    /**
     * Create an instance of {@link PublicMthResponse }
     * 
     */
    public PublicMthResponse createPublicMthResponse() {
        return new PublicMthResponse();
    }

    /**
     * Create an instance of {@link PublicMth }
     * 
     */
    public PublicMth createPublicMth() {
        return new PublicMth();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicMth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webmethod.service.ws.pg.com/", name = "publicMth")
    public JAXBElement<PublicMth> createPublicMth(PublicMth value) {
        return new JAXBElement<PublicMth>(_PublicMth_QNAME, PublicMth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicMthOverloaded }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webmethod.service.ws.pg.com/", name = "publicMthOverloaded")
    public JAXBElement<PublicMthOverloaded> createPublicMthOverloaded(PublicMthOverloaded value) {
        return new JAXBElement<PublicMthOverloaded>(_PublicMthOverloaded_QNAME, PublicMthOverloaded.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicMthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webmethod.service.ws.pg.com/", name = "publicMthResponse")
    public JAXBElement<PublicMthResponse> createPublicMthResponse(PublicMthResponse value) {
        return new JAXBElement<PublicMthResponse>(_PublicMthResponse_QNAME, PublicMthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicMthOverloadedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webmethod.service.ws.pg.com/", name = "publicMthOverloadedResponse")
    public JAXBElement<PublicMthOverloadedResponse> createPublicMthOverloadedResponse(PublicMthOverloadedResponse value) {
        return new JAXBElement<PublicMthOverloadedResponse>(_PublicMthOverloadedResponse_QNAME, PublicMthOverloadedResponse.class, null, value);
    }

}
