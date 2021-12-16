package com.marathon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="admin_table")
public final class AdminEntity implements Serializable {

	private static final long serialVersionUID = -1750630864038373881L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Temporal(value=TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date date;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminEntity(String name, String password) {
		
		this.name = name;
		this.password = password;
	}
	public AdminEntity() {
	}
	
}
