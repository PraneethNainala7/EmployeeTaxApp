package com.employeeApp.service;

import java.util.List;

import com.employeeApp.model.Employee;
import com.employeeApp.model.EmployeeTax;

public interface EmployeeService {
	
	 public int employeeAdd(Employee emp);
	 
	 public List<EmployeeTax> employeeTaxDetails(String Year);

}
