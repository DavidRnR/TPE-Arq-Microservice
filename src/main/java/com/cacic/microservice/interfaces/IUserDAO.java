package com.cacic.microservice.interfaces;

import java.util.List;
import com.cacic.microservice.entities.Work;

public interface IUserDAO {
	List<Work> findAllWorksSendedbyAutor(Integer userId);
}
