package com.iie.service;

import java.util.List;


public interface GenericService<T> {
	public T findById(int id);
}
