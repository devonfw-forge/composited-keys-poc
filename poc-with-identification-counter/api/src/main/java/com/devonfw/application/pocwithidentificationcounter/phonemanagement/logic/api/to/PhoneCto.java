package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Phone
 */
public class PhoneCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private PhoneEto phone;

	private EmployeeEto employee;

	public PhoneEto getPhone() {
		return phone;
	}

	public void setPhone(PhoneEto phone) {
		this.phone = phone;
	}

	public EmployeeEto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEto employee) {
		this.employee = employee;
	}

}
