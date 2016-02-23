package com.pg.ws.service.doc.lit.bare;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import com.pg.ws.service.doc.lit.wrap.UserBo;
import com.pg.ws.service.util.EndpointPublisher;

@WebService
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public class DocLitBareServiceClass {

	public void setUserDetailsNoResp(UserBo userBo){
		if(null != userBo && userBo.getName() != null){
			System.out.println(" UserBo updated successfully ");
		}
	}
	
	public UserBo getUserDetails(UserBo userBo){
		if(null != userBo && userBo.getName() != null){
			return userBo;
		}
		return new UserBo("dummy",0,0.0);
	}
	
	public static void main(String... str){
		//EndpointPublisher.main("6666","/doclitbare","com.pg.ws.service.doc.lit.bare.DocLitBareServiceClass");
		try{
		Endpoint.publish("http://localhost:6668/doclitbaretest/", new DocLitBareServiceClass());
		System.out.println("deployed..");
		}catch(Exception e){
			System.out.println(" FAILED "+e.getMessage());
		}
		
	}
	
}
