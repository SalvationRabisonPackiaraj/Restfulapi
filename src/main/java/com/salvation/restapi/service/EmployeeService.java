package com.salvation.restapi.service;

import com.salvation.restapi.entity.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
	
//	Employee saveEmployee(Employee employee, long id);
	
	Employee saveEmployees(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long id);

	Employee updateEmployee(Employee employee, long id);

	void deleteEmployee(long id);

	List<Employee> getDetailsByQuery(String email,String firstname);

	List<Employee> getEmployeesByNamedQuery(String lastName);
}
