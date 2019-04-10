package com.mj.vo;

import java.util.Date;

public class User {

	private int no;
	private String id;
	private String password;
	private String email;
	private String name;
	private Date createDate;
	private int authStatus;
	
	public User(String id, String password, String email, String name) {
		this.id 	  = id;
		this.password = password;
		this.email 	  = email;
		this.name 	  = name;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getUserAuthStatus() {
		return authStatus;
	}

	public void setUserAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", id=" + id + ", password=" + password + ", email=" + email + ", name=" + name
				+ ", createDate=" + createDate + ", authStatus=" + authStatus + "]";
	}
}
