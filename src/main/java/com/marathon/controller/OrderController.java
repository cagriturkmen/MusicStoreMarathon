package com.marathon.controller;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.marathon.entity.OrderEntity;
import com.marathon.entity.RecordEntity;
import com.marathon.util.IDataBaseCrud;

public class OrderController implements IDataBaseCrud<OrderEntity>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5497367794014716490L;
	private static final Logger logger = LogManager.getLogger(OrderController.class); // logger classı import

	public OrderController(List<RecordEntity> recordList, double d) {
		// TODO Auto-generated constructor stub
	}

	public OrderController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(OrderEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("kayıt işlemi tamamdır" + SingerController.class);
		} catch (Exception e) {
			logger.error("kayıt işleme anında hata meydana geldi !!!!! " + SingerController.class);
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(OrderEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderEntity t) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void createOrder() {
		
		//UserEntity user, RecordEntity record, double orderPrice
		
		
		Session session = databaseConnectionHibernate();
		String recordHql ="select t from RecordEntity as t where t.name =:key";
	
		
		TypedQuery <RecordEntity> typedQuery = session.createQuery(recordHql, RecordEntity.class);
		typedQuery.setParameter("key", "Toxic");
		
		List<RecordEntity> recordList = typedQuery.getResultList();
		
		OrderEntity order = new OrderEntity(recordList,200.0);
		create(order);

}
}
