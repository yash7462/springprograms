package com.example.GoogleLoginDemo.bean;

import org.springframework.stereotype.Component;

@Component
public class UserDetail {
	
	private String name;
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public UserDetail(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		
	}
	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
