package com.vti.BeanValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.Service.AccountService;

public class IDExistValidator implements ConstraintValidator<IDExist, Short> {

	private AccountService service;

	@Override
	public void initialize(IDExist constraintAnnotation) {
		service = new AccountService();
	}

	//check xem id nhap vao co null khong. Neu khong null thi cho xuong server xu ly tiep
	@Override
	public boolean isValid(Short value, ConstraintValidatorContext context) {
		if (value == 0) {
			return false;
		}
		return service.isAccountExistById(value);

	}
}
