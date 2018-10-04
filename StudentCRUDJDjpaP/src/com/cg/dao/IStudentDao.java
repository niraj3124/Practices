package com.cg.dao;

import java.util.List;

import com.cg.bean.Stu;

public interface IStudentDao {

	public void addStudent(Stu stu);
	public List<Stu> getAllStu();
	public Stu getStuById(int rNo);
	public List<Stu> getStuByName(String name);
	public Stu deleteByRollNo(int rNo);
	public void updateStudent(Stu stu);


}
