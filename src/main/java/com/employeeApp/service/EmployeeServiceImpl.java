package com.employeeApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeApp.model.Employee;
import com.employeeApp.model.EmployeeTax;
import com.employeeApp.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo repo;

	@Override
	public int employeeAdd(Employee emp) {

		return repo.save(emp).getId();
	}

	@Override
	public List<EmployeeTax> employeeTaxDetails(String frFrom) {

		List<EmployeeTax> employList = new ArrayList<EmployeeTax>();

		String frTo = String.valueOf(Integer.parseInt(frFrom) + 1);
		Optional<List<Employee>> employee = repo.getEmployeeData(frFrom + "-04-01", frTo + "-03-31");
		if (employee.isPresent()) {
			List<Employee> empList = employee.get();
			System.out.println("empList"+empList);
			for (Employee emp : empList) {
				EmployeeTax employVo = new EmployeeTax();
				employVo.setFirstName(emp.getFirstName());
				employVo.setemployeId(emp.getId());
				employVo.setLastName(emp.getLastName());
				employVo.setyearSalary(emp.getsalary() * 12);
				employVo.setTax(taxAmount(emp.getsalary() * 12));
				employVo.setCess(cessAmount(emp.getsalary() * 12));
				employList.add(employVo);
			}

		}

		return employList;
	}

	private Double cessAmount(double income) {
		double cess = 0.0;

		if (income > 2500000) {
			cess = income*0.02;
		}
		return cess;
	}

	private double taxAmount(double income) {
		double tax = 0.0;
		if (income <= 250000) {
            tax = 0.0;
        } else if (income > 250000 && income <= 500000) {
            tax = (income - 250000) * 0.05;
        } else if (income > 500000 && income <= 100000) {
            tax = 12500 + (income - 500000) * 0.1;
        } else if (income > 1000000) {
        	 tax = (income - 1000000) * 0.2 + 62500;
        }
		return tax;
	}

}
