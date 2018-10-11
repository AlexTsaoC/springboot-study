package com.tsao.blog.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Service<PK extends Serializable, T> extends ReadService<PK, T>{
	
	public int insert(T entity);
	
	public int insert(Map<String, Object> param);
	
	public int delete(PK id);
	
	public int delete(Map<String, Object> param);
	
	public int update(T entity);
	
	public int update(Map<String, Object> param);
	
}
