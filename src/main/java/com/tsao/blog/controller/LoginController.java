package com.tsao.blog.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/login/{username}/{password}")
	public String login(@PathVariable(value = "username", required = true)String username,
			@PathVariable(value = "password", required = true)String password){
		String rst = null;
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);
		try {
			subject.login(token);
			rst = "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rst = "fail";
		}
		return rst;
	}
}
