package com.tsao.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsao.blog.dao.GeneralDao;
import com.tsao.blog.dao.RoleDao;
import com.tsao.blog.entity.Role;
import com.tsao.blog.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl extends ServiceImpl<Integer, Role> implements RoleService{

	@Resource(name = "roleDao")
	private RoleDao roleDao;
	
	@Override
	protected GeneralDao<Integer, Role> getDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}

}
