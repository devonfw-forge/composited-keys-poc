package com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api;

import java.util.List;

import javax.persistence.CascadeType;
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
public class EmployeeEntity extends ApplicationComposedKeyPersistenceEntity<CompositeEmployeeKey> implements Employee {

  private String name;

  private String lastName;

  private List<PhoneEntity> phones;

  private static final long serialVersionUID = 1L;

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getLastName() {

    return this.lastName;
  }

  @Override
  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
  public List<PhoneEntity> getPhones() {

    return this.phones;
  }

  public void setPhones(List<PhoneEntity> phones) {

    this.phones = phones;
  }

}
