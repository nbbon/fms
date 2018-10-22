/**
 * 
 */
package com.saigonese.fms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.saigonese.fms.domain.Credentials;
import com.saigonese.fms.domain.Patient;

/**
 * @author Vivian Samson
 *
 */
public class PasswordEqualValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(PasswordsEqualConstraint constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Object Credentials, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		Credentials credential = (Credentials) Credentials;
		System.out.println(credential.getVerifyPassword() + " " +  credential.getPassword() );
		return credential.getPassword().equals(credential.getVerifyPassword());
		
	}

}
