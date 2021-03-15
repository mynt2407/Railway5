package com.vti.entity;

public class User {

	private int id;
	private String FullName;
	private String Email;
	private String Password;
	private Role role;

	
	public User(int id, String fullName, String email, String password) {
		
		this.id = id;
		this.FullName = fullName;
		this.Email = email;
		this.Password = password;
	}

	public User(int id, String fullName, String email, String password, Role role) {
		this.id = id;
		this.FullName = fullName;
		this.Email = email;
		this.Password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "User [id = " + id + ", FullName = " + FullName + ", Email = " + Email + ", Role = " + role
				+ "]";
	}

}
