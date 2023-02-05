package com.imthiyasLearn.springboot.TodoApplication.authenticationservice;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
  public boolean autenticate(String username,String password) {
	 
	boolean isValidUser =  username.equalsIgnoreCase("imthiyas");
	
	boolean isValidPassword =  password.equalsIgnoreCase("mohamed");
	  
	  return isValidPassword && isValidUser;
  }

}