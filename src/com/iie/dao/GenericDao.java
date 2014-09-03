package com.iie.dao;

public interface GenericDao<T> {
	public T findById(int id);
}
