package org.pharmacy.poc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.pharmacy.poc.model.User;
import org.pharmacy.poc.model.UserEntity;
import org.pharmacy.poc.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public UserService() {
		// Default Constructor
	}

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	/* Saves the employee entity into MYSQL database */
	public Object save(final User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		repository.save(userEntity);
		user.setEmplId(userEntity.getEmplId());
		return user;
	}

}
