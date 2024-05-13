package com.khatri.model;


public class LearnersClass {
	
	private int id;
	private String className;
	private Subject subject;
	private Teacher teacher;
	
	public LearnersClass(int id, String className, Subject subject, Teacher teacher) {
		super();
		this.id = id;
		this.className = className;
		this.subject = subject;
		this.teacher = teacher;
	}
	
	public LearnersClass() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", subject=" + subject + ", teacher=" + teacher + "]";
	}

	
}
