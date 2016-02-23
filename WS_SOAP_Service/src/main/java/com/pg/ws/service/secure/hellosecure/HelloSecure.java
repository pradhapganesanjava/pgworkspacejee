package com.pg.ws.service.secure.hellosecure;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@RolesAllowed("admin")
@WebService
@BindingType(value=SOAPBinding.SOAP12HTTP_BINDING)
public class HelloSecure {

	
	public String getUserDetails(String userName) {
		System.out.println("getUserDetails called with username "+userName);
		return "UserName: " + userName + " is Authorized";
	}

	/*public String sayHi(String userName) {
		return "Hi .." + userName;
	}*/

}
