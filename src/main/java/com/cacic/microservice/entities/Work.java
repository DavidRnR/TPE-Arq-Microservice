package com.cacic.microservice.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="work")
public class Work {
		
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private Date created;
	private Date reviewed;
	
	@ManyToOne
	private Category category;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "work_keyword",
	joinColumns = @JoinColumn(name = "work_id"), 
	inverseJoinColumns = @JoinColumn(name = "keyword_id"))
	private List<KeyWord> keyWords;
		
	public Work() {}

	public Work(String name, Category category, Date created) {
		this.name = name;
		this.category = category;
		this.created = created;
		this.keyWords = new ArrayList<KeyWord>();
	}
	
	public boolean addKeyWord (KeyWord keyWord) {
		return this.keyWords.add(keyWord);
	}
	
	public boolean removeKeyWord (KeyWord keyWord) {
		return this.keyWords.remove(keyWord);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getReviewed() {
		return this.reviewed;
	}

	public boolean setReviewed(Date reviewed) {
		if(reviewed.after(this.created)) {
			this.reviewed = reviewed;
			return true;
		}
		
		return false;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<KeyWord> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(List<KeyWord> keyWords) {
		this.keyWords = keyWords;
	}
	
	public boolean containsKeyWordsNeeded(List<KeyWord> kw) {
		if(category.containsKeyWordsNeeded(keyWords, kw)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString () {
		return "Nombre: " + this.name + "\n"+ 
				"Creado: " + this.created + "\n"+
				"Revisado: " + this.reviewed + "\n" +
				"Categoria: " + this.category + "\n" +
				"Palabras Clave: " + this.keyWords;
	}
}
