package com.prodapt.projectAlpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.projectAlpha.entity.UserDetails;
import com.prodapt.projectAlpha.entity.UserPassword;
import com.prodapt.projectAlpha.service.UserPasswordService;

@Controller
public class UserController {
	@Autowired
	private UserPasswordService ups;
	
	@GetMapping("/registration")
	public String getRegistrationForm(@ModelAttribute("userreg") UserPassword user,@ModelAttribute("userdetail") UserDetails ud)
	{
		return "registration";
	}
	
	@Query("insert into ")
	@PostMapping("/saveregistration")
	public ModelAndView saveUserForm(@ModelAttribute("userreg") UserPassword user,@ModelAttribute("userdetail") UserDetails ud)
	{
		ModelAndView mv = new ModelAndView();
		
		user.setUserDetails(ud);
		ups.addUserPassword(user);
		mv.addObject("userData", user);
		mv.setViewName("redirect:loginform");
		return mv;
	}
}
