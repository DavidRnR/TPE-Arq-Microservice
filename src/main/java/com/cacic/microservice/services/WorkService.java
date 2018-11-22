package com.cacic.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cacic.microservice.entities.Work;
import com.cacic.microservice.interfaces.IWorkDAO;
import com.cacic.microservice.interfaces.IWorkService;


@Service
public class WorkService implements IWorkService {

	@Autowired
	private IWorkDAO workDAO;

	@Override
	public List<Work> getWorksSendedbyAutor(Integer id) {
		return workDAO.findAllWorksSendedbyAutor(id);
	}

}
