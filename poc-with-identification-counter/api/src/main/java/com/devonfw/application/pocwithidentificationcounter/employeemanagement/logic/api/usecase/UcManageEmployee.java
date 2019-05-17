package com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.usecase;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeCto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeEto;

/**
 * Interface of UcManageEmployee to centralize documentation and signatures of
 * methods.
 */
public interface UcManageEmployee {

	/**
	 * Deletes a employee from the database by its id 'employeeId'.
	 *
	 * @param employeeId Id of the employee to delete
	 * @return boolean <code>true</code> if the employee can be deleted,
	 *         <code>false</code> otherwise
	 */
	boolean deleteEmployee(CompositeEmployeeKey employeeId);

	/**
	 * Saves a employee and store it in the database.
	 *
	 * @param employee the {@link EmployeeEto} to create.
	 * @return the new {@link EmployeeEto} that has been saved with ID and version.
	 */
	EmployeeEto saveEmployee(EmployeeEto employee);
	/**
	 * Saves a employee and its phones and stores it in the database.
	 *
	 * @param employeeCto the {@link EmployeeCto} to create.
	 * @return the new {@link EmployeeCto} that has been saved with ID and version.
	 */
	EmployeeCto saveEmployeePhone(EmployeeCto employeeCto);
}
