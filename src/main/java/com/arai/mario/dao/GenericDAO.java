package com.arai.mario.dao;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericDAO<T extends Serializable> extends AbstractHibernateDAO<T> implements IGenericDAO<T> {

	//
}