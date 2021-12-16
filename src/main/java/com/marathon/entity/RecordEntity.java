package com.marathon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.marathon.types.Types;
@Entity
@Table(name="record_table")
public class RecordEntity implements Serializable{

	
	private static final long serialVersionUID = 8385918852898974969L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Lob
	@Column(name = "picture")
	private byte[] picture;

	@Column(name = "record_name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="discount_rate")
	private double discount;
	
	@ManyToOne
	@JoinColumn(name="singer_id")
	private SingerEntity singer;
	
	@Enumerated
	private Types type;
	
	@Temporal(value=TemporalType.TIMESTAMP) 
	@CreationTimestamp
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="invoice_id")
	private OrderEntity order;

	public RecordEntity() {
	}

	public RecordEntity(String name,double price, double discount, SingerEntity singer, Types type) {
		
		
		//this.picture = picture;
		this.price= price;
		this.name = name;
		this.discount = discount;
		this.singer = singer;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public SingerEntity getSinger() {
		return singer;
	}

	public void setSinger(SingerEntity singer) {
		this.singer = singer;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "RecordEntity [id=" + id + ", name=" + name + ", price=" + price + ", discount=" + discount + ", singer="
				+ singer + ", type=" + type + ", date=" + date + "]";
	}
	
}
