package com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.CompositeEmployeeKeyImpl;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api.EmployeeEntity;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeCto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeEto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.usecase.UcManageEmployee;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.base.usecase.AbstractEmployeeUc;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.dataaccess.api.PhoneEntity;
import com.devonfw.application.pocwithidentificationcounter.phonemanagement.logic.api.to.PhoneEto;

/**
 * Use case implementation for modifying and deleting Employees
 */
@Named
@Validated
@Transactional
public class UcManageEmployeeImpl extends AbstractEmployeeUc implements UcManageEmployee {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageEmployeeImpl.class);

	@Override
	public boolean deleteEmployee(CompositeEmployeeKey id) {

		EmployeeEntity employee = getEmployeeRepository().find(new CompositeEmployeeKeyImpl(id));
		getEmployeeRepository().delete(employee);
		LOG.debug("The employee with id '{}' has been deleted.", id);
		return true;
	}

	@Override
	public EmployeeEto saveEmployee(EmployeeEto employee) {

		Objects.requireNonNull(employee, "employee");

		EmployeeEntity employeeEntity = getBeanMapper().map(employee, EmployeeEntity.class);

		// initialize, validate employeeEntity here if necessary
		EmployeeEntity resultEntity = getEmployeeRepository().save(employeeEntity);
		LOG.debug("Employee with id '{}' has been created.", resultEntity.getId());
		return getBeanMapper().map(resultEntity, EmployeeEto.class);
	}

	@Override
	public EmployeeCto saveEmployeePhone(EmployeeCto employeeCto) {

		Objects.requireNonNull(employeeCto, "employee");


		EmployeeEntity employeeEntity = getBeanMapper().map(employeeCto.getEmployee(), EmployeeEntity.class);

		employeeEntity.setPhones(getBeanMapper().mapList(employeeCto.getPhones(), PhoneEntity.class));

		// initialize, validate employeeEntity here if necessary
		EmployeeEntity resultEntity = getEmployeeRepository().save(employeeEntity);
		LOG.debug("Employee with id '{}' has been created.", resultEntity.getId());
		EmployeeCto employeeCtoResult = new EmployeeCto();
		employeeCtoResult.setEmployee(getBeanMapper().map(resultEntity, EmployeeEto.class));
		employeeCtoResult.setPhones(getBeanMapper().mapList(resultEntity.getPhones(), PhoneEto.class));
		return employeeCtoResult;
	}
}
