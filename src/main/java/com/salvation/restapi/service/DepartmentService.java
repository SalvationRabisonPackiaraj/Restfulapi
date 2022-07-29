package com.salvation.restapi.service;

import java.util.List;

import com.salvation.restapi.entity.Department;


public interface DepartmentService {
	Department saveDepartment(Department department);

	List<Department> getAllDepartments();

	Department getDepartmentById(long id);

	Department updateDepartment(Department department, long id);

	void deleteDepartment(long id);


}
