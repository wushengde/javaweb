package com.wushengde.mybatis.beans;

import java.util.List;

public class Classes {
	private int id;
	private String name;
	private Teacher teacher;
	private List<Student> list;
	public Classes() {
		super();
	}
	
	public Classes(int id, String name, Teacher teacher, List<Student> list) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.list = list;
	}

	public Classes(int id, String name, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "id:"+id+";"+"name:"+name+";"+"teacher="+teacher+"List="+list;
	}
	
}
