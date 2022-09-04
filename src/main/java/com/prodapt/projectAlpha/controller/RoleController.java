package com.prodapt.projectAlpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.projectAlpha.entity.UserRole;
import com.prodapt.projectAlpha.service.UserRoleService;

@Controller
public class RoleController {
	@Autowired
	private UserRoleService urs;
	
	@GetMapping("/roles")
	public String getRoles(@ModelAttribute ("userrole") UserRole role)
	{
		return "roles";
	}
	
	@PostMapping("/saverole")
	public ModelAndView saveRole(@ModelAttribute ("userrole") UserRole role)
	{
		UserRole rol = urs.addUserRole(role);
		ModelAndView mv = new ModelAndView();
		mv.addObject("roleData", rol);
		mv.setViewName("Roles");
		return mv;
	}
}
