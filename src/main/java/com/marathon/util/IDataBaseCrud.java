package com.marathon.util;

import java.util.ArrayList;

import org.hibernate.Session;

public interface IDataBaseCrud<T> {
	// CRUD
	public void create(T t);
	
	public void delete(T t);
	
	public void update(T t);
	
	default public ArrayList<T> list() {
		return null;
	}
	
	default T find(long id) {
		return null;
	}
	
	default T singleResult(long id) {
		
		return null;
	}
	
	default Session databaseConnectionHibernate() {
		
		return HibernateUtil.getSessionfactory().openSession();
	}
	
}
