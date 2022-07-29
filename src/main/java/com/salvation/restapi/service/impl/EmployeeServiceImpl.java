package com.salvation.restapi.service.impl;

import org.springframework.stereotype.Service;

import com.salvation.restapi.entity.Employee;
import com.salvation.restapi.exception.ResourceNotFoundException;
import com.salvation.restapi.repository.EmployeeRepository;
import com.salvation.restapi.service.EmployeeService;


import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployees(Employee employee) {
		return employeeRepository.save(employee);
	}

//	@Override
//	public Employee saveEmployee(Employee employee,long id) {
//		Department department = departmentRepository.findById(id).get();
//		employee.setDepartment(department);
//		return employeeRepository.save(employee);
//	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "Id", id));
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id)); 
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getDetailsByQuery(String email,String firstname) {
		List<Employee> empList = employeeRepository.getDetailsByDeptName(email,firstname);
		return empList;
	}

	@Override
	public List<Employee> getEmployeesByNamedQuery(String lastName) {
		List<Employee> empName = employeeRepository.findAllBylastName(lastName);
		return empName;
	}
	
}
