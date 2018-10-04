package com.cg.ems.dbutil;

public interface IQueryMapper {

	public static final	String INSERT_EMPLOYEE_INFO="INSERT INTO Employee values(emp_seq3.NEXTVAL,?,?,?,?)";
	public static final	String RETRIEVE_EMP_BY_ID="SELECT * FROM Employee where empid=?";
	public static final	String EMP_SEQ_CURR_ID="SELECT emp_seq3.currval FROM dual";
	public static final String MSG_MOBILE_PROPMPT="enter mobile";
	public static final	String RETRIEVE_ALL_EMP="SELECT * FROM Employee";
	public static final String DELETE_EMP_ID = "DELETE FROM Employee WHERE empid=?";
	public static final String UPDATE_EMP_ID = "UPDATE Employee set name = 'Hello' where empid=?";

}
