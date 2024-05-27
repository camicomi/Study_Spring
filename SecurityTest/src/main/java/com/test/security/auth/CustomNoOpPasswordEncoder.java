package com.test.security.auth;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {

		System.out.println("PasswordEncoder >>> " + rawPassword);
		
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		System.out.println("PasswordEncoder >>> " + rawPassword + ":" + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
	}
	
	

}



