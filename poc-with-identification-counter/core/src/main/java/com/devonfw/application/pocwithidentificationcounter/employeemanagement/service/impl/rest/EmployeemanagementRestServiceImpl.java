package com.devonfw.application.pocwithidentificationcounter.employeemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.Employeemanagement;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeCto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeEto;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.service.api.rest.EmployeemanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Employeemanagement}.
 */
@Named("EmployeemanagementRestService")
public class EmployeemanagementRestServiceImpl implements EmployeemanagementRestService {

	@Inject
	private Employeemanagement employeemanagement;

	 @Override
	  public EmployeeEto getEmployee(String employeeId, String companyId) {

	    return this.employeemanagement.findEmployee(new CompositeEmployeeKey(companyId, employeeId));
	  }

	@Override
	public EmployeeEto saveEmployee(EmployeeEto employee) {
		return this.employeemanagement.saveEmployee(employee);
	}

	  @Override
	  public void deleteEmployee(String employeeId, String companyId) {

	    this.employeemanagement.deleteEmployee(new CompositeEmployeeKey(companyId, employeeId));

	  }
	@Override
	public Page<EmployeeEto> findEmployees(EmployeeSearchCriteriaTo searchCriteriaTo) {
		return this.employeemanagement.findEmployees(searchCriteriaTo);
	}

	  @Override
	  public EmployeeCto getEmployeeCto(String employeeId, String companyId) {

	    return this.employeemanagement.findEmployeeCto(new CompositeEmployeeKey(companyId, employeeId));
	  }

	@Override
	public Page<EmployeeCto> findEmployeeCtos(EmployeeSearchCriteriaTo searchCriteriaTo) {
		return this.employeemanagement.findEmployeeCtos(searchCriteriaTo);
	}

	@Override
	public EmployeeCto saveEmployeePhone(EmployeeCto employee) {
		return this.employeemanagement.saveEmployeePhone(employee);
	}

}
