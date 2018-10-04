package bean;

import java.io.Serializable;

import javassist.SerialVersionUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="EMP_MASTER")
public class Employee2 implements Serializable{
	
	private static final long SerialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=10)
	private int empid;
	private String empName;
	private float empSal;
	
	@ManyToOne
	@JoinColumn(name="dept_no")
	private Department2 department2;
	
	
	public Department2 getDepartment2() {
		return department2;
	}
	public void setDepartment2(Department2 department2) {
		this.department2 = department2;
	}
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float f) {
		this.empSal = f;
	}
	
}

