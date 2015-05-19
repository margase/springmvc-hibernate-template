package com.iie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.dao.GenericDao;
import com.iie.service.GenericService;

/**
 * Service实现类泛型
 * @author Mary
 *
 * @param <T>
 */
public class GenericServiceImpl<T> implements GenericService<T>{
	
	@Autowired 
	private GenericDao<T> genericDao;

	@Override
	public void save(T instance) {
		genericDao.save(instance);
	}

	@Override
	public void delete(T instance) {
		genericDao.delete(instance);
	}

	@Override
	public T findById(Integer id) {
		return genericDao.findById(id);
	}

	@Override
	public List<T> findByExample(T instance) {
		return genericDao.findByExample(instance);
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		return genericDao.findByProperty(propertyName, value);
	}

	@Override
	public List findAll() {
		return genericDao.findAll();
	}

	@Override
	public T merge(T instance) {
		return genericDao.merge(instance);
	}

	@Override
	public void attachDirty(T instance) {
		genericDao.attachDirty(instance);
	}

	@Override
	public void attachClean(T instance) {
		genericDao.attachClean(instance);
	}

}
