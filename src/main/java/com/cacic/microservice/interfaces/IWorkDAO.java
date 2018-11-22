package com.cacic.microservice.interfaces;

import java.util.List;
import com.cacic.microservice.entities.Work;

public interface IWorkDAO {
	List<Work> findAllWorksSendedbyAutor(Integer userId);
}
