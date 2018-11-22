package com.cacic.microservice.interfaces;

import com.cacic.microservice.entities.User;

public interface IUserDAO {
	User finbById(Integer id);
}
