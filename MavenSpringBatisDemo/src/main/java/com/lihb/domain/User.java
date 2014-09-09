package com.lihb.domain;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String name;
	private String email;
	private String title;
	private String time;
	
	public User(){
		
	}
	
	public User(String id, String name, String email, String title, String time) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.title = title;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", title=" + title + ", time=" + time + "]";
	}

	

	
}
