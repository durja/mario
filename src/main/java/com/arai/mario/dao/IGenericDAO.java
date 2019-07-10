package com.arai.mario.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {

	public void setClazz(Class<T> clazz);
	
	public T create(T entity);
	
	public T findOne(int id);
	
	public List<T> findAll();
	
	public T update(T entity);
	
	public void delete(T entity);
	
	public void deleteById(int id);
	
}
