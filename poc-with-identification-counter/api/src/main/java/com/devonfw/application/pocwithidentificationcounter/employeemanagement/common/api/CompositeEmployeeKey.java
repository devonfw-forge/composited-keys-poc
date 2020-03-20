package com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api;

import java.io.Serializable;

public class CompositeEmployeeKey implements Serializable {

  private static final long serialVersionUID = 1L;

  private String companyId;

  private String employeeId;

  public CompositeEmployeeKey() {

  }

  public CompositeEmployeeKey(String mixed) {

    super();
    String[] stringVar = mixed.split(",");
    this.companyId = stringVar[0];
    this.employeeId = stringVar[1];
  }

  public CompositeEmployeeKey(String companyId, String employeeId) {

    super();
    this.companyId = companyId;
    this.employeeId = employeeId;
  }

  public String getCompanyId() {

    return this.companyId;
  }

  public void setCompanyId(String companyId) {

    this.companyId = companyId;
  }

  public String getEmployeeId() {

    return this.employeeId;
  }

  public void setEmployeeId(String employeeId) {

    this.employeeId = employeeId;
  }

  @Override
  public boolean equals(Object other) {

    if (this == other)
      return true;
    if (!(other instanceof CompositeEmployeeKey))
      return false;

    final CompositeEmployeeKey compositeEmployeeKey = (CompositeEmployeeKey) other;

    if (!compositeEmployeeKey.getCompanyId().equals(getCompanyId()))
      return false;
    if (!compositeEmployeeKey.getEmployeeId().equals(getEmployeeId()))
      return false;

    return true;
  }

  @Override
  public int hashCode() {

    int result;
    result = getCompanyId().hashCode();
    result = 29 * result + getEmployeeId().hashCode();
    return result;
  }
}
