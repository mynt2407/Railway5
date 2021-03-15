package com.vti.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.vti.Vaidation.EmailNotExist;
import com.vti.Vaidation.IDExist;
import com.vti.Vaidation.UserNameNotExist;
import com.vti.entity.Account;

public class AccountDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@IDExist
	private short id;

	@NotBlank(message = "{accountDto.email.NotBlank}")
	@Length(min = 5, max = 50, message = "{accountDto.email.Length}")
	@EmailNotExist
	private String email;

	@NotBlank(message = "{accountDto.userName.NotBlank}")
	@Length(min = 3, max = 50, message = "{accountDto.userName.Length}")
	@UserNameNotExist
	private String userName;

	@Length(min = 3, max = 50, message = "Your FirstName '${validatedValue}' should be between {min} and {max} charater. Length found is : ${validatedValue.length()}")
	private String firstName;

	@Length(min = 3, max = 50, message = "Your lastName '${validatedValue}' should be between {min} and {max} charater. Length found is : ${validatedValue.length()}")
	private String lastName;

	@Column(name = "CreateDate", updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public AccountDto() {
	}

	public AccountDto(short id,String email,String userName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
	}

	public AccountDto(String email, String userName, String firstName, String lastName) {
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return new Account(email, userName, firstName, lastName);
	}
	
	public Account toEntity1() {
		return new Account(id, email, userName);
	}
}
