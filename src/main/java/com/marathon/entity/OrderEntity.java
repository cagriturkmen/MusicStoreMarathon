package com.marathon.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "order_table")
public class OrderEntity implements Serializable {
	
	private static final long serialVersionUID = 469309253542157259L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long invoice_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy="order", fetch = FetchType.LAZY)
	private List<RecordEntity> recordList;
	
	//private RecordEntity record;
	
	private int count;
	
	private double orderPrice;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date creation_date;
	
	
	public OrderEntity() {
		
	}

	public OrderEntity(List<RecordEntity> recordList, double orderPrice) {
		super();
		this.recordList = recordList;
		this.orderPrice = orderPrice;
	}



	public long getInvoice_id() {
		return invoice_id;
	}
	
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	
	public UserEntity getUser() {
		return user;
	}
	
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public List<RecordEntity> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<RecordEntity> recordList) {
		this.recordList = recordList;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public double getSumPrice() {
		return orderPrice;
	}
	
	public void setSumPrice(double sumPrice) {
		this.orderPrice = sumPrice;
	}
	
	public Date getCreation_date() {
		return creation_date;
	}
	
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
}
