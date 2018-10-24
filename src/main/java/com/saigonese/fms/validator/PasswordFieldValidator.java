package com.saigonese.fms.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ba Bon Nguyen bnguyen@mum.edu
 *
 */
public class PasswordFieldValidator implements ConstraintValidator<PasswordFieldConstraint, String> {

	@Override
	public void initialize(PasswordFieldConstraint constraintAnnotation) {

	}

	@Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if(password!=null) {
        	Matcher matcher;
        	final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,100})";
        	matcher = Pattern.compile(PASSWORD_PATTERN).matcher(password);
        	return matcher.matches();
        }
		return false;
	}
}