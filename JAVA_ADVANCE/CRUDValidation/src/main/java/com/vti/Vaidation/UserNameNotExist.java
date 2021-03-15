package com.vti.Vaidation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR , ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Repeatable(List.class)
@Constraint(validatedBy = UserNamelNotExistValidator.class)

public @interface UserNameNotExist {
	String message() default "{accountDto.userName.UserNameNotExist}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR , ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		UserNameNotExist[] value();
	}
}
