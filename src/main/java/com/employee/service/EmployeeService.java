package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.model.Employee;

public interface EmployeeService 
{
	List<Employee> findAllEmployees();

	Employee createEmployee(Employee employee);

	Optional<Employee> findEmployeeById(long employeeId);

	Optional<Employee> updateEmployeeById(long employeeId, Employee employee);

	String removeEmployeeById(long employeeId);
}
