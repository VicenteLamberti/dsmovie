package com.devsuperior.dsmovie.forms;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	private String email;
	private String pass;

	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public UsernamePasswordAuthenticationToken loginFormToUsernamePasswordAuthenticationToken() {
		return new UsernamePasswordAuthenticationToken(this.email, this.pass);
	}
}
