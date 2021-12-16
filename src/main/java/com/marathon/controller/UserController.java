package com.marathon.controller;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.marathon.entity.UserEntity;
import com.marathon.util.IDataBaseCrud;

public class UserController implements IDataBaseCrud<UserEntity> , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7116212615695277308L;

	private static final Logger logger = LogManager.getLogger(UserController.class); // logger classı import

	@Override
	public void create(UserEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamlandı" + UserController.class);
		} catch (Exception e) {
			logger.warn("Ekleme sırasında hata oluştu" + UserController.class);
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(UserEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserEntity t) {
		// TODO Auto-generated method stub
		
	}
	public boolean login(UserEntity entity) {
		Session session = databaseConnectionHibernate();
		
		String hql = "select user from  UserEntity as user where user.mail=:key1 and user.password =:key2 ";
		TypedQuery<UserEntity> typedQuery = session.createQuery(hql,UserEntity.class);
		typedQuery.setParameter("key1", entity.getMail());
		typedQuery.setParameter("key2", entity.getPassword());
		
		List<UserEntity> userList = typedQuery.getResultList();
		logger.info("Listelendi"+ UserEntity.class);
		
		return ((userList.size()<1) ? false:true);
	}

	public void createUser(String userName, String userPassword) {
		// TODO Auto-generated method stub
		
	}

}
