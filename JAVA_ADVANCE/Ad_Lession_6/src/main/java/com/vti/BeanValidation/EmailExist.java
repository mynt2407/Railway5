package com.vti.BeanValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

import com.vti.BeanValidation.EmailExist.List;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR , ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(List.class)

//@Constraint(validatedBy = EmailValidator.class)

public @interface EmailExist {
	String message() default "Email isn't correct form or not exist!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR , ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		EmailExist[] value();
	}
}
