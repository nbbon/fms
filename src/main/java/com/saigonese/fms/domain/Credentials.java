package com.saigonese.fms.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.saigonese.fms.validator.PasswordFieldConstraint;
import com.saigonese.fms.validator.PasswordsEqualConstraint;

@Entity(name = "USERS")
@PasswordsEqualConstraint
public class Credentials {

	@Id
	@Column(name = "USERNAME", nullable = false, unique = true)
	@NotEmpty(message = "{msg.error.required}")
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	@NotEmpty(message = "{msg.error.required}")
	@PasswordFieldConstraint
	private String password;
	
	@NotEmpty
	@Transient
	private String verifyPassword;

	private Boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
	List<Authority> authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

}
