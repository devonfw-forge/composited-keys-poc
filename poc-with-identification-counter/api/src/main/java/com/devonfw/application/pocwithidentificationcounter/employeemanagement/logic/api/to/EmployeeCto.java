package com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to;

import java.util.List;

import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Employee
 */
public class EmployeeCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private EmployeeEto employee;

	private List<PhoneEto> phones;

	public EmployeeEto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEto employee) {
		this.employee = employee;
	}

	public List<PhoneEto> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEto> phones) {
		this.phones = phones;
	}

}
