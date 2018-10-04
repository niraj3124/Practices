package com.capgemini.tcc.service;


import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;

public class PatientService implements IPatientService{
	
	PatientDAO pdao = null;
	PatientBean p =null;
	
	@Override
	public int addPatient(PatientBean p) throws PatientException {
		pdao=new PatientDAO();
		int patientid=pdao.addPatient(p);
		return patientid;
	}
	
	@Override
	public boolean validateAge(int age) {
		if(age <=0 || age >150)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	@Override
	public boolean validateName(String patientname) {
		
		if(patientname.matches("[A-Z]{1,}.*\\S+.*[a-z]{0,}"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public boolean validatePhone(String phoneNumber) {
		if(phoneNumber.matches("[6789][0-9]{9}"))
		{
			return true;
		}
		else
		{
		return false;
		}
		
		
	}
	@Override
	public PatientBean retrieveById(int tId) throws PatientException {
		PatientDAO pdao = new PatientDAO();
		return pdao.retrieveById(tId);
	}

}
