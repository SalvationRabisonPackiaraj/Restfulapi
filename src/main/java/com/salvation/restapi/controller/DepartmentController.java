package com.salvation.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salvation.restapi.entity.Department;
import com.salvation.restapi.service.DepartmentService;


@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	// create employee REST API
		@PostMapping()
		public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
			return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
		}

		// get all employees REST API
		@GetMapping
		public List<Department> getAllDepartments() {
			return departmentService.getAllDepartments();
		}

		// build get employee by id REST API
		// http://localhost:8080/api/departments/1
		@GetMapping("{id}")
		public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long departmentId) {
			return new ResponseEntity<Department>(departmentService.getDepartmentById(departmentId), HttpStatus.OK);
		}

		// build update employee REST API
		// http://localhost:8080/api/departments/1
		@PutMapping("{id}")
		public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id, @RequestBody Department department) {
			return new ResponseEntity<Department>(departmentService.updateDepartment(department, id), HttpStatus.OK);
		}

		// build delete employee REST API
		// http://localhost:8080/api/departments/1
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id) {

			// delete employee from DB
			departmentService.deleteDepartment(id);

			return new ResponseEntity<String>("Department deleted successfully!.", HttpStatus.OK);
		}


}
