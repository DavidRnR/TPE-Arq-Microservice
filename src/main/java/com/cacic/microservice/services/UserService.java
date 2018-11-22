package com.cacic.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacic.microservice.entities.Work;
import com.cacic.microservice.interfaces.IUserDAO;
import com.cacic.microservice.interfaces.IUserService;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<Work> getWorksSendedbyAutor(Integer id) {
		return userDAO.findAllWorksSendedbyAutor(id);
	}

}
