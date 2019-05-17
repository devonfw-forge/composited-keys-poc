package com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api;

import com.devonfw.application.pocwithidentificationcounter.general.common.api.ApplicationGenericEntity;

public interface Employee<T extends CompositeEmployeeKey> extends ApplicationGenericEntity<T> {

	/**
	 * @return idId
	 */
	public T getId();

	/**
	 * @param id setter for id attribute
	 */
	public void setId(T id);

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
