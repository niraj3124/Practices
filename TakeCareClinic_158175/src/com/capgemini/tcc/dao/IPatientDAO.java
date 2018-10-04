package com.capgemini.tcc.dao;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;

public interface IPatientDAO {
	
	public int addPatient(PatientBean p) throws PatientException;

	public PatientBean retrieveById(int tId) throws PatientException;

}
