package com.bubble.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bubble.login.dto.UserDTO;
import com.bubble.login.model.AuthToken;
import com.bubble.login.model.User;
import com.bubble.login.service.JwtUserDetailsService;
import com.bubble.system.enums.ErrorMessageEnum;
import com.bubble.system.exception.BusinessException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	// @Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listUser() {
		return jwtUserDetailsService.findAll();
	}

	// @Secured("ROLE_USER")
	@PreAuthorize("hasRole('USER')")
	//// @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getOne(@PathVariable(value = "id") Long id) {
		return jwtUserDetailsService.findById(id);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public User saveUser(@RequestBody UserDTO user) throws BusinessException {
		if (jwtUserDetailsService.findOne(user.getUsername()) != null) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, user.getUsername() + " is alread exist");
		}
		return jwtUserDetailsService.save(user);
	}
}
