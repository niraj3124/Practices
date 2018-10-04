package com.cg.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.bean.Stu;
import com.cg.dao.StuDaoImpl;

public class Client {

	public static void main(String args[])
	{
		
		StuDaoImpl StuDao= new StuDaoImpl();
		Scanner sc= new Scanner(System.in);
		
		/*System.out.println("Enter roll no.: ");
		int rNo= sc.nextInt();*/
		System.out.println("Enter name: ");
		String name= sc.next();
		
		Stu st = new Stu();
		//st.setRollno(rNo);
		st.setName(name);
		
		StuDao.addStudent(st);
	    System.out.println("Student Added Successfully!!!!!");
	    
	    
	    System.out.println("************DATA IN THE RECORD*****************");
	    System.out.println();
	    List<Stu> stuList = StuDao.getAllStu();
	    System.out.println("Roll_no"+"  "+"  Student_name");
	    for(Stu tempStu : stuList)
	    {
	    	System.out.println(tempStu.getRollno()+"   		"+tempStu.getName());
	    }
	    
	    
	    System.out.println("************DATA SEARCH BY ID*****************");
	    System.out.println("Enter id to search : ");
	    int rno = sc.nextInt();
	    
	    Stu stu = StuDao.getStuById(rno);
	    System.out.println("Student Info is  :"+stu);
	    
	    
	    System.out.println("************DATA SEARCH BY NAME*****************");
	    
	    
	    System.out.println("Enter name to search :");
	    String name1 = sc.next();
	    List<Stu> stuList2 = StuDao.getStuByName(name1);
	    System.out.println("Roll_no"+"  "+"  Student_name");
	    for(Stu tempList2 : stuList2)
	    {
	    	System.out.println(tempList2.getRollno()+"   		"+tempList2.getName());
	    }
	    
	    System.out.println("************DELETE BY ROLL NO****************");
	    System.out.println("Which Roll Number you want to delete");
	    int rrno= sc.nextInt();
	    Stu stuu = StuDao.deleteByRollNo(rrno);
	    System.out.println(stuu.getRollno()+" is Deleted");
	    
	    
	    System.out.println("************UPDATE BY ROLL NO****************");
	    System.out.println("Which Roll Number you want to Update");
	    int rrn= sc.nextInt();
	    System.out.println("Which Name you want to update");
	    String str = sc.next();
	    Stu st3 = new Stu();
	    st3.setRollno(rrn);
	    st3.setName(str);
	    StuDao.updateStudent(st3);
	    System.out.println("Updated Successfully");
	    
	    
	    
	    
	}
	
	
}
