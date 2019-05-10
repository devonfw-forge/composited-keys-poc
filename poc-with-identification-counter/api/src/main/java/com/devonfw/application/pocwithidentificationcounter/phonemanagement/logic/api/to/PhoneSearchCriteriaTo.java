package com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to;

import com.devonfw.application.pocwithidentificationcounter.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.pocwithidentificationcounter.phonemanagement.common.api.Phone}s.
 */
public class PhoneSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String number;
	private String description;

	private Long employeeId;
	private StringSearchConfigTo numberOption;
	private StringSearchConfigTo descriptionOption;

	/**
	 * @return numberId
	 */

	public String getNumber() {
		return number;
	}

	/**
	 * @param number setter for number attribute
	 */

	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return descriptionId
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * @param description setter for description attribute
	 */

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * getter for employeeId attribute
	 * 
	 * @return employeeId
	 */

	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employee setter for employee attribute
	 */

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getNumber() number}.
	 */
	public StringSearchConfigTo getNumberOption() {

		return this.numberOption;
	}

	/**
	 * @param numberOption new value of {@link #getNumberOption()}.
	 */
	public void setNumberOption(StringSearchConfigTo numberOption) {

		this.numberOption = numberOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getDescription() description}.
	 */
	public StringSearchConfigTo getDescriptionOption() {

		return this.descriptionOption;
	}

	/**
	 * @param descriptionOption new value of {@link #getDescriptionOption()}.
	 */
	public void setDescriptionOption(StringSearchConfigTo descriptionOption) {

		this.descriptionOption = descriptionOption;
	}

}
