package com.iie.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.iie.dao.GenericDao;

/**
 * Dao实现类泛型
 * @author Mary
 *
 * @param <T>
 */
public class GenericDaoImpl<T> extends HibernateDaoSupport implements GenericDao<T>{
	
	protected Class<T> persistentClass;
	
	@SuppressWarnings({"unchecked"})
	public GenericDaoImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Resource(name = "sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public T findById(int id) {
		return (T) getHibernateTemplate().get(persistentClass,id);
	}
	
}
