package com.tsao.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tsao.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("id")Long id, Model model){
		User user = new User(new Long(id), "aa", "bb");
		model.addAttribute("user", user);
		return new ModelAndView("user/info", "userModel", model);
	}
}
