package com.bubble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubble.dao.UserRepository;
import com.bubble.po.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User checkUser(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		return user;
	}

}
