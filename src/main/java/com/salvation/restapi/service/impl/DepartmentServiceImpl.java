package com.salvation.restapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salvation.restapi.entity.Department;
import com.salvation.restapi.exception.ResourceNotFoundException;
import com.salvation.restapi.repository.DepartmentRepository;
import com.salvation.restapi.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(long id) {
		return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));

	}

	@Override
	public Department updateDepartment(Department department, long id) {

		// check whether department with given id is exist in DB or not
		System.out.println("Hi");
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));
		existingDepartment.setDeptName(department.getDeptName());
		existingDepartment.setLocation(department.getLocation());
		// save existing department to DB
		departmentRepository.save(existingDepartment);
		return existingDepartment;
	}

	@Override
	public void deleteDepartment(long id) {

		// check whether a department exist in a DB or not
		departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));
		departmentRepository.deleteById(id);
	}

}
