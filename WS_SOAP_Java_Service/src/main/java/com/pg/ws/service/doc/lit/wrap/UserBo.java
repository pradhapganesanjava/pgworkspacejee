package com.pg.ws.service.doc.lit.wrap;

public class UserBo {
	private String name;
	private int age;
	private Double salary; 
	
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public UserBo() {
	}
	public UserBo(String name,int age, Double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
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
