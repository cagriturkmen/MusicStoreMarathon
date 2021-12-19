package com.marathon.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.marathon.entity.RecordEntity;
import com.marathon.entity.SingerEntity;
import com.marathon.util.IDataBaseCrud;

public class RecordController implements IDataBaseCrud<RecordEntity> , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4925782738658787740L;
	private static final Logger logger = LogManager.getLogger(RecordController.class); // logger classı import

	@Override
	public void create(RecordEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamlandı" + RecordController.class);
		} catch (Exception e) {
			logger.warn("Ekleme sırasında hata oluştu" + RecordController.class);
			e.printStackTrace();
		}					
	}

	@Override
	public void delete(RecordEntity record) {
			
	}

	@Override
	public void update(RecordEntity t) {
		// TODO Auto-generated method stub
		
	}
	public RecordEntity find(long id) {

	    Session session = databaseConnectionHibernate();
	    RecordEntity entity;
	    try {
	      entity = session.find(RecordEntity.class, id);

	      if (entity != null) {
	        logger.info(entity.toString());
	        return entity;
	      } else {
	        return null;
	      }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return null;
	  }
		
	
	
	  public List<RecordEntity> listLastTenRecord() {
	    Session session = databaseConnectionHibernate();

	    String hql = "select str from RecordEntity as str ";
	    TypedQuery<RecordEntity> typedQuery = session.createQuery(hql, RecordEntity.class);
	    typedQuery.setMaxResults(10);
	    ArrayList<RecordEntity> arrayList = (ArrayList<RecordEntity>) typedQuery.getResultList();

	    return arrayList;
	  }

	  
	  public List<RecordEntity> listDiscountedFifteenAlbum() {
	    Session session = databaseConnectionHibernate();

	    String hql =
	        "select str from RecordEntity as str  ";
	    TypedQuery<RecordEntity> typedQuery = session.createQuery(hql, RecordEntity.class);
	    typedQuery.setMaxResults(15);
	    ArrayList<RecordEntity> arrayList = (ArrayList<RecordEntity>) typedQuery.getResultList();

	    return arrayList;
	  }

	  
	  public List<RecordEntity> listByGenre(String tag) {
	    Session session = databaseConnectionHibernate();

	    String hql =
	        "select str from RecordEntity as str ";
	    TypedQuery<RecordEntity> typedQuery = session.createQuery(hql, RecordEntity.class);
	    typedQuery.setParameter("tag", "%" + tag + "%");
	    ArrayList<RecordEntity> arrayList = (ArrayList<RecordEntity>) typedQuery.getResultList();

	    return arrayList;
	  }

	 
	  public List<RecordEntity> listBySinger(SingerEntity singer) {
	    Session session = databaseConnectionHibernate();

	    String hql = "select str from RecordEntity as str";
	    TypedQuery<RecordEntity> typedQuery = session.createQuery(hql, RecordEntity.class);
	    typedQuery.setParameter("tag", singer);
	    ArrayList<RecordEntity> arrayList = (ArrayList<RecordEntity>) typedQuery.getResultList();

	    return arrayList;
	  }

	  
	  public List<RecordEntity> listBySalesCount() {
	    Session session = databaseConnectionHibernate();

	    String hql = "select str from RecordEntity as str";
	    TypedQuery<RecordEntity> typedQuery = session.createQuery(hql, RecordEntity.class);
	    ArrayList<RecordEntity> arrayList = (ArrayList<RecordEntity>) typedQuery.getResultList();

	    return arrayList;
	  }

}
