package com.employeeApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employeeApp.model.Employee;
import com.employeeApp.model.EmployeeTax;
import com.employeeApp.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("EmpApiCall")
public class EmployeeController {

	@Autowired
	EmployeeService empServ;

	@RequestMapping(method = RequestMethod.POST, path = "/saveEmp")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee emp) {
		int empId = empServ.employeeAdd(emp);
		return ResponseEntity.ok("Employee Created with ID :" + empId);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/emp")
	public ResponseEntity<List<EmployeeTax>> getEmployee(@RequestParam("Year") @Pattern(regexp="\\d{4}") String year) {
		List<EmployeeTax> employeeTaxList = empServ.employeeTaxDetails(year);
		return ResponseEntity.ok(employeeTaxList);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex) {
	    Map<String, Object> responseBody = new HashMap<>();
	    responseBody.put("error", "Validation failed");
	    responseBody.put("details", ex.getBindingResult().getAllErrors());
	    return ResponseEntity.badRequest().body(responseBody);
	}


}
