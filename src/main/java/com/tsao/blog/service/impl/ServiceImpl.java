package com.tsao.blog.service.impl;

import java.io.Serializable;
import java.util.Map;

import com.tsao.blog.service.Service;

public abstract class ServiceImpl<PK extends Serializable, T> extends ReadServiceImpl<PK, T> implements Service<PK, T>{

	@Override
	public int insert(T entity) {
		// TODO Auto-generated method stub
		return this.getDao().insert(entity);
	}

	@Override
	public int insert(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return this.getDao().insert(param);
	}

	@Override
	public int delete(PK id) {
		// TODO Auto-generated method stub
		return this.getDao().delete(id);
	}

	@Override
	public int delete(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return this.getDao().delete(param);
	}

	@Override
	public int update(T entity) {
		// TODO Auto-generated method stub
		return this.getDao().update(entity);
	}

	@Override
	public int update(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return this.getDao().update(param);
	}
}
