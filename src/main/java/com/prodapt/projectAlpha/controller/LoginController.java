package com.prodapt.projectAlpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.projectAlpha.entity.UserDetails;
import com.prodapt.projectAlpha.entity.UserPassword;
import com.prodapt.projectAlpha.exceptions.InvalidCredentialException;
import com.prodapt.projectAlpha.service.UserPasswordService;

@Controller
public class LoginController {
	@Autowired
	private UserPasswordService ups;
	
	@GetMapping("/loginform")
	public String getLoginForm(@ModelAttribute("user") UserPassword up)
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String loginFormData (@ModelAttribute("user") UserPassword up)
	{
		UserPassword usr;
		ModelAndView mv = new ModelAndView();
		try 
		{
			usr = ups.loginUser(up);
			mv.addObject("userData", usr);
//			if(usr.getRoles().stream().anyMatch(role -> role.getRole().equals("admin")))
			if(ups.getUserRole(usr).equals("ADMIN"))
			{
				return "redirect:/admin";
			}
			else
			{
				mv.setViewName("redirect:/user");
			}
			
		}
		catch (InvalidCredentialException e)
		{
			return "redirect:/invalidcredential";
		}
		return "redirect:/user";
	}
	
	@GetMapping("/invalidcredential")
	public ModelAndView invalidCredential()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("invalidcredential");
		return mv;
	}
	
	@GetMapping("/user")
	public ModelAndView user()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");
		return mv;
	}
	
	@GetMapping("/admin")
	public ModelAndView admin()
	{
		ModelAndView mv = new ModelAndView();
		List<UserPassword> users = ups.getAllUsers();
		mv.addObject("list", users);
		mv.setViewName("admin");
		return mv;
	}
	
	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Long id)
	{
		ups.deleteUserPasswordById(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/updateform")
	public String updateForm(@ModelAttribute("user") UserPassword up,@ModelAttribute("userdetail") UserDetails ud,@RequestParam("id") Long id)
	{
		up.setUserId(id);
		return "updateuser";
	}
	
	@PostMapping(value = "/updateuser")
	public ModelAndView updateUser(@ModelAttribute("user") UserPassword user,@ModelAttribute("userdetail") UserDetails ud)
	{
		ModelAndView mv = new ModelAndView();
		user.setUserDetails(ud);
		ups.updateUserPassword(user);
		mv.setViewName("redirect:/admin");
		return mv;
	}
}
