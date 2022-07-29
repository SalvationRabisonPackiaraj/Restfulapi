package com.salvation.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salvation.restapi.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
