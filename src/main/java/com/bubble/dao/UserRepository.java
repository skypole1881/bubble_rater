package com.bubble.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bubble.po.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByUsernameAndPassword(String username, String password);
}
