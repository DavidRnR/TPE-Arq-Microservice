package com.cacic.microservice.interfaces;

import com.cacic.microservice.entities.User;

public interface IUserService {
	
	public User getUser(Integer id);
}
