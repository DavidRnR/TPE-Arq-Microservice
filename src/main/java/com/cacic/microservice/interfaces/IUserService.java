package com.cacic.microservice.interfaces;

import java.util.List;

import com.cacic.microservice.entities.Work;


public interface IUserService {
	public List<Work> getWorksSendedbyAutor(Integer id);
	
}
