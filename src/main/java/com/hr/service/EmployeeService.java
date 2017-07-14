package com.hr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.model.*;

@Service
public class EmployeeService {
	private static List<Employee> employees = new ArrayList<Employee>();
	private static int employeeCount = 3;
	
	static {
		employees.add(new Employee(1, "1000001", "jim", 30, "VP engineer", 300, new Date(), true));
		employees.add(new Employee(2, "1000002", "peter", 32, "sales engineer", 600, new Date(), false));
		employees.add(new Employee(3, "1000003", "doug", 25, "office engineer", 200, new Date(), false));
	}

	public List<Employee> retrieveEmployeeByName(String employeeName) {
		List<Employee> filtered = new ArrayList<Employee>();
		for(Employee employee : employees) {
			if (employee.getEmployeeName().equals(employeeName))
				filtered.add(employee);
		}
		return filtered;
	}
	
	public List<Employee> retrieveAllEmployees(){
		List<Employee> employeesList = new ArrayList<Employee>();
		for(Employee employee : employees){
			employeesList.add(employee);
		}
		return employeesList;
	}

	public Employee retriveEmployeeByEmployeeId(String employeeId){
		for(Employee employee : employees){
			if(employee.getEmployeeId().equals(employeeId)){
				return employee;
			}
		}
		return null;
	}
	
	public Employee retriveEmployeeById(int id){
		for(Employee employee : employees){
			if(employee.getId() == id){
				return employee;
			}
		}
		return null;
	}
	
	public void updateEmployee(Employee employee){
//		employees.remove(employee);
//		employees.add(employee);
		employees.set(employee.getId()-1, employee);
	}
	
	public void addEmployee(String employeeId, String name, int age, String businessTitle, float salary, Date employeeDate, boolean isHired) {
		int length = employees.size();
		employees.add(new Employee(employees.get(length-1).getId()+1, employeeId, name, age, businessTitle, salary, employeeDate, isHired));
	}

	public void deleteEmployee(int id) {
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			System.out.println("deleteEmployee employeeId=" + employee.getEmployeeId());
			if (employee.getId() == id) {
				iterator.remove();
				System.out.println("Remove employee " + employee.getId());
			}else{
				System.out.println("Can NOT remove employee");
			}
		}
	}
}