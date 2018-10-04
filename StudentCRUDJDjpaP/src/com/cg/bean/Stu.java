package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="students")
public class Stu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="student_id")
	private int rollno;
	@Column(name="stu_name")
	private String name;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Stu [rollno=" + rollno + ", name=" + name + "]";
	}
	
}
