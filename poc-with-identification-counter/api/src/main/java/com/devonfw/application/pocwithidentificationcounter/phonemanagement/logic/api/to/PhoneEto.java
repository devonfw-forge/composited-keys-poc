package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to;

import com.devonfw.application.pocwithidentificationcounter.phonemanagement.common.api.Phone;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Phone
 */
public class PhoneEto extends AbstractEto implements Phone {

	private static final long serialVersionUID = 1L;

	private String number;
	private String description;

	private Long employeeId;

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Long getEmployeeId() {
		return employeeId;
	}

	@Override
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());

		result = prime * result + ((this.employeeId == null) ? 0 : this.employeeId.hashCode());
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
		PhoneEto other = (PhoneEto) obj;
		if (this.number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!this.number.equals(other.number)) {
			return false;
		}
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}

		if (this.employeeId == null) {
			if (other.employeeId != null) {
				return false;
			}
		} else if (!this.employeeId.equals(other.employeeId)) {
			return false;
		}
		return true;
	}
}
