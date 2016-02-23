
package com.pg.ws.stub.doclitbare;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pg.ws.stub.doclitbare package. 
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

    private final static QName _GetUserDetailsResponse_QNAME = new QName("http://bare.lit.doc.service.ws.pg.com/", "getUserDetailsResponse");
    private final static QName _GetUserDetails_QNAME = new QName("http://bare.lit.doc.service.ws.pg.com/", "getUserDetails");
    private final static QName _SetUserDetailsNoResp_QNAME = new QName("http://bare.lit.doc.service.ws.pg.com/", "setUserDetailsNoResp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pg.ws.stub.doclitbare
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UserBo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bare.lit.doc.service.ws.pg.com/", name = "getUserDetailsResponse")
    public JAXBElement<UserBo> createGetUserDetailsResponse(UserBo value) {
        return new JAXBElement<UserBo>(_GetUserDetailsResponse_QNAME, UserBo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserBo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bare.lit.doc.service.ws.pg.com/", name = "getUserDetails")
    public JAXBElement<UserBo> createGetUserDetails(UserBo value) {
        return new JAXBElement<UserBo>(_GetUserDetails_QNAME, UserBo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserBo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bare.lit.doc.service.ws.pg.com/", name = "setUserDetailsNoResp")
    public JAXBElement<UserBo> createSetUserDetailsNoResp(UserBo value) {
        return new JAXBElement<UserBo>(_SetUserDetailsNoResp_QNAME, UserBo.class, null, value);
    }

}
