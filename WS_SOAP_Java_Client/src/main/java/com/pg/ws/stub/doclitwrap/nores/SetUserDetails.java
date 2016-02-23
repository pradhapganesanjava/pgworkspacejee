
package com.pg.ws.stub.doclitwrap.nores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setUserDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setUserDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://nores.wrap.lit.doc.service.ws.pg.com/}userBo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setUserDetails", propOrder = {
    "arg0"
})
public class SetUserDetails {

    protected UserBo arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link UserBo }
     *     
     */
    public UserBo getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserBo }
     *     
     */
    public void setArg0(UserBo value) {
        this.arg0 = value;
    }

}
