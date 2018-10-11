package com.tsao.blog.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ReadService<PK extends Serializable, T> {
	
	public T detail(PK id);
	
	public List<T> queryAll();
	
	boolean exist(PK id);
	
	public List<T> query(Map<String, Object> param);
}
