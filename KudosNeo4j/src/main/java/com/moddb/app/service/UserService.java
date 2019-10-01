package com.moddb.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moddb.app.model.User;
import com.moddb.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public Collection<User>getAll(){
		return userRepository.getAllUsers();
	}

}
