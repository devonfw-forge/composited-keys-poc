package com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to;

import com.devonfw.application.pocwithidentificationcounter.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.Employee}s.
 */
public class EmployeeSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String companyId;
	private String employeeId;
	private String name;
	private String lastName;
	private StringSearchConfigTo companyIdOption;
	private StringSearchConfigTo employeeIdOption;
	private StringSearchConfigTo nameOption;
	private StringSearchConfigTo lastNameOption;

	/**
	 * @return companyIdId
	 */

	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId setter for companyId attribute
	 */

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return employeeIdId
	 */

	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId setter for employeeId attribute
	 */

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return nameId
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name setter for name attribute
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return lastNameId
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName setter for lastName attribute
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getCompanyId() companyId}.
	 */
	public StringSearchConfigTo getCompanyIdOption() {

		return this.companyIdOption;
	}

	/**
	 * @param companyIdOption new value of {@link #getCompanyIdOption()}.
	 */
	public void setCompanyIdOption(StringSearchConfigTo companyIdOption) {

		this.companyIdOption = companyIdOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getEmployeeId() employeeId}.
	 */
	public StringSearchConfigTo getEmployeeIdOption() {

		return this.employeeIdOption;
	}

	/**
	 * @param employeeIdOption new value of {@link #getEmployeeIdOption()}.
	 */
	public void setEmployeeIdOption(StringSearchConfigTo employeeIdOption) {

		this.employeeIdOption = employeeIdOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for {@link #getName()
	 *         name}.
	 */
	public StringSearchConfigTo getNameOption() {

		return this.nameOption;
	}

	/**
	 * @param nameOption new value of {@link #getNameOption()}.
	 */
	public void setNameOption(StringSearchConfigTo nameOption) {

		this.nameOption = nameOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getLastName() lastName}.
	 */
	public StringSearchConfigTo getLastNameOption() {

		return this.lastNameOption;
	}

	/**
	 * @param lastNameOption new value of {@link #getLastNameOption()}.
	 */
	public void setLastNameOption(StringSearchConfigTo lastNameOption) {

		this.lastNameOption = lastNameOption;
	}

}
