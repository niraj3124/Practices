package com.capgemini.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.*;


import org.apache.log4j.Logger;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dbutil.DBConnectivity;
import com.capgemini.tcc.dbutil.IQueryMapper;
import com.capgemini.tcc.exception.PatientException;


public class PatientDAO implements IPatientDAO,IQueryMapper{

	static Logger log = null;
	PatientBean p=null;

	public PatientDAO() {
		PropertyConfigurator.configure("src/resources/log4j.properties");
		log = Logger.getRootLogger();
		log.setLevel(Level.ALL);
		
	}

	Connection conn = null;

	@Override
	public int addPatient(PatientBean p) throws PatientException {
		int retId = 0;
		//PatientDAO asd=new PatientDAO();	
		
		try {
			log.info("program for insertion started");
			conn = DBConnectivity.getConnected();
			PreparedStatement pst = conn.prepareStatement(IQueryMapper.INSERT_PATIENT);
			pst.setString(1, p.getPatientname());
			log.info("name is set :: " + p.getPatientname());
			pst.setInt(2, p.getAge());
			pst.setString(3, p.getPhonenumber());
			pst.setString(4, p.getDescription());
			log.warn("data may not be stored due to DB issue");
			int status = pst.executeUpdate();
			log.info("data is getting stored");
			if (status >= 1) {
				pst = conn.prepareStatement(IQueryMapper.PATIENT_ID_SEQ);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					retId = rs.getInt(1);
					log.info("data is stored with Patient id :: "+retId);
					
				}
			}

		} catch (SQLException e) {
			log.error("error : "+e.getMessage());
			// throw it user defined excep
			throw new PatientException("DB problem : " + e.getMessage());

		}
		return retId;
	}

	@Override
	public PatientBean retrieveById(int tId) throws PatientException {
		PatientDAO asd=new PatientDAO();
		
		try
		{
			
			log.info("program for retrive started");
			conn = DBConnectivity.getConnected();
			PreparedStatement pst = conn.prepareStatement(IQueryMapper.RETRIEVE_PATIENT_DETAILS_BY_ID);
			pst.setInt(1, tId);
			ResultSet rs = pst.executeQuery();
			log.warn("data may not be retrieved due to DB issue");
			if(rs.next())
			{
				p= new PatientBean();
				p.setPatientid(rs.getInt(1));
				p.setPatientname(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setPhonenumber(rs.getString(4));
				p.setDescription(rs.getString(5));
				p.setConsultationdate(rs.getString(6));
				log.info("Data Retrived Successsfully");
			}
			else
			{
				System.out.println("Not Found");
				
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error!!"+e.getMessage());
		}
		return p;
	}

}
