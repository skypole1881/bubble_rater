package com.bubble.login.service;

import java.util.List;

import com.bubble.login.dto.UserDTO;
import com.bubble.login.model.User;

public interface UserService {
	User save(UserDTO user);

	List<User> findAll();

	void delete(long id);

	User findOne(String username);

	User findById(Long id);
}
