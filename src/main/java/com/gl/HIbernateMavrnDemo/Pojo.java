package com.gl.HIbernateMavrnDemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// author is a database managed entity
@Entity
public class Pojo {
	@Id
	private int id;
	private String f_Name;
	private String l_Name;
	private String email;
	
	public Pojo(int id, String f_Name, String l_Name, String email) {
		this.id = id;
		this.f_Name = f_Name;
		this.l_Name = l_Name;
		this.email = email;
	}
	
	public Pojo() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getF_Name() {
		return f_Name;
	}
	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}
	public String getL_Name() {
		return l_Name;
	}
	public void setL_Name(String l_Name) {
		this.l_Name = l_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Pojo [id=" + id + ", f_Name=" + f_Name + ", l_Name=" + l_Name + ", email=" + email + "]";
	}
	
}