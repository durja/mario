package com.arai.mario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.arai.mario.entity.Source;

@Repository
public class SourceDAO extends AbstractHibernateDAO<Source> implements ISourceDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Source> getSources() {
		List<Source> result = entityManager
			.createQuery("from Source",Source.class)
			.setMaxResults(20)
			.getResultList();
		
		if(result == null) {
			return new ArrayList<>();
		}
		return result;
	}

}
