package com.tsao.blog.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface GeneralDao<PK extends Serializable, T> {
	public int insert(T entity);
	
	public int insert(Map<String, Object> param);
	
	public int delete(PK pk);
	
	public int delete(Map<String, Object> param);
	
	public int update(T entity);
	
	public int update(Map<String, Object> param);
	
	public T get(PK pk);
	
	public List<T> queryAll();
	
	public List<T> query(Map<String, Object> params);
}
