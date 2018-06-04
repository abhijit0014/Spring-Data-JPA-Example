package com.spring.jpa.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.AddressEntity;
import com.spring.jpa.entity.EmployeEntity;
import com.spring.jpa.entity.EmployeeDetails;
import com.spring.jpa.entity.ProjectEntity;
import com.spring.jpa.service.EmployeeService;

@RestController
public class RootController {

	private EmployeeService employeService;
	public RootController(EmployeeService employeService) {
		this.employeService = employeService;
	}

	@PostMapping("/add")
	public void add(@RequestBody EmployeEntity employeEntity) {
		
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCity("kolkata");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setGender("male");
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectName("chatbot 2");
		
		
		employeEntity.setEmployeeDetails(employeeDetails);
		employeEntity.getAddressEntities().add(addressEntity);
		employeEntity.getProjectEntities().add(projectEntity);
		
		employeService.save(employeEntity);
	}
	
	@GetMapping("/get/{id}")
	public void getById(@PathVariable Long id) {
		System.out.println(id);
	}	

	@GetMapping("/get/page/{id}")
	public Page<EmployeEntity> getByPage(@PathVariable int id) {
		return employeService.getByPage(id);
	}
	
	@GetMapping("/get/fname/{fname}")
	public EmployeEntity getByFname(@PathVariable String fname) {
		return employeService.getByFname(fname);
	}
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		System.out.println(id);
	}	
}
