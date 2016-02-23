package com.pg.ws.service.mtom.hellomtom;

import java.awt.Image;
import java.io.File;
import java.util.Random;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.soap.MTOM;

import com.oracle.xmlns.webservices.jaxws_databinding.SoapBindingStyle;
import com.sun.xml.messaging.saaj.util.ByteOutputStream;

@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,parameterStyle=SOAPBinding.ParameterStyle.BARE)
public interface HelloMTOMService {
	public boolean uploadImg(Image imgSrc);
}
