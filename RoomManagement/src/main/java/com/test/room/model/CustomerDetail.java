package com.test.room.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CustomerDetail")
public class CustomerDetail {

	@Override
	public String toString() {
		return "EmployeeDetail [empId=" + empId + ", empName=" + empName + "]";
	}
	@Id
	private int empId;
	private String empName;
	
	
	
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String employeeName) {
		this.empName = employeeName;
	}
	
	

}
