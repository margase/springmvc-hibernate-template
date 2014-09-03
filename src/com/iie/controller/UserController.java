package com.iie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iie.bean.User;
import com.iie.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(
			value = "/{id}", 
			method= RequestMethod.GET)
	@ResponseBody  
	public User find(@PathVariable("id") int id) { 
		User user = userService.findById(id);
        return user;
    }  
}
