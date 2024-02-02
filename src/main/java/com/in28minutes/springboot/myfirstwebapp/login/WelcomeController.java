package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {	
	

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoWelcomePage( ModelMap model	) {
		model.put("name", "in28minutes");
		return "welcome";
	}
	
//	@RequestMapping(value="login",method=RequestMethod.POST)
//	public String gotoWelcome(@RequestParam String name,@RequestParam String password, ModelMap model) {
//		
//		if(authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			model.put("pwd", password);
//			return "welcome";
//			
//		}
//		else {
//			
//			model.put("errormessage", "invalid username or password");
//			return "login";
//		}
//		
//	}
	
}
