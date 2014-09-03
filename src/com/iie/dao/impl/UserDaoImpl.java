package com.iie.dao.impl;

import org.springframework.stereotype.Repository;

import com.iie.bean.User;
import com.iie.dao.impl.GenericDaoImpl;
import com.iie.dao.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{
	
}
