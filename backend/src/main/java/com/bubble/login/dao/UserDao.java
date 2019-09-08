package com.bubble.login.dao;

import org.springframework.data.repository.CrudRepository;

import com.bubble.login.model.User;

public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
