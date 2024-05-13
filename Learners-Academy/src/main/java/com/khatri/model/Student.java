package com.khatri.model;

public class Student {

	private int id;
	private String name;
	private String email;
	private String password;
	private int age;
	private String country;
	

	public Student(int id, String name, String password, int age, String country) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.country = country;
	}
	
	public Student() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
				+ ", country=" + country + "]";
	}
	
}
