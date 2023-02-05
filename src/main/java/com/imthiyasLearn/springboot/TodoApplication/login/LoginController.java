package com.imthiyasLearn.springboot.TodoApplication.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.imthiyasLearn.springboot.TodoApplication.authenticationservice.AuthenticationService;



@Controller
@SessionAttributes("name")
public class LoginController {
	
//	private Logger logger = LoggerFactory.getLogger(getClass());

//	@Autowired
//	private AuthenticationService authenticationService;
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		
		public String gotoWelcomePage(ModelMap map) {	
		
		
		map.put("name", getLoggedInUserName());
		
//		logger.debug("Request pharams is " + name);
		
		return "welcome";
	}
	
	
	private String getLoggedInUserName() {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
	  return authentication.getName();
	
	}
	
	
//	@RequestMapping(value = "login",method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password,ModelMap map) {
//		
//		
//		
//		
////		authentication login
//		
//	if(	authenticationService.autenticate(name, password)) {
//        map.put("name", name);
//		
////		map.put("password", password);
//		
//		return "welcome";
//		
//	}
//	
//	map.put("errorMessage", "Invalid Credential Please try again");
//	
//	return "login";
//		
//		
//	}

	
}
