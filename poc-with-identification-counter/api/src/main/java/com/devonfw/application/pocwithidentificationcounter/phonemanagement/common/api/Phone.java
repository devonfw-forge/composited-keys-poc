package com.devonfw.application.pocwithidentificationcounter.phonemanagement.common.api;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.general.common.api.ApplicationEntity;

public interface Phone<T> extends ApplicationEntity<T> {

	/**
	 * @return numberId
	 */
	public String getNumber();

	/**
	 * @param number setter for number attribute
	 */
	public void setNumber(String number);

	/**
	 * @return descriptionId
	 */
	public String getDescription();

	/**
	 * @param description setter for description attribute
	 */
	public void setDescription(String description);

	/**
	 * getter for employeeId attribute
	 *
	 * @return employeeId
	 */
	public CompositeEmployeeKey getEmployeeId();

	/**
	 * @param employee setter for employee attribute
	 */
	public void setEmployeeId(CompositeEmployeeKey employeeId);

}
