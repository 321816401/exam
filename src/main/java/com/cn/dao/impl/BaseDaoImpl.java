package com.cn.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.dao.BaseDaoI;

@Repository("baseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDaoI<T> {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
	}


	@Override
	public void delete(T o) {
		this.getCurrentSession().delete(o);
	}


	@Override
	public void update(T o) {
		this.getCurrentSession().update(o);
	}


	@Override
	public List<T> find(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}

//user
    @Override
    public List<T> login(Map<String, Object> params) {
        String hql="FROM User as u where  u.account = ? and u.pazzword = ? and u.type=?";
        Query q = this.getCurrentSession().createQuery(hql);
        q.setParameter(0,params.get("account"));
        q.setParameter(1,params.get("pazzword"));
        q.setParameter(2,params.get("type"));
        return q.list();
    }

}