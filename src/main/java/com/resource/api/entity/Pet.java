package com.resource.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class Pet implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long petid;
	private String petname;
	private String petrace;
	private int petage;
	private Long petuser;
	private String petimage;
	
	public Pet() {	
	
	}
	
	public Pet(Long petid, String petname, String petrace, int petage, Long petuser) {
		super();
		this.petid = petid;
		this.petname = petname;
		this.petrace = petrace;
		this.petage = petage;
		this.petuser = petuser;
	}

	public Long getPetid() {
		return petid;
	}
	
	public void setPetid(Long petid) {
		this.petid = petid;
	}
	
	public String getPetname() {
		return petname;
	}
	
	public void setPetname(String petname) {
		this.petname = petname;
	}
	
	public String getPetrace() {
		return petrace;
	}
	
	public void setPetrace(String petrace) {
		this.petrace = petrace;
	}
	
	public int getPetage() {
		return petage;
	}
	
	public void setPetage(int petage) {
		this.petage = petage;
	}

	public Long getPetuser() {
		return petuser;
	}

	public void setPetuser(Long petuser) {
		this.petuser = petuser;
	}

	public String getPetimage() {
		return petimage;
	}

	public void setPetimage(String petimage) {
		this.petimage = petimage;
	}

}
	

	

