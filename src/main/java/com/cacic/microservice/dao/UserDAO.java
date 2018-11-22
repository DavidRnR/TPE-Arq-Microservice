package com.cacic.microservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cacic.microservice.entities.User;
import com.cacic.microservice.interfaces.IUserDAO;

@Transactional
@Repository
public class UserDAO implements IUserDAO {


	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User finbById(Integer id) {
		return entityManager.find(User.class, id);
	}
}
