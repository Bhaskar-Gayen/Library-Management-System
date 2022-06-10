package com.plazmateq.UserManageService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int card_id;
	private String name;
	private String gender;
	private int age;
	private String password;
	
	public User() {}
	
	public User(int card_id, String name, int age, String gender, String password) {
		super();
		this.card_id = card_id;
		this.name = name;
		this.age = age;
		this.gender=gender;
		this.password=password;
	}

	public int getcard_id() {
		return card_id;
	}
	public void setcard_id(int card_id) {
		this.card_id = card_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
