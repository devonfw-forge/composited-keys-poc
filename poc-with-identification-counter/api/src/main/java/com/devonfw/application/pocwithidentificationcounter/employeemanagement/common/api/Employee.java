package com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api;

import com.devonfw.application.pocwithidentificationcounter.general.common.api.ApplicationEntity;

public interface Employee extends ApplicationEntity {

	/**
	 * @return companyIdId
	 */

	public String getCompanyId();

	/**
	 * @param companyId setter for companyId attribute
	 */

	public void setCompanyId(String companyId);

	/**
	 * @return employeeIdId
	 */

	public String getEmployeeId();

	/**
	 * @param employeeId setter for employeeId attribute
	 */

	public void setEmployeeId(String employeeId);

	/**
	 * @return nameId
	 */

	public String getName();

	/**
	 * @param name setter for name attribute
	 */

	public void setName(String name);

	/**
	 * @return lastNameId
	 */

	public String getLastName();

	/**
	 * @param lastName setter for lastName attribute
	 */

	public void setLastName(String lastName);

}
