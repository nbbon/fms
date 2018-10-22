/**
 * 
 */
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
 * @author Vivian Samson
 *
 */
@Target( { METHOD, FIELD, ElementType.TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordFeildValidator.class)
@Documented
public @interface PasswordFeildConstraint {

	String message() default "{PasswordNotValid}";

    Class<?>[] groups() default {};
    
    public abstract Class<? extends Payload>[] payload() default {};
}
