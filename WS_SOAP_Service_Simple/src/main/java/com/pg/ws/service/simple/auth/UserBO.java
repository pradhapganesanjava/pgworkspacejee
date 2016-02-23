package com.pg.ws.service.simple.auth;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserBO {

	private String userId;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
