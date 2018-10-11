package com.tsao.blog.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tsao.blog.dao.GeneralDao;
import com.tsao.blog.service.ReadService;

public abstract class ReadServiceImpl<PK extends Serializable, T> implements ReadService<PK, T>{

	protected abstract GeneralDao<PK, T> getDao();
	
	@Override
	public T detail(PK id) {
		// TODO Auto-generated method stub
		return this.getDao().get(id);
	}

	@Override
	public List<T> queryAll() {
		// TODO Auto-generated method stub
		return this.getDao().queryAll();
	}

	@Override
	public boolean exist(PK id) {
		// TODO Auto-generated method stub
		return (this.getDao().get(id) != null)? true: false;
	}

	@Override
	public List<T> query(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return this.query(param);
	}

}
