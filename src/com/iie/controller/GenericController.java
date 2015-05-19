package com.iie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.service.GenericService;

public class GenericController<T> {
	
	@Autowired 
	protected GenericService<T> genericService;
	
	/**
	 * 查询所有实体
	 * @return
	 */
//	@SuppressWarnings("unchecked")
//	@RequestMapping
//	public @ResponseBody List<T> getAll() { 
//		return genericService.findAll();
//    }  
	
	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody T findById(@PathVariable("id") int id) { 
		return genericService.findById(id);
    } 
	
	/**
	 * 根据实体属性查询实体
	 * @param transientInstance
	 * @return
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public @ResponseBody List<T> get(@RequestBody T instance) { 
		return genericService.findByExample(instance);
    }  
	
	/**
	 * 创建实体
	 */
	@RequestMapping(method= RequestMethod.POST)
	public @ResponseBody  void create(@RequestBody T instance) { 
		genericService.save(instance);
    }  
	
	/**
	 * 更新实体
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method= RequestMethod.PUT)
	public @ResponseBody void update(@PathVariable("id") int id,@RequestBody T instance) { 
		genericService.merge(instance);
    }  
	
	/**
	 * 删除实体
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable("id") int id) {
		T instance = genericService.findById(id);
		genericService.delete(instance);
    } 
	
}
