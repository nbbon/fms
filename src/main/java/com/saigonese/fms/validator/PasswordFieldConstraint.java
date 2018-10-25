package com.saigonese.fms.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Ba Bon Nguyen bnguyen@mum.edu
 *
 */
@Target( { METHOD, FIELD, ElementType.TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordFieldValidator.class)
@Documented
public @interface PasswordFieldConstraint {

	String message() default "{msg.error.password.invalid}";

    Class<?>[] groups() default {};
    
    public abstract Class<? extends Payload>[] payload() default {};
}
