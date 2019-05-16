package com.devonfw.application.pocwithidentificationcounter.phonemanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.CompositeEmployeeKeyImpl;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.EmployeeEntity;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.common.api.Phone;
import com.devonfw.application.pocwithidentificationcounter.general.dataaccess.api.ApplicationPersistenceEntity;
import javax.persistence.Transient;

@Entity
@Table(name = "phone")
public class PhoneEntity extends ApplicationPersistenceEntity<Long> implements Phone<Long> {

	private String number;

	private String description;

	private EmployeeEntity employee;

	private static final long serialVersionUID = 1L;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="companyId"),
		@JoinColumn(name="employeeId")
	})
	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	@Override
	@Transient
	public CompositeEmployeeKey getEmployeeId() {

		if (this.employee == null) {
			return null;
		}
		return this.employee.getId();
	}

	@Override
	public void setEmployeeId(CompositeEmployeeKey employeeId) {

		if (employeeId == null) {
			this.employee = null;
		} else {
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity.setId(new CompositeEmployeeKeyImpl(employeeId));
			this.employee = employeeEntity;
		}
	}

}
