package com.pg.xml.jaxb.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.pg.xml.jaxb.pojo.UserBo;

public class JAXBUtil {

	public static void marshallToXml(Object object){
		
		
		try {
			
			JAXBContext jaxbContext =  JAXBContext.newInstance(object.getClass());
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(object, System.out);
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
