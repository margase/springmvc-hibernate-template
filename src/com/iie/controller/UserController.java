package com.iie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iie.bean.User;

@Controller
@RequestMapping("/user")
public class UserController extends GenericController<User>{
	
	@RequestMapping  
	public @ResponseBody List<User> findByUsername(
			@RequestParam(value ="username", required = false) String username ) { 
		User user = new User();
		user.setUsername(username);
		return genericService.findByExample(user);
    } 
 
}
