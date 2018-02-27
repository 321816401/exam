package com.cn.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDaoI<T> {

	public Serializable save(T o);

	public void delete(T o);

	public void update(T o);

	public List<T> find(String hql);

//user
    public List<T> login(Map<String, Object> params);

}