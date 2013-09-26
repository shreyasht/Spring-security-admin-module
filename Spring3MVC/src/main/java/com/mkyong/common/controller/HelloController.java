package com.mkyong.common.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
@RequestMapping("/welcome")
public class HelloController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		model.addAttribute("message", "Spring Security welcome user");
		User principal = (User)SecurityContextHolder.getContext()
	     .getAuthentication().getPrincipal();
		model.addAttribute("username", principal.getUsername());
		return "hello";
 
	}
 
}