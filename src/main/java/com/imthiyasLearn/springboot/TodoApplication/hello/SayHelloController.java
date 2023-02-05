package com.imthiyasLearn.springboot.TodoApplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello ! what are you learning";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		
		StringBuffer buffer = new StringBuffer();
		
		
		buffer.append("<h1> Welcome imthiyas </h1>");
		

		
		
		return buffer.toString();
	}
	
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	
	
//	jsp server pages
	
	
	

}
