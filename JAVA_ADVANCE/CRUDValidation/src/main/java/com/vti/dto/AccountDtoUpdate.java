package com.vti.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.vti.Vaidation.IDExist;
import com.vti.Vaidation.UserNameNotExist;
import com.vti.entity.Account;

public class AccountDtoUpdate {
	
	@IDExist
	private short id;


	@NotBlank(message = "{accountDto.userName.NotBlank}")
	@Length(min = 3, max = 50, message = "{accountDto.userName.Length}")
	@UserNameNotExist
	private String userName;

	@Length(min = 3, max = 50, message = "Your FirstName '${validatedValue}' should be between {min} and {max} charater. Length found is : ${validatedValue.length()}")
	private String firstName;

	@Length(min = 3, max = 50, message = "Your lastName '${validatedValue}' should be between {min} and {max} charater. Length found is : ${validatedValue.length()}")
	private String lastName;

	@Column(name = "CreateDate", updatable = true)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public AccountDtoUpdate() {
	}

	public AccountDtoUpdate(short id,String userName) {
		this.id = id;
		this.userName = userName;
	}

	public AccountDtoUpdate(String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account toEntity() {
		return new Account( userName, firstName, lastName, createDate);
	}
	
	public Account toEntity1() {
		return new Account(id,userName, firstName);
	}
}
