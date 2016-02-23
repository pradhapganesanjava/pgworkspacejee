package com.pg.ws.service.secure.basicauth;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public class UserIdPassAuthorization {

	@Resource
	WebServiceContext webSrvContext;

	public String isAuthorizedUser(String roleName, String requestAuthFor) {
		MessageContext msgContext = webSrvContext.getMessageContext();
		Map httpReqHeadMap = (Map)msgContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userNameLst = (null != httpReqHeadMap.get("USER_NAME") && httpReqHeadMap.get("USER_NAME") instanceof List)?(List)httpReqHeadMap.get("USER_NAME"):null;
		List passLst = (null != httpReqHeadMap.get("PASSWORD") && httpReqHeadMap.get("PASSWORD") instanceof List)?(List)httpReqHeadMap.get("PASSWORD"):null;
		
		String userName = null;
		String password = null;
		
		if(null != userNameLst && null != userNameLst.get(0)){
			userName = (String)userNameLst.get(0);
		}

		if(null != passLst && null != passLst.get(0)){
			password = (String)passLst.get(0);
		}

		if("admin".equalsIgnoreCase(userName)&& "admin".equalsIgnoreCase(password)){
			return "authorized";
		}else{
			return "ACCESS DENIED";
		}
	}
}
