package com.tsao.blog.service;

import java.util.List;

import com.tsao.blog.entity.Permission;

public interface PermissionService extends Service<Integer, Permission>{
	
	public List<Permission> queryByRoleId(Integer roleId);
}
