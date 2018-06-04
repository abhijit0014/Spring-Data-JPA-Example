package com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.entity.EmployeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeEntity, Long>  {

	EmployeEntity findByFname(String fname);

}
