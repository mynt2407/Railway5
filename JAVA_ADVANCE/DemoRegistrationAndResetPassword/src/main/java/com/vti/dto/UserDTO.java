package com.vti.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.vti.entity.User;
import com.vti.validation.EmailNotExist;
import com.vti.validation.UsenameNotExist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserDTO {
	
	@NotNull
	@NotBlank
	@NotEmpty
	@UsenameNotExist
	@Length(min = 6, max=15, message = "UseName phai lon hon 15 va nho hon 6 Ky tu")
	private String username;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@EmailNotExist
	@Length(min = 6, max=15, message = "Email phai lon hon 15 va nho hon 6 Ky tu")
	private String email;
	
	
	private String password;
	
	public User toEntity() {
		return new User(username, email, password);
		
	}
}
