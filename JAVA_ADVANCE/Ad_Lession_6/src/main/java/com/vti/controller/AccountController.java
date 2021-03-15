package com.vti.controller;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.vti.Service.AccountService;
import com.vti.dto.AccountDto;
import com.vti.entity.Account;

public class AccountController {
	private AccountService service;

	public AccountController() {
		service = new AccountService();
	}

	public List<Account> getAllAccount() {
		return null;
	}

	public void createAccount(@Valid AccountDto dto) {
		// validate susscess

		Locale.setDefault(Locale.US);
		//Locale.setDefault(new Locale("vi"));
		
		// get Validation object
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		// validate
		Set<ConstraintViolation<AccountDto>> violations = validator.validate(dto);

		if (violations == null || violations.size() == 0) {

			service.createAccount(dto);
		}
		
		// print error
		for (ConstraintViolation<AccountDto> constraintViolation : violations) {
			System.out.println(constraintViolation.getMessage());
		}

	}
	public void updateAccount(@Valid AccountDto dto) {
		// validate susscess

		Locale.setDefault(Locale.US);
		//Locale.setDefault(new Locale("vi"));
		
		// get Validation object
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		// validate
		Set<ConstraintViolation<AccountDto>> violations = validator.validate(dto);

		if (violations == null || violations.size() == 0) {

			service.updateAccount(dto);
		}
		
		// print error
		for (ConstraintViolation<AccountDto> constraintViolation : violations) {
			System.out.println(constraintViolation.getMessage());
		}

	}
}
