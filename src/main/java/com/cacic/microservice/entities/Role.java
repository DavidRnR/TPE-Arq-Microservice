package com.cacic.microservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Role() {}

	public Role(String name) {
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public boolean isEvaluador () {
		return this.name.equals("evaluador");
	}
	
	@JsonIgnore
	public boolean isAutor () {
		return this.name.equals("autor");
	}
	
	@Override
	public String toString () {
		return this.name;
	}
}
