package com.pg.xml.jaxb.toxml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.pg.xml.jaxb.pojo.UserBo;
import com.pg.xml.jaxb.util.JAXBUtil;

public class UserBoToXml {

	public static void main(String...str){
		
		Date dob = Calendar.getInstance().getTime(); 
		try {
			dob = new SimpleDateFormat("yyyy-MM-dd").parse("1985-07-16");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		UserBo userBo = new UserBo("firstName", "lastName", 0, dob, 10.0);
		JAXBUtil.marshallToXml(userBo);
		
		
	}
	
}
