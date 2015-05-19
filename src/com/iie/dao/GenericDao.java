package com.iie.dao;

import java.util.List;

public interface GenericDao<T> {
	
	public void save(T transientInstance);
	public void delete(T persistentInstance);
	public T findById(Integer id);
	public List<T> findByExample(T instance);
	public List findByProperty(String propertyName, Object value);
	public List findAll();
	public T merge(T detachedInstance);
	public void attachDirty(T instance);
	public void attachClean(T instance);
	
}
