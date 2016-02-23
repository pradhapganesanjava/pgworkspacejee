
package com.pg.ws.stub.doclitwrap.nores;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pg.ws.stub.doclitwrap.nores package. 
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

    private final static QName _SetUserDetails_QNAME = new QName("http://nores.wrap.lit.doc.service.ws.pg.com/", "setUserDetails");
    private final static QName _SetUserDetailsResponse_QNAME = new QName("http://nores.wrap.lit.doc.service.ws.pg.com/", "setUserDetailsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pg.ws.stub.doclitwrap.nores
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserBo }
     * 
     */
    public UserBo createUserBo() {
        return new UserBo();
    }

    /**
     * Create an instance of {@link SetUserDetails }
     * 
     */
    public SetUserDetails createSetUserDetails() {
        return new SetUserDetails();
    }

    /**
     * Create an instance of {@link SetUserDetailsResponse }
     * 
     */
    public SetUserDetailsResponse createSetUserDetailsResponse() {
        return new SetUserDetailsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetUserDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://nores.wrap.lit.doc.service.ws.pg.com/", name = "setUserDetails")
    public JAXBElement<SetUserDetails> createSetUserDetails(SetUserDetails value) {
        return new JAXBElement<SetUserDetails>(_SetUserDetails_QNAME, SetUserDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetUserDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://nores.wrap.lit.doc.service.ws.pg.com/", name = "setUserDetailsResponse")
    public JAXBElement<SetUserDetailsResponse> createSetUserDetailsResponse(SetUserDetailsResponse value) {
        return new JAXBElement<SetUserDetailsResponse>(_SetUserDetailsResponse_QNAME, SetUserDetailsResponse.class, null, value);
    }

}
