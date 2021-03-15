package com.vti.frontend;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.vti.entity.Department;

public class Program {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// object is needed create
		Department department = new Department();
		department.setName("neo nguyen");
		//department.setTotalMember((short) 2);

		// get Validation object
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		// validate 
		Set<ConstraintViolation<Department>> violations = validator.validate(department);

		// print error
		for (ConstraintViolation<Department> constraintViolation : violations) {
			System.out.println(constraintViolation.getMessage());
		}
	}
}
