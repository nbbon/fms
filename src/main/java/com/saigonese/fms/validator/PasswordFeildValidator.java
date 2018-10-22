/**
 * 
 */
package com.saigonese.fms.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Vivian Samson
 *
 */
public class PasswordFeildValidator implements ConstraintValidator<PasswordFeildConstraint, String> {

	@Override
	public void initialize(PasswordFeildConstraint constraintAnnotation) {

	}

	@Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if(password!=null) {

        	Pattern pattern = null ;
        	
	      	  Matcher matcher;
	       
	      	  final String PASSWORD_PATTERN = 
	                    "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,100})";
	      	  pattern = pattern.compile(PASSWORD_PATTERN);
	      	  matcher = pattern.matcher(password);
			  return matcher.matches();
      	  
        }
		return false;

}
}