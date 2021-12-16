package com.marathon.controller;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.marathon.entity.AdminEntity;
import com.marathon.util.IDataBaseCrud;

public class AdminController implements Serializable,IDataBaseCrud<AdminEntity>{
	private static final String ADMIN="admin";
	private static final String PASSWORD="qwerty";


	/**
	 * 
	 */
	private static final long serialVersionUID = 2936359885480683000L;
	private static final Logger logger = LogManager.getLogger(AdminController.class); // logger classı import

	@Override
	public void create(AdminEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamlandı" + AdminController.class);
		} catch (Exception e) {
			logger.warn("Ekleme sırasında hata oluştu" + AdminController.class);
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(AdminEntity entity) {
		try {
			AdminEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("silme tamamlandı" + AdminController.class);
			}
		} catch (Exception e) {
			logger.warn("Silme sırasında hata oluştu" + AdminController.class);
			e.printStackTrace();
		}		
	}

	@Override
	public void update(AdminEntity entity) {
		try {
			AdminEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + AdminEntity.class);
			}
			
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + AdminController.class);
			e.printStackTrace();	
		}
	}
	public boolean adminLogin(AdminEntity entity) {
	if (entity.getName().equals(ADMIN)&&entity.getPassword().equals(PASSWORD)) {
		System.out.println("Successfull admin login");
		return true;
	} else {
		System.out.println("Admin Login not successfull, name or password invalid");
		return false;
	}
	}
	
	public void createUser(String string, String string2) {
		UserController userController = new UserController();
		userController.createUser("","");
	}
	

}
