package com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.Employee;
import com.devonfw.application.pocwithidentificationcounter.general.dataaccess.api.ApplicationComposedKeyPersistenceEntity;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.dataaccess.api.PhoneEntity;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends ApplicationComposedKeyPersistenceEntity<CompositeEmployeeKey> implements Employee
		{

	private CompositeEmployeeKey id;

	private String name;

	private String lastName;

	private List<PhoneEntity> phones;

	private static final long serialVersionUID = 1L;


	/*
	 * @Override
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name="employeeId",
	 * column=@Column(name="employeeId",length=10)),
	 * 
	 * @AttributeOverride(name="companyId",
	 * column=@Column(name="companyId",length=10)), })
	 */
	@EmbeddedId
	public CompositeEmployeeKey getId() {
		return id;
	}

	@Override
	public void setId(CompositeEmployeeKey id) {
		this.id = id;
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

	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL,mappedBy="employee")
	public List<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
	}

}
