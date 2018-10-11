package com.tsao.blog.service;


import com.tsao.blog.entity.User;

public interface UserService extends Service<String, User>{
	
	public User getByUsername(String username);
	
}
