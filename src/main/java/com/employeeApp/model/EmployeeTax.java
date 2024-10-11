package com.employeeApp.model;

public class EmployeeTax {

	private int employeId;
	private String firstName;
	private String lastName;
	private double yearSalary;
	private double tax;
	private Double cess;

	public int getemployeId() {
		return employeId;
	}

	public void setemployeId(int employeId) {
		this.employeId = employeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getyearSalary() {
		return yearSalary;
	}

	public void setyearSalary(double yearSalary) {
		this.yearSalary = yearSalary;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Double getCess() {
		return cess;
	}

	public void setCess(Double cess) {
		this.cess = cess;
	}

}
