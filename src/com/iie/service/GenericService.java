package com.iie.service;

import java.util.List;


public interface GenericService<T> {
	
	public void save(T instance);
	public void delete(T instance);
	public T findById(Integer id);
	public List<T> findByExample(T instance);
	public List findByProperty(String propertyName, Object value);
	public List findAll();
	public T merge(T instance);
	public void attachDirty(T instance);
	public void attachClean(T instance);
	
}
