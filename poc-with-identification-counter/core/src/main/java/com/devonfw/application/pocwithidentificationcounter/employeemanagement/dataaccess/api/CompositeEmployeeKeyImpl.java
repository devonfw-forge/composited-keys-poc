package com.devonfw.application.pocwithidentificationcounter.employeemanagement.dataaccess.api;


import java.io.Serializable;

import javax.persistence.Embeddable;

import com.devonfw.application.pocwithidentificationcounter.employeemanagement.common.api.CompositeEmployeeKey;

@Embeddable
public class CompositeEmployeeKeyImpl extends CompositeEmployeeKey implements Serializable{

	private static final long serialVersionUID = 1L;
	private String companyId;
	private String employeeId;


	public CompositeEmployeeKeyImpl() {
	}

	public CompositeEmployeeKeyImpl(String mixed) {
		super();
		String[] stringVar = mixed.split(",");
		this.companyId = stringVar[0];
		this.employeeId = stringVar[1];
	}

	public CompositeEmployeeKeyImpl(CompositeEmployeeKey compositeEmployeeKey) {
		super();
		this.companyId = compositeEmployeeKey.getCompanyId();
		this.employeeId = compositeEmployeeKey.getEmployeeId();
	}

	public CompositeEmployeeKeyImpl(String companyId, String employeeId) {
		super();
		this.companyId = companyId;
		this.employeeId = employeeId;
	}

	@Override
	public String getCompanyId() {
		return companyId;
	}

	@Override
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Override
	public String getEmployeeId() {
		return employeeId;
	}

	@Override
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof CompositeEmployeeKeyImpl) ) return false;

        final CompositeEmployeeKeyImpl compositeEmployeeKeyImpl = (CompositeEmployeeKeyImpl) other;

        if ( !compositeEmployeeKeyImpl.getCompanyId().equals( getCompanyId() ) ) return false;
        if ( !compositeEmployeeKeyImpl.getEmployeeId().equals( getEmployeeId() ) ) return false;

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
