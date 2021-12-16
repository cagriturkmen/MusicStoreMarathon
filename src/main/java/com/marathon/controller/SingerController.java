package com.marathon.controller;

import java.io.Serializable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.marathon.entity.SingerEntity;
import com.marathon.util.IDataBaseCrud;

public class SingerController implements IDataBaseCrud<SingerEntity> , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8012671842408707302L;
	private static final Logger logger = LogManager.getLogger(SingerController.class); // logger classı import

	@Override
	public void create(SingerEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamlandı" + SingerController.class);
		} catch (Exception e) {
			logger.warn("Ekleme sırasında hata oluştu" + SingerController.class);
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(SingerEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SingerEntity t) {
		// TODO Auto-generated method stub
		
	}

}
