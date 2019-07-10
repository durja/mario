package com.arai.mario.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Source implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private long id;
	
	@Column(nullable=false,unique=true)
	private String name;

	@Column(nullable=false, length=100)
	private String description;
	
	@Column(nullable=false,unique=true)
	private String url;
	
	@Column(nullable=false)
	private String category;
	
	@Column(nullable=false)
	private String country;
	
	public Source() {}

	public Source(String name, String description, String url, String category, String country) {
		this.name = name;
		this.description = description;
		this.url = url;
		this.category = category;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
