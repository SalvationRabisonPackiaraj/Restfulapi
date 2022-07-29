package com.salvation.restapi.controller;

import com.salvation.restapi.entity.Employee;
import com.salvation.restapi.service.EmployeeService;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// create employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployees(employee), HttpStatus.CREATED);
	}

//	// create employee by id REST API 
//	@PostMapping("/{id}")
//	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee,@PathVariable ("id") long id) {
//		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee,id), HttpStatus.CREATED);
//	}

	// get all employees REST API
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// build get employee by id REST API
	// http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	// build update employee REST API
	// http://localhost:8080/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	// build delete employee REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

		// delete employee from DB
		employeeService.deleteEmployee(id);

		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}
	
	
	// Raw query API
	@GetMapping ("/raw")
	public List<Employee> getDetailsByQuery(@RequestParam ("email") String email,@RequestParam("firstname") String firstname){
		return  employeeService.getDetailsByQuery(email,firstname);
	}
	
	//NamedQuery
	@GetMapping("/name")
	public List<Employee> getEmployeesByNamedQuery(@RequestParam ("lastName")String lastName) {
		return employeeService.getEmployeesByNamedQuery(lastName);
	}
	
	
	

}
