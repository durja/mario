package com.arai.mario.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javassist.bytecode.stackmap.TypeData.ClassName;

@Repository
public abstract class AbstractHibernateDAO<T extends Serializable> {

	private static final Logger log = Logger.getLogger(ClassName.class.getName());

	private Class<T> clazz;


    @Autowired
    private EntityManager entityManager;


  
    public void setClazz(Class< T > clazzToSet){
       this.clazz = clazzToSet;
    }
  
    public T create(T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }
    
    public T findOne(int id){
      return (T) getCurrentSession().get(clazz, id);
    }
 
    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).getResultList();
    }
 
    public T update(T entity) {
        return (T) getCurrentSession().merge(entity);
    }
 
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }
 
    public void deleteById(int entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
 
    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

}
