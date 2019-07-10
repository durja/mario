package com.arai.mario.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(value= {"id"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SourceDTO {

	
	private int id;
	
	@NotNull
	@Length(min=2,max=15)
	private String name;
	
	@NotNull
	@Length(min=2, max=100)
	private String description;

	@NotNull
	@Length(min=2, max=100)
	private String url;
	
	@NotNull
	@Length(min=2, max=100)
	private String category;
	
	@NotNull
	@Length(min=2, max=100)
	private String language;
	
	@NotNull
	@Length(min=2, max=50)
	private String country;
	
	public SourceDTO() {}

	public SourceDTO(String name, String description, String url, String category, String language, String country) {
		this.name = name;
		this.description = description;
		this.url = url;
		this.category = category;
		this.language = language;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
