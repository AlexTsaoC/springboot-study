package com.tsao.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.tsao.blog.entity.Permission;

@Mapper
public interface PermissionDao extends GeneralDao<Integer, Permission>{

	public List<Permission> queryByRoleId(Integer roleId);
}
