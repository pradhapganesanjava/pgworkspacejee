
package com.pg.ws.stub.calculator;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.pg.ws.stub.calculator package. 
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

    private final static QName _SquareOf_QNAME = new QName("http://calculator.demo.service.ws.pg.com/", "squareOf");
    private final static QName _ConvertToBinary_QNAME = new QName("http://calculator.demo.service.ws.pg.com/", "convertToBinary");
    private final static QName _SquareRootOfResponse_QNAME = new QName("http://calculator.demo.service.ws.pg.com/", "squareRootOfResponse");
    private final static QName _ConvertToHex_QNAME = new QName("http://calculator.demo.service.ws.pg.com/", "convertToHex");
    private final static QName _ConvertToBinaryResponse_QNAME = new QName("http://calculator.demo.service.ws.pg.com/", "convertToBinaryResponse");
    private final static QName _SquareOfResponse_QNAME = new QName("http://calculator.demo.service.ws.pg.com/", "squareOfResponse");
    private final static QName _SquareRootOf_QNAME = new QName("http://calculator.demo.service.ws.pg.com/", "squareRootOf");
    private final static QName _ConvertToHexResponse_QNAME = new QName("http://calculator.demo.service.ws.pg.com/", "convertToHexResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.pg.ws.stub.calculator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator.demo.service.ws.pg.com/", name = "squareOf")
    public JAXBElement<String> createSquareOf(String value) {
        return new JAXBElement<String>(_SquareOf_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator.demo.service.ws.pg.com/", name = "convertToBinary")
    public JAXBElement<String> createConvertToBinary(String value) {
        return new JAXBElement<String>(_ConvertToBinary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator.demo.service.ws.pg.com/", name = "squareRootOfResponse")
    public JAXBElement<String> createSquareRootOfResponse(String value) {
        return new JAXBElement<String>(_SquareRootOfResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator.demo.service.ws.pg.com/", name = "convertToHex")
    public JAXBElement<String> createConvertToHex(String value) {
        return new JAXBElement<String>(_ConvertToHex_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator.demo.service.ws.pg.com/", name = "convertToBinaryResponse")
    public JAXBElement<String> createConvertToBinaryResponse(String value) {
        return new JAXBElement<String>(_ConvertToBinaryResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator.demo.service.ws.pg.com/", name = "squareOfResponse")
    public JAXBElement<String> createSquareOfResponse(String value) {
        return new JAXBElement<String>(_SquareOfResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator.demo.service.ws.pg.com/", name = "squareRootOf")
    public JAXBElement<String> createSquareRootOf(String value) {
        return new JAXBElement<String>(_SquareRootOf_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calculator.demo.service.ws.pg.com/", name = "convertToHexResponse")
    public JAXBElement<String> createConvertToHexResponse(String value) {
        return new JAXBElement<String>(_ConvertToHexResponse_QNAME, String.class, null, value);
    }

}
