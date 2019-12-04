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
@Table(name="users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userid;
	private String usernames;
	private String useremail;
	private String userpassword;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="petuser",referencedColumnName="userid")
	
	private List<Pet> pets = new ArrayList<>();
	
	public List<Pet> getPets() {
		return pets;
	}
	
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	public Long getUserid() {
		return userid;
	}
	
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	public String getUsernames() {
		return usernames;
	}
	
	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}
	
	public String getUseremail() {
		return useremail;
	}
	
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	public String getUserpassword() {
		return userpassword;
	}
	
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

}
