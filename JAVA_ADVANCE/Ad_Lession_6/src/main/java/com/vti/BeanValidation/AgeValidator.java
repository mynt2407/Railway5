package com.vti.BeanValidation;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Date> {

	long minAge;

	@Override
	public void initialize(Age value) {
		minAge = value.min();
	}

	public boolean isValid(Date birthday, ConstraintValidatorContext context) {

		// null value are valid
		if (birthday == null) {
			return true;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, (int) (-1 * minAge));
		Date yearBefore18ages = cal.getTime();
		
		//yearBefore18ages : in ra nam 2002

		//birthday do nguoi dung nhap vao: in ra nam 2000 (vi du nhap 100)
		
		return birthday.before(yearBefore18ages);

	}

}
