package com.capgemini.tcc.service;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;

public interface IPatientService {
	
	public int addPatient(PatientBean p) throws PatientException;

	boolean validateName(String patientname) throws PatientException;

	boolean validateAge(int age) throws PatientException;

	boolean validatePhone(String phoneNumber) throws PatientException;

	public PatientBean retrieveById(int tId) throws PatientException;

}
