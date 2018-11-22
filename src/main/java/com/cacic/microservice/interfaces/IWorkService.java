package com.cacic.microservice.interfaces;

import java.util.List;

import com.cacic.microservice.entities.Work;


public interface IWorkService {
	public List<Work> getWorksSendedbyAutor(Integer id);
	
}
