package com.pg.ws.service.doc.lit.bare;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.pg.ws.service.util.EndpointPublisher;

@WebService
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public class DocLitBare_InOutParam_ServiceClass {

	/**
	 * @param args
	 */
	public UserBo updateUserDetailsInOut(UserBo userBo){
		if(null != userBo && userBo.getName() != null){
			System.out.println(" UserBo updated successfully ");
		}
		return userBo;
	}
	
	public static void main(String[] args) {
		EndpointPublisher.main("6004","/doclitbareinout","com.pg.ws.service.doc.lit.bare.DocLitBare_InOutParam_ServiceClass");
	}
}
