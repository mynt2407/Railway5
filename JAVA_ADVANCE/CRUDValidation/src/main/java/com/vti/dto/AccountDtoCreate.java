package com.vti.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.vti.Vaidation.EmailNotExist;
import com.vti.Vaidation.UserNameNotExist;
import com.vti.entity.Account;

public class AccountDtoCreate {

// Không cần Id

	@NotBlank(message = "{accountDto.email.NotBlank}")
	@Length(min = 5, max = 15, message = "{accountDto.email.Length}")
	@EmailNotExist
	private String email;

	@NotBlank(message = "{accountDto.userName.NotBlank}")
	@Length(min = 3, max = 10, message = "{accountDto.userName.Length}")
	@UserNameNotExist
	private String userName;

	@Length(min = 3, max = 10, message = "{accountDto.firstName.Length}")
	private String firstName;

//	@NotBlank(message = "{accountDto.lastName.NotBlank}")
//	@Length(min = 3, max = 10, message = "{accountDto.lastName.Length}")
//	private String lastName;

	@Column(name = "CreateDate", updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public AccountDtoCreate() {
	}

	public AccountDtoCreate(String email, String userName, String firstName) {
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account toEntity() {
		return new Account(email, userName, firstName, createDate);
	}

}
