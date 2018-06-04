package com.spring.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	private String fname;
	private String lname;
	private String email;
	private String pass;
	
	@OneToOne(mappedBy="employeEntity", cascade=CascadeType.ALL)
	private EmployeeDetails employeeDetails;
	
	@OneToMany(mappedBy="employeEntity", cascade=CascadeType.ALL)
	private List<AddressEntity> addressEntities = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name = "employee_project",
    joinColumns = { @JoinColumn(name = "employeeId") },
    inverseJoinColumns = { @JoinColumn(name = "projectId") })
	private List<ProjectEntity> projectEntities = new ArrayList<>();
	

	public List<ProjectEntity> getProjectEntities() {
		return projectEntities;
	}
	public void setProjectEntities(List<ProjectEntity> projectEntities) {
		this.projectEntities = projectEntities;
	}
	public List<AddressEntity> getAddressEntities() {
		return addressEntities;
	}
	public void setAddressEntities(List<AddressEntity> addressEntities) {
		this.addressEntities = addressEntities;
	}
	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
