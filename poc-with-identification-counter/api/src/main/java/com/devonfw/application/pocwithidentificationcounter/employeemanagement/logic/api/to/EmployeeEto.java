package com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.Employee;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Employee
 */
public class EmployeeEto extends AbstractEto implements Employee {

	private static final long serialVersionUID = 1L;

	private String companyId;
	private String employeeId;
	private String name;
	private String lastName;

	@Override
	public String getCompanyId() {
		return companyId;
	}

	@Override
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Override
	public String getEmployeeId() {
		return employeeId;
	}

	@Override
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.companyId == null) ? 0 : this.companyId.hashCode());
		result = prime * result + ((this.employeeId == null) ? 0 : this.employeeId.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// class check will be done by super type EntityTo!
		if (!super.equals(obj)) {
			return false;
		}
		EmployeeEto other = (EmployeeEto) obj;
		if (this.companyId == null) {
			if (other.companyId != null) {
				return false;
			}
		} else if (!this.companyId.equals(other.companyId)) {
			return false;
		}
		if (this.employeeId == null) {
			if (other.employeeId != null) {
				return false;
			}
		} else if (!this.employeeId.equals(other.employeeId)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!this.lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}
}
