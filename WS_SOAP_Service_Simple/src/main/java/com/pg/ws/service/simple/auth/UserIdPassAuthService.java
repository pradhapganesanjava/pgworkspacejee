package com.pg.ws.service.simple.auth;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(serviceName="UserAuth")
@SOAPBinding(style=SOAPBinding.Style.RPC,use = SOAPBinding.Use.LITERAL)
public class UserIdPassAuthService {

	@Resource
	WebServiceContext webServiceCntx;
	
	public String isAuthorizedUser(UserBO userBO, String accessReqTo){
		MessageContext msgCntx = webServiceCntx.getMessageContext();
		Map httpHeadMap = (Map)msgCntx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userNameList = (null!=httpHeadMap.get("USER_NAME")&& httpHeadMap.get("USER_NAME") instanceof List)?(List)httpHeadMap.get("USER_NAME"):null;
		List passwordList = (null!=httpHeadMap.get("PASSWORD")&& httpHeadMap.get("PASSWORD") instanceof List)?(List)httpHeadMap.get("PASSWORD"):null;
		
		String userName = null;
		String password = null;
		
		if(null != userNameList && null != userNameList.get(0)){
			userName=(String)userNameList.get(0);
		}
		if(null != passwordList && null != passwordList.get(0)){
			password=(String)passwordList.get(0);
		}
		
		if("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password)){
			return "AUTHORIZED";
		}else{
			return "Access DENIED";
		}
	}
	
}
