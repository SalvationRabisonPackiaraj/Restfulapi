package com.salvation.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salvation.restapi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	String rawQuery = "select * From employees where email = ?1 and first_name = ?2";

	@Query(nativeQuery = true, value = rawQuery)
	List<Employee> getDetailsByDeptName(String email,String firstname);
	
	List<Employee> findAllBylastName(String lastName);

}
