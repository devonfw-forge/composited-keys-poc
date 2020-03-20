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
 * The service implementation for REST calls in order to execute the logic of component {@link Employeemanagement}.
 */
@Named("EmployeemanagementRestService")
public class EmployeemanagementRestServiceImpl implements EmployeemanagementRestService {

  @Inject
  private Employeemanagement employeemanagement;

  @Override
  public EmployeeEto getEmployee(CompositeEmployeeKey id) {

    return this.employeemanagement.findEmployee(id);
  }

  @Override
  public EmployeeEto saveEmployee(EmployeeEto employee) {

    return this.employeemanagement.saveEmployee(employee);
  }

  @Override
  public void deleteEmployee(CompositeEmployeeKey id) {

    this.employeemanagement.deleteEmployee(id);
  }

  @Override
  public Page<EmployeeEto> findEmployees(EmployeeSearchCriteriaTo searchCriteriaTo) {

    return this.employeemanagement.findEmployees(searchCriteriaTo);
  }

  @Override
  public EmployeeCto getEmployeeCto(CompositeEmployeeKey id) {

    return this.employeemanagement.findEmployeeCto(id);
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
