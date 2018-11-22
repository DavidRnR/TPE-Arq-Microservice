package com.cacic.microservice.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public abstract class Category {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "category_id")
	private List<Work> articles;

	public Category() {}

	public Category(String name) {
		this.name = name;
		this.articles = new ArrayList<Work>();
	}

	public boolean addArticle (Work article) {
		return this.articles.add(article);
	}

	public boolean removeArticle (Work article) {
		return this.articles.remove(article);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Work> getArticles() {
		return articles;
	}

	public void setArticles(List<Work> articles) {
		this.articles = articles;
	}

	@Override
	public String toString () {
		return this.name;
	}

	public abstract boolean containsKeyWordsNeeded (List<KeyWord> artKw, List<KeyWord> userKw);
}
