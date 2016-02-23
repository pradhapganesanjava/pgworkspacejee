
package com.pg.ws.stub.simpleauth;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pg.ws.stub.simpleauth package. 
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

    private final static QName _UserBO_QNAME = new QName("http://auth.simple.service.ws.pg.com/", "userBO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pg.ws.stub.simpleauth
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserBO }
     * 
     */
    public UserBO createUserBO() {
        return new UserBO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserBO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auth.simple.service.ws.pg.com/", name = "userBO")
    public JAXBElement<UserBO> createUserBO(UserBO value) {
        return new JAXBElement<UserBO>(_UserBO_QNAME, UserBO.class, null, value);
    }

}
