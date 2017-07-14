package com.hr.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Employee {
	
	private int id;
	// @Range(min=5)
	private String employeeId;
	private String employeeName;
	private int age;
	private String businessTitle;
	private float salary;
	private Date employDate;
	private boolean isHired;

	public Employee(){
		System.out.println("In the Employee empty contruction function.");
	}
	
	public Employee(int id, String employeeId, String employeeName, int age, String businessTitle, float salary, Date employDate, boolean isHired) {
		super();
		this.employeeId = employeeId;
		this.id = id;
		this.employeeName = employeeName;
		this.age = age;
		this.businessTitle = businessTitle;
		this.salary = salary;
		this.employDate = employDate;
		this.isHired = isHired;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBusinessTitle(){
		return businessTitle;
	}
	
	public void setBusinessTitle(String businessTitle){
		this.businessTitle = businessTitle;
	}
	
	public float getSalary(){
		return salary;
	}
	
	public void setSalary(float Salary){
		this.salary = Salary;
	}
	
	public Date getEmployDate() {
		return employDate;
	}

	public void setEmployDate(Date employDate) {
		this.employDate = employDate;
	}

	public boolean isHired() {
		return isHired;
	}

	public boolean getIsHired(){
		return this.isHired;
	}
	
	public void setIsHired(boolean isHired) {
		this.isHired = isHired;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}

//	@Override
//	public String toString() {
//		return String.format(
//				"Employee [id=%s, employeeName=%s, age=%s, businessTitle=%s, salary=%s, employDate=%s, isHired=%s]", 
//				id, employeeName, age, businessTitle, salary, employDate, isHired);
//	}


}
