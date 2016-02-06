package com.pg.ws.service.secure.hellosecure;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebService;

@RolesAllowed("admin")
@WebService
public class HelloSecure {

	
	public String getUserDetails(String userName) {
		return "UserName: " + userName + " is Authorized";
	}

	/*public String sayHi(String userName) {
		return "Hi .." + userName;
	}*/

}
