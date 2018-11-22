package com.cacic.microservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cacic.microservice.entities.User;
import com.cacic.microservice.entities.Work;
import com.cacic.microservice.interfaces.IUserDAO;


@Transactional
@Repository
public class UserDAO implements IUserDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Work> findAllWorksSendedbyAutor(Integer id){
		User user = entityManager.find(User.class, id);
		System.out.println(user);

		if(user == null) {
			throw new IllegalArgumentException("User not exist");
		}

		if(user != null && user.isAuthor()) {
			return user.getWorks();
		}
		return null;

	}

}
