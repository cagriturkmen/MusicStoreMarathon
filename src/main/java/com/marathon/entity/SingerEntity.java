package com.marathon.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.marathon.types.Genre;
@Entity
@Table(name="singer_table")
public class SingerEntity implements Serializable {

	
	private static final long serialVersionUID = 4241261270917938116L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="singer_id")
	private long id;
	@Column(name="singer_name")
	private String name;
	@Column(name="singer_lastname")
	private String lastname;
	@Column(name="singer_biography")
	private String biography;
	@Temporal(value=TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date date;
	@Enumerated(EnumType.STRING)
	private Genre musicType;
	
	@OneToMany(mappedBy="singer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RecordEntity> recordList;
	

	public SingerEntity() {
	}

	public SingerEntity(String name, String lastname, String biography,Genre musicGenre) {
		
		this.name = name;
		this.lastname = lastname;
		this.biography = biography;
		this.musicType = musicGenre;
	
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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<RecordEntity> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<RecordEntity> recordList) {
		this.recordList = recordList;
	}

	@Override
	public String toString() {
		return "SingerEntity [id=" + id + ", name=" + name + ", lastname=" + lastname + ", biography=" + biography
				 + "]";
	}
	
}
