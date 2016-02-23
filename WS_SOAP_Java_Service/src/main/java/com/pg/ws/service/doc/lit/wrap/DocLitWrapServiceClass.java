package com.pg.ws.service.doc.lit.wrap;

import javax.jws.WebService;

@WebService
public class DocLitWrapServiceClass {

	public UserBo getUserDetails(UserBo userBo){
		if(null != userBo && userBo.getName() != null){
			return userBo;
		}
		return new UserBo("dummy",0,0.0);
	}
	
}
