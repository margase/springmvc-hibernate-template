package com.iie.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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
	
	public void save(T transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(T persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@Override
	public T findById(Integer id) {
		return (T) getHibernateTemplate().get(persistentClass,id);
	}
	
	public List<T> findByExample(T instance) {
		try {
			List<T> results = (List<T>) getHibernateTemplate()
					.findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@Override
	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from "+persistentClass.getSimpleName()+" as model where model."
					+ propertyName + "= ?";
			System.out.println(queryString);
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from "+persistentClass.getSimpleName();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public T merge(T detachedInstance) {
		try {
			T result = (T) getHibernateTemplate().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(T instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachClean(T instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
