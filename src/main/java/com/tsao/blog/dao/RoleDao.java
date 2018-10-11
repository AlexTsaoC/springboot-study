package com.tsao.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.tsao.blog.entity.Role;

@Mapper
public interface RoleDao extends GeneralDao<Integer, Role>{
	
}
