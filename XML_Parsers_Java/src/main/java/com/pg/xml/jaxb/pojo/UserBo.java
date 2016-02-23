package com.pg.xml.jaxb.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserBo {

	private String firstName;
	private String lastName;
	private Date dob;
	private Double salary;
	private int age;
	private UserAddressBo address;
	
	public UserBo() {

	}
	
	public UserBo(String firstName, String lastName, int age, Date dob, Double salary){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
		this.salary = salary;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public UserAddressBo getAddress() {
		return address;
	}
	public void setAddress(UserAddressBo address) {
		this.address = address;
	}
	
	
	
	
}
