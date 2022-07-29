package com.salvation.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.salvation.restapi.entity.Department;
import com.salvation.restapi.entity.Employee;
import com.salvation.restapi.repository.EmployeeRepository;

@SpringBootApplication
public class RestfulapiApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(RestfulapiApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//
//		Employee employee = new Employee();
//
//		employee.setFirstName("RajeshWaran");
//		employee.setLastName("M");
//		employee.setEmail("rajesh@gmail.com");
//
//		Department department = new Department();
//
//		department.setDeptName("HR");
//		department.setLocation("Bangalore");
//
//		employee.setDepartment(department);
//		department.setEmployee(employee);
//
//		employeeRepository.save(employee);

	}
}