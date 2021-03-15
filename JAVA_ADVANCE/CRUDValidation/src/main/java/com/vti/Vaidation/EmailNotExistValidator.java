package com.vti.Vaidation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.fluent.hibernate.internal.util.InternalUtils.StringUtils;
import com.vti.service.AccountService;



public class EmailNotExistValidator implements ConstraintValidator<EmailNotExist, String> {

	private AccountService service;

	@Override
	public void initialize(EmailNotExist constraintAnnotation) {
		service = new AccountService();
	}

	//check xem email nhap vao co null khong. Neu khong null thi cho xuong server xu ly tiep
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		return !service.isAccountExistByEmail(value);

	}

}
