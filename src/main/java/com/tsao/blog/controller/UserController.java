package com.tsao.blog.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tsao.blog.entity.User;
import com.tsao.blog.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("id")Long id, Model model){
		User user = this.userService.detail("1");
		model.addAttribute("user", user);
		return new ModelAndView("user/info", "userModel", model);
	}
}
