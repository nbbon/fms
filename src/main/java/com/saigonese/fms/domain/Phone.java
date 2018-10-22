package com.saigonese.fms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

@Entity
public class Phone {

	@Id
	@GeneratedValue
	@Column(name = "PHONE_ID")
	private int id;
	
	@Column(name = "AREA")
	@Pattern(regexp = "\\d{3}", message = "{error.area}")
	private String area;
	
	@Column(name = "PREFIX")
	@Pattern(regexp = "\\d{3}", message = "{error.prefix}")
	private String prefix;

	@Column(name = "NUMBER")
	@Pattern(regexp = "\\d{4}", message = "{error.number}")
	private String number;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return area + "-" + prefix + "-" + number;
	}
}
