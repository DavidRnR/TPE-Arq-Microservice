package com.cacic.microservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cacic.microservice.entities.User;
import com.cacic.microservice.entities.Work;
import com.cacic.microservice.interfaces.IUserDAO;
import com.cacic.microservice.interfaces.IWorkDAO;
import com.cacic.microservice.services.UserService;

@Transactional
@Repository
public class WorkDAO implements IWorkDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Work> findAllWorksSendedbyAutor(Integer id){
		User user = userService.getUser(id);

		if(user == null) {
			throw new IllegalArgumentException("el autor no existe");
		}
		else {
			System.out.println("****************************ARRANCA*********************************************");
			System.out.println(user);
			System.out.println("*******************************TERMINAAAAA******************************************");
		}
//		
//		Query query = entityManager.createNativeQuery("SELECT DISTINCT(t.id ),t.* from work w "
//				+ "join autor_trabajo sat on (t.id = sat.trabajo_id and sat.autor_id = :id) "
//				+ "left join evaluador_trabajo et on (et.trabajo_id = t.id) "
//				+ "left join evaluador_trabajo_pendiente etp on (etp.trabajo_pendiente_id = t.id)",Work.class);
		
		Query query = entityManager.createNativeQuery("SELECT * FROM work",Work.class);

//		query.setParameter("id", id);
		return (List<Work>) query.getResultList();

	}

}
