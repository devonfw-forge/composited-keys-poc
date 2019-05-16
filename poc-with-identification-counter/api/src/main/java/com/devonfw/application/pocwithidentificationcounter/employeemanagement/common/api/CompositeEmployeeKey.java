package com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api;


public class CompositeEmployeeKey{

	private String companyId;
	private String employeeId;


	public CompositeEmployeeKey() {
	}

	public CompositeEmployeeKey(String mixed) {
		super();
		String[] stringVar = mixed.split(",");
		this.companyId = stringVar[0];
		this.employeeId = stringVar[1];
	}

	public CompositeEmployeeKey(String companyId, String employeeId) {
		super();
		this.companyId = companyId;
		this.employeeId = employeeId;
	}

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
}
