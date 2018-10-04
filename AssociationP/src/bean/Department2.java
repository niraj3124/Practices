package bean;

import java.util.HashSet;
import java.util.Set;

import javax.jws.Oneway;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="DEPT_MASTER")
public class Department2{
	
	@Id
	private int deptid;
	private String deptName;
	
	@OneToMany(mappedBy="department2",cascade=CascadeType.ALL)
	private Set<Employee2> empset = new HashSet<Employee2>();
	

	public Set<Employee2> getEmpset() {
		return empset;
	}

	public void setEmpset(Set<Employee2> empset) {
		this.empset = empset;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public void addEmployee(Employee2 employee) {
		employee.setDepartment2(this);			//this will avoid nested cascade
		this.getEmpset().add(employee);
	}
	
	
}
