package com.vti.frontend;

import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.vti.entity.Account2;

public class TestAccount {
	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) {
		
		//Cau hinh da ngon ngu
		
		//Locale.setDefault(Locale.CHINESE);
		
		// object is needed create
		Date date = new Date(100, 11, 20);

		Account2 account = new Account2();

		account.setUsername("abc");

		account.setEmail("mynt");

		// account.setDepartment("");
		account.setId((short) -1);

		// account.setCreateDate("120-10-29");
		account.setBirthday(date);

		// get Validation object
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		// validate
		Set<ConstraintViolation<Account2>> violations = validator.validate(account);

		// print error
		for (ConstraintViolation<Account2> constraintViolation : violations) {
			System.out.println(constraintViolation.getMessage());
		}
	}
}
