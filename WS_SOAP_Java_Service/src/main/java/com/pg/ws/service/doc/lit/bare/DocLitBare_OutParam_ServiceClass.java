package com.pg.ws.service.doc.lit.bare;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlList;

import com.pg.ws.service.util.EndpointPublisher;

@WebService
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
public class DocLitBare_OutParam_ServiceClass {

	public @XmlList List<UserBo> getUserDetailsOut(){
			System.out.println(" getUserDetailsOut is called ");
			List<UserBo> userBoLst = new ArrayList<UserBo>();
			userBoLst.add(new UserBo("dummy", 0));
		return userBoLst;
	}

	public UserBo getTopUserDetailsOut(){
		System.out.println(" getTopUserDetailsOut is called ");
		return new UserBo("dummy", 0);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EndpointPublisher.main("6662","/doclitbareoutp","com.pg.ws.service.doc.lit.bare.DocLitBare_OutParam_ServiceClass");
	}

}
