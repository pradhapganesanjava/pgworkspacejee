package com.pg.ws.service.doc.lit.wrap.nores;

public class UserBo {
	private String name;
	private int age;
	
	public UserBo() {
	}
	public UserBo(String name,int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
