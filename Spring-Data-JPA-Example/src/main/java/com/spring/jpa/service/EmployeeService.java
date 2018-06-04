package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.spring.jpa.entity.EmployeEntity;
import com.spring.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeEntity save(EmployeEntity employeEntity) {
		return employeeRepository.save(employeEntity);
	}	
	
	public Optional<EmployeEntity> getById(Long id) {
		return employeeRepository.findById(id);
	}
	
	public List<EmployeEntity> getAll() {
		return employeeRepository.findAll();
	}
	
	public void deleteById(Long id) {
		 employeeRepository.deleteById(id);
	}

	public Page<EmployeEntity> getByPage(int id) {
		return employeeRepository.findAll(PageRequest.of(id, 2));
	}

	public EmployeEntity getByFname(String fname) {
		return employeeRepository.findByFname(fname);
	}		
}
