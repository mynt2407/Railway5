package com.vti.entity;

import java.util.Date;

public class Account {
	private int id;
	private String fullName;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String postition;
	private Date createDate;
	private Group[] groups;

	public Account() {
	}

	public Account(int id, String email, String userName, String firstName, String lastName, String fullName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + lastName;
	}

	public Account(int id, String email, String userName, String firstName, String lastName, String fullName,
			String postition, Date createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.postition = postition;
		this.createDate = new Date();
	}
// getter
	public Account(String userName) {
		this.userName = userName;

	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFullName() {
		return fullName;
	}

	public Group[] getGroups() {
		return groups;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPostition() {
		return postition;
	}

	public String getUserName() {
		return userName;
	}
	
//setter
	
	public void setCreateDate(Date createDate) {
		this.createDate = new Date(100, 10, 1);
	}

	public void setEmail(String email) {
		this.email = "my123@gmail.com";
	}

	public void setFirstName(String firstName) {
		this.firstName = "Neo";
	}

	public void setLastName(String lastName) {
		this.lastName = "Nguyen";
	}

	public void setFullName(String fullName) {
		this.fullName = "Neo Nguyen";
	}

	public void setPostition(String postition) {
		this.postition = "Dev";
	}
	public void setId(int id) {
		this.id = 5;
	}
	public void setUserName(String userName) {
		this.userName = "ngocmai";
	}
}
