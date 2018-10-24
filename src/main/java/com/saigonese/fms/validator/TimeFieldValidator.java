package com.saigonese.fms.validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ba Bon Nguyen bnguyen@mum.edu
 *
 */
public class TimeFieldValidator implements ConstraintValidator<TimeFieldFormat, Date> {

	@Override
	public void initialize(TimeFieldFormat constraintAnnotation) {

	}

	@Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if(value != null) {
			Matcher matcher;
        	final String TIME_PATTERN = "^(?:\\d|[01]\\d|2[0-3]):[0-5]\\d$";
        	
        	matcher = Pattern.compile(TIME_PATTERN).matcher(new SimpleDateFormat("HH:mm").format(value));
        	return matcher.matches();
      	  
        }
		return false;
	}
}