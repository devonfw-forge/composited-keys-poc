package com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.Employee;
import com.devonfw.application.pocwithidentificationcounter.general.dataaccess.api.ApplicationPersistenceEntity;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends ApplicationPersistenceEntity implements Employee {

	private String companyId;

	private String employeeId;

	private String name;

	private String lastName;

	private static final long serialVersionUID = 1L;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
