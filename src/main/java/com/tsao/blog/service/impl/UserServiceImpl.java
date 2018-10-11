package com.tsao.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsao.blog.dao.GeneralDao;
import com.tsao.blog.dao.UserDao;
import com.tsao.blog.entity.User;
import com.tsao.blog.service.UserService;

@Service("userService")
@Transactional
class UserServiceImpl extends ServiceImpl<String, User> implements UserService{

	@Resource(name = "userDao")
	private UserDao userDao;
	
	@Override
	protected GeneralDao<String, User> getDao() {
		// TODO Auto-generated method stub
		return this.userDao;
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userDao.getByUsername(username);
	}
	
}
