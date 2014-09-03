package com.iie.service.impl;

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
	public T findById(int id){
		return genericDao.findById(id);
	}

}
