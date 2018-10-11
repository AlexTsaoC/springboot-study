package com.tsao.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsao.blog.dao.GeneralDao;
import com.tsao.blog.dao.PermissionDao;
import com.tsao.blog.entity.Permission;
import com.tsao.blog.service.PermissionService;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl extends ServiceImpl<Integer, Permission> implements PermissionService{

	@Resource(name = "permissionDao")
	private PermissionDao permissionDao;
	
	@Override
	protected GeneralDao<Integer, Permission> getDao() {
		// TODO Auto-generated method stub
		return this.permissionDao;
	}

	@Override
	public List<Permission> queryByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return this.permissionDao.queryByRoleId(roleId);
	}

}
