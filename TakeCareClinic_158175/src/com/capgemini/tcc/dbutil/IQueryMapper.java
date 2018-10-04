package com.capgemini.tcc.dbutil;

public interface IQueryMapper {
	
	public static final String INSERT_PATIENT = "INSERT INTO Patient values(Patient_Id_Seq.NEXTVAL,?,?,?,?,SYSDATE)";
	public static final	String PATIENT_ID_SEQ="SELECT Patient_Id_Seq.currval FROM dual";
	public static final String RETRIEVE_PATIENT_DETAILS_BY_ID = "SELECT * FROM Patient where patient_id=?";

}
