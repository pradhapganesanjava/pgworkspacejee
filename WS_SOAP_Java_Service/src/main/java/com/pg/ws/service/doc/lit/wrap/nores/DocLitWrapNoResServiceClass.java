package com.pg.ws.service.doc.lit.wrap.nores;

import javax.jws.WebService;

@WebService
public class DocLitWrapNoResServiceClass {

	public void setUserDetails(UserBo userBo){
		if(null != userBo && userBo.getName() != null){
			System.out.println("UserBo is updated success !!!");
		}
	}
	
}
