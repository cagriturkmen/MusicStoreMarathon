package com.marathon.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="user_table")
public class UserEntity implements Serializable {

private static final long serialVersionUID = 7415342456873327326L;

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="id")
private long id;
@Column(name="name")
private String name;
@Column(name="lastname")
private String lastname;
@Column(name="mail")
private String mail;
@Column(name="password")
private String password;
@Column(name="address")
private String address;
@Column(name="telephone_number")
private String phoneNumber;
@Temporal(value=TemporalType.TIMESTAMP)
@CreationTimestamp
private Date date;

@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<OrderEntity> orderList;


public UserEntity() {

}

public UserEntity(String mail, String password) {
	this.mail = mail;
	this.password = password;
}

public UserEntity(String name, String lastname, String mail, String password, String address,
		String phoneNumber) {
	
	this.name = name;
	this.lastname = lastname;
	this.mail = mail;
	this.password = password;
	this.address = address;
	this.phoneNumber = phoneNumber;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

@Override
public String toString() {
	return "UserEntity [id=" + id + ", name=" + name + ", lastname=" + lastname + ", mail=" + mail + ", password="
			+ password + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
}


}
