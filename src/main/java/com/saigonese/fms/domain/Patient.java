package com.saigonese.fms.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Patient {
	@Id
	@GeneratedValue
	@Column(name = "PATIENT_ID")
	private Long id;


	@NotEmpty(message = "{String.empty}")
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@NotEmpty(message = "{String.empty}")
	@Column(name = "LAST_NAME")
	private String lastName;
	

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USERNAME")
	private Credentials credentials;

	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;


	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PHONE_ID")
	private Phone phone;
	
	@Column(name = "DATE_OF_BIRTH")
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	
	@NotEmpty
	@Column(name = "SSN")
	@Size(min=10 , max=10 , message= "{ssn.size}")
	private String ssn;
	
	@NotEmpty
	@Column(name = "EMAIL_ADDRESS")
	@Email
	private String emailAddress;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;

	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;

	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", credentials="
				+ credentials + ", address=" + address + ", phone=" + phone + ", dob=" + dob + ", ssn=" + ssn
				+ ", emailAddress=" + emailAddress + "]";
	}
}
