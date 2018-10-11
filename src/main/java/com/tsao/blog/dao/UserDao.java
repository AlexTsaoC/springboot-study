package com.tsao.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.tsao.blog.entity.User;


@Mapper
public interface UserDao extends GeneralDao<String, User>{

	public User getByUsername(String username);
}
