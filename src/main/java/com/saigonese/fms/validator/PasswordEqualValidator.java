package com.saigonese.fms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.saigonese.fms.domain.Credentials;

/**
 * @author Ba Bon Nguyen bnguyen@mum.edu
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
	public boolean isValid(Object target, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		Credentials credential = (Credentials) target;
		System.out.println(credential.getVerifyPassword() + " " +  credential.getPassword() );
		return credential.getPassword().equals(credential.getVerifyPassword());
		
	}

}
