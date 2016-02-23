package com.pg.xml.jaxb.pojo;

public class UserAddressBo {

	private String addrLine1;
	private String addrLine2;
	private String state;
	private String country;
	private String zipcode;

	public UserAddressBo() {
	}
	
	public UserAddressBo(String addrLine1, String addrLine2, String state,
			String country, String zipcode) {
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	
	public String getAddrLine1() {
		return addrLine1;
	}
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
	}
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
