package com.capgemini.tcc.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;
import com.capgemini.tcc.service.PatientService;


//User Interface which displays the menu and accepts the Input from user
//Create objects for service and executes the respective methods
public class Client {
	static Scanner scan =null;
	static PatientService ps= null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PatientBean p=null;
	static PatientDAO pd =null;
	
	public static void main(String[] args) throws PatientException, IOException {
		
		{
			scan=new Scanner(System.in);
			ps=new PatientService();
			p= new PatientBean();
			pd=new PatientDAO();
			int option1=0;
			do {
			System.out.println("--- TakeCare Clinic Application---");
			System.out.println("1. Add Patient Information");
			System.out.println("2. Search Patient By Id");
			System.out.println("3. Exit");
			System.out.println();
			System.out.println("Choose any one option: ");
			System.out.println();
			
			option1=scan.nextInt();
			switch(option1)
			{
			case 1:
				try{
					
					System.out.println("Enter the name of the Patient : ");
					String patientname=br.readLine();
					ps.validateName(patientname);
					if(!ps.validateName(patientname))
					{
						System.out.println("Invalid Name");
						break;
						
					}
					else
					{
						p.setPatientname(patientname);
						
					}
					System.out.println("Enter Patient Age : ");
					int age=scan.nextInt();
					ps.validateAge(age);
					if(!ps.validateAge(age))
					{
						System.out.println("Invalid age");
						break;	
					}
					else
					{
						p.setAge(age);
						
					}
					
					System.out.println("Enter Patient phone number : ");
					String phoneNumber=br.readLine();
					ps.validatePhone(phoneNumber);
					if(!ps.validatePhone(phoneNumber))
					{
						
						System.out.println("Invalid Phone Number");
						break;
					}
					else
					{
						
						p.setPhonenumber(phoneNumber);
					}
									
					
					System.out.println("Enter Description");
					String description=br.readLine();
					p.setDescription(description);
					
					
					p.setPatientname(patientname);
					p.setAge(age);
					p.setPhonenumber(phoneNumber);
					p.setDescription(description);
					
					int patientid = addPatient(p);
					System.out.println("data is added!!! ur Patient id is : " + patientid+"\n\n");
				}
				catch(PatientException pe)
				{
					System.err.println("Unable to store data::"+pe.getMessage());
				} 
				break;
				
			case 2:
				System.out.println("Enter the transaction id you wanna search....");
				int tId = scan.nextInt();
				PatientBean pd1 = retrieveById(tId);
				System.out.println(pd1);
				break;
			
			case 3:
				System.exit(0);
				break;
			default:
					System.out.println("please enter a valid option between 1-3");
					break;
			}
			}while(option1!=3);
			}

		}
		
			
		private static PatientBean retrieveById(int tId) throws PatientException {
		
			ps = new PatientService();
			return ps.retrieveById(tId);
	}


			public static int addPatient(PatientBean p) throws PatientException {
				PatientService ps = new PatientService();
				return ps.addPatient(p);

}
}
