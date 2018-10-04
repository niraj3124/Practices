package com.capgemini.tcc.bean;


//Bean class for Patient with all required properties
public class PatientBean {
	
	private int patientid;
	private String patientname;
	private int age;
	private String phonenumber;
	private String description;
	private String consultationDate;
	
	public PatientBean() {
		super();
	}

	public PatientBean(int patientid, String patientname, int age,
			String phonenumber, String description, String date) {
		super();
		this.patientid = patientid;
		this.patientname = patientname;
		this.age = age;
		this.phonenumber = phonenumber;
		this.description = description;
		this.consultationDate = date;
	}

	@Override
	public String toString() {
		return "PatientBean [patientid=" + patientid + ", patientname="
				+ patientname + ", age=" + age + ", phonenumber=" + phonenumber
				+ ", description=" + description + ", date=" + consultationDate + "]";
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConsultationdate() {
		return consultationDate;
	}

	public void setConsultationdate(String date) {
		this.consultationDate = date;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
