package com.devonfw.application.pocwithidentificationcounter.employeemanagement.logic.api.to;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;
import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.Employee;
import com.devonfw.application.pocwithidentificationcounter.general.common.api.to.AbstractComposedKeyEto;

/**
 * Entity transport object of Employee
 */
public class EmployeeEto extends AbstractComposedKeyEto<CompositeEmployeeKey> implements Employee {

  private static final long serialVersionUID = 1L;

  private String name;

  private String lastName;

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

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    EmployeeEto other = (EmployeeEto) obj;
    if (getId() == null) {
      if (other.getId() != null) {
        return false;
      }
    } else if (!getId().equals(other.getId())) {
      return false;
    }
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!this.lastName.equals(other.lastName)) {
      return false;
    }
    return true;
  }

}
