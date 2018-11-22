package com.cacic.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cacic.microservice.entities.Work;
import com.cacic.microservice.interfaces.IWorkService;

@RestController
@RequestMapping("user")
public class RESTController {
	
	@Autowired
	private IWorkService workService;
	
	@GetMapping("getWorksSendedbyAutor/{id}")
	public ResponseEntity<List<Work>> getWorksSendedbyAutor(@PathVariable("id") Integer id){
		List<Work> works = workService.getWorksSendedbyAutor(id);
		return new ResponseEntity<List<Work>>(works, HttpStatus.OK);
	}
	
}