package com.moddb.app.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moddb.app.model.User;
import com.moddb.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	@Autowired
	UserService userService;
	@GetMapping
	public Collection<User> getAll(){
		return userService.getAll();
	}
}
