package com.vti.BeanValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.Service.AccountService;

public class EmailValidator implements ConstraintValidator<EmailExist, String> {

	private AccountService service;

	@Override
	public void initialize(EmailExist constraintAnnotation) {
		service = new AccountService();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (com.mysql.cj.util.StringUtils.isNullOrEmpty(value)) {
			return false;
		}
		return service.isAccountExistByEmail(value);

	}

}
