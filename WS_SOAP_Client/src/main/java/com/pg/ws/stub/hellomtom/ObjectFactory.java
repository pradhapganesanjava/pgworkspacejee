
package com.pg.ws.stub.hellomtom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pg.ws.stub.hellomtom package. 
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

    private final static QName _UploadImg_QNAME = new QName("http://hellomtom.mtom.service.ws.pg.com/", "uploadImg");
    private final static QName _UploadImgResponse_QNAME = new QName("http://hellomtom.mtom.service.ws.pg.com/", "uploadImgResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pg.ws.stub.hellomtom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hellomtom.mtom.service.ws.pg.com/", name = "uploadImg")
    public JAXBElement<byte[]> createUploadImg(byte[] value) {
        return new JAXBElement<byte[]>(_UploadImg_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hellomtom.mtom.service.ws.pg.com/", name = "uploadImgResponse")
    public JAXBElement<Boolean> createUploadImgResponse(Boolean value) {
        return new JAXBElement<Boolean>(_UploadImgResponse_QNAME, Boolean.class, null, value);
    }

}
