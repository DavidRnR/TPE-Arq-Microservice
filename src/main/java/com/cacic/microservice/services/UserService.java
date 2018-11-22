package com.cacic.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacic.microservice.entities.User;
import com.cacic.microservice.interfaces.IUserDAO;
import com.cacic.microservice.interfaces.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public User getUser(Integer id) {
		return userDAO.finbById(id);
	}

}
