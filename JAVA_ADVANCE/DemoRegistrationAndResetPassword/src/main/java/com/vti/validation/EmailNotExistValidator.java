package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.service.IUserService;


public class EmailNotExistValidator implements ConstraintValidator<UsenameNotExist, String> {

	@Autowired
	private IUserService service;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return !service.isEmailExist(value);
	}

}
